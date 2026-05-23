import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import java.util.regex.*;

/**
 * Extracts the original (traditional) Eclipse icons referenced in
 * iconpacks/eclipse-dual-tone/icon-mapping.json from an existing Eclipse
 * installation, storing them under iconpacks/eclipse-traditional-icons/.
 *
 * Also produces icon-restore-mapping.json in that folder, which maps every
 * Eclipse-relative icon path back to the dual-tone icon name that replaced it.
 * A restore script can use that file to undo the dual-tone replacement.
 *
 * Usage:
 *   java ExtractTraditionalIcons.java <eclipse-dir> [icon-mapping.json] [output-dir]
 *
 * Defaults:
 *   icon-mapping.json  -> iconpacks/eclipse-dual-tone/icon-mapping.json
 *   output-dir         -> iconpacks/eclipse-traditional-icons
 */
public class ExtractTraditionalIcons {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java ExtractTraditionalIcons.java <eclipse-dir> [icon-mapping.json] [output-dir]");
            System.exit(1);
        }

        Path eclipseDir   = Path.of(args[0]);
        Path mappingFile  = Path.of(args.length > 1 ? args[1] : "iconpacks/eclipse-dual-tone/icon-mapping.json");
        Path outputDir    = Path.of(args.length > 2 ? args[2] : "iconpacks/eclipse-traditional-icons");
        Path pluginsDir   = eclipseDir.resolve("plugins");

        if (!Files.isDirectory(pluginsDir)) {
            System.err.println("Eclipse plugins directory not found: " + pluginsDir);
            System.exit(1);
        }

        System.out.println("Eclipse dir  : " + eclipseDir);
        System.out.println("Mapping file : " + mappingFile);
        System.out.println("Output dir   : " + outputDir);
        System.out.println();

        Map<String, List<String>> iconMapping = parseIconMapping(mappingFile);

        // Collect all unique Eclipse icon paths (values in the mapping).
        // Preserve insertion order so the output mapping stays readable.
        Set<String> allEclipsePaths = new LinkedHashSet<>();
        for (List<String> paths : iconMapping.values()) {
            allEclipsePaths.addAll(paths);
        }

        Files.createDirectories(outputDir);

        // Index: pluginId -> matching path (dir or jar) in the Eclipse plugins folder.
        // Built lazily and cached to avoid repeated directory scans.
        Map<String, Path> pluginCache = new HashMap<>();
        List<Path> pluginEntries = Files.list(pluginsDir).toList();

        int extracted = 0;
        int missing   = 0;

        // restoreMapping: eclipsePath -> dualToneIconName
        Map<String, String> restoreMapping = new LinkedHashMap<>();

        // Build the dual-tone lookup once (eclipse path -> dual-tone key)
        Map<String, String> eclipsePathToDualTone = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : iconMapping.entrySet()) {
            for (String eclipsePath : entry.getValue()) {
                eclipsePathToDualTone.put(eclipsePath, entry.getKey());
            }
        }

        for (String eclipsePath : allEclipsePaths) {
            int slash = eclipsePath.indexOf('/');
            if (slash < 0) {
                System.err.println("Skipping malformed path: " + eclipsePath);
                continue;
            }
            String pluginId    = eclipsePath.substring(0, slash);
            String iconRelPath = eclipsePath.substring(slash + 1);

            Path pluginEntry = pluginCache.computeIfAbsent(pluginId,
                    id -> findPlugin(pluginEntries, id));

            if (pluginEntry == null) {
                System.err.println("  MISSING plugin : " + pluginId);
                missing++;
                continue;
            }

            Path dest = outputDir.resolve(eclipsePath);
            boolean ok;
            if (Files.isDirectory(pluginEntry)) {
                ok = extractFromDirectory(pluginEntry, iconRelPath, dest);
            } else {
                ok = extractFromJar(pluginEntry, iconRelPath, dest);
            }

            if (ok) {
                restoreMapping.put(eclipsePath, eclipsePathToDualTone.get(eclipsePath));
                System.out.println("  OK  " + eclipsePath);
                extracted++;
            } else {
                System.err.println("  MISSING icon   : " + eclipsePath + "  (in " + pluginEntry.getFileName() + ")");
                missing++;
            }
        }

        Path restoreMappingFile = outputDir.resolve("icon-restore-mapping.json");
        writeRestoreMapping(restoreMappingFile, restoreMapping);

        System.out.println();
        System.out.println("Extracted : " + extracted + " / " + allEclipsePaths.size());
        System.out.println("Missing   : " + missing);
        System.out.println("Restore mapping -> " + restoreMappingFile);
    }

    // -------------------------------------------------------------------------
    // Plugin lookup
    // -------------------------------------------------------------------------

    /** Finds the first directory or JAR in {@code entries} whose name matches {@code pluginId}. */
    private static Path findPlugin(List<Path> entries, String pluginId) {
        for (Path entry : entries) {
            String name = entry.getFileName().toString();
            // Matches: "org.eclipse.foo", "org.eclipse.foo_1.2.3.jar", "org.eclipse.foo_1.2.3/"
            if (name.equals(pluginId)
                    || name.startsWith(pluginId + "_")
                    || name.equals(pluginId + ".jar")) {
                return entry;
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Extraction helpers
    // -------------------------------------------------------------------------

    private static boolean extractFromDirectory(Path pluginDir, String iconRelPath, Path dest) throws IOException {
        Path source = pluginDir.resolve(iconRelPath);
        if (!Files.exists(source)) return false;
        Files.createDirectories(dest.getParent());
        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    private static boolean extractFromJar(Path jarPath, String iconRelPath, Path dest) throws IOException {
        try (JarFile jar = new JarFile(jarPath.toFile())) {
            JarEntry entry = jar.getJarEntry(iconRelPath);
            if (entry == null) return false;
            Files.createDirectories(dest.getParent());
            try (InputStream is = jar.getInputStream(entry)) {
                Files.copy(is, dest, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        }
    }

    // -------------------------------------------------------------------------
    // JSON parsing  (no external library required)
    // -------------------------------------------------------------------------

    /**
     * Parses the icon-mapping.json format:
     * <pre>
     * {
     *   "key": ["path/a.svg", "path/b.svg"],
     *   ...
     * }
     * </pre>
     */
    private static Map<String, List<String>> parseIconMapping(Path file) throws IOException {
        String content = Files.readString(file);
        Map<String, List<String>> result = new LinkedHashMap<>();

        // Match each "key": [...] block
        Pattern blockPattern = Pattern.compile(
                "\"([^\"]+)\"\\s*:\\s*\\[([^\\]]*?)\\]",
                Pattern.DOTALL);
        Pattern stringPattern = Pattern.compile("\"([^\"]+)\"");

        Matcher blockMatcher = blockPattern.matcher(content);
        while (blockMatcher.find()) {
            String key      = blockMatcher.group(1);
            String arrayStr = blockMatcher.group(2);
            List<String> values = new ArrayList<>();
            Matcher valMatcher = stringPattern.matcher(arrayStr);
            while (valMatcher.find()) {
                values.add(valMatcher.group(1));
            }
            result.put(key, values);
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // Output mapping
    // -------------------------------------------------------------------------

    /**
     * Writes icon-restore-mapping.json.
     * Format: { "eclipse/plugin/path/icon.svg": "dual-tone-icon-name.svg", ... }
     *
     * A restore script reads this file and, for each entry:
     *   - copies  eclipse-traditional-icons/<key>
     *   - back to Eclipse plugins/<pluginId_version>/<iconRelPath>
     */
    private static void writeRestoreMapping(Path outputFile, Map<String, String> mapping) throws IOException {
        StringBuilder sb = new StringBuilder("{\n");
        int i = 0;
        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            if (i++ > 0) sb.append(",\n");
            sb.append("  \"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\"");
        }
        sb.append("\n}\n");
        Files.writeString(outputFile, sb.toString());
    }
}
