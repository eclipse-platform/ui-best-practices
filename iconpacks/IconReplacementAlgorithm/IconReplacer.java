import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class IconReplacer {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: IconReplacer <eclipse-dual-tone-directory> <git-repositories-root-directory>");
            return;
        }
        Path dualToneIconPackDirectory = Paths.get(args[0]);
        Path repositoriesDirectory = Paths.get(args[1]);
        Path mappingFile = dualToneIconPackDirectory.resolve("icon-mapping.json");
        Path iconsDirectory = dualToneIconPackDirectory.resolve("dual-tone-icons");

        Map<String, List<String>> iconMapping = parseIconMapping(mappingFile);

        for (Map.Entry<String, List<String>> entry : iconMapping.entrySet()) {
            String newIconName = entry.getKey();
            Path newIconPath = iconsDirectory.resolve(newIconName);
            if (!Files.exists(newIconPath)) {
                System.out.println("New icon not found: " + newIconPath);
                continue;
            }
            for (String oldIconRelativePath : entry.getValue()) {
                // Search for old icon in all repos
                try {
                    Files.walk(repositoriesDirectory)
                            .filter(p -> p.toString().endsWith(oldIconRelativePath.replace("/", File.separator)))
                            .forEach(oldIconPath -> {
                                try {
                                    Files.copy(newIconPath, oldIconPath, StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("Replaced: " + oldIconPath);
                                } catch (IOException e) {
                                    System.out.println("Failed to replace: " + oldIconPath);
                                }
                            });
                } catch (IOException e) {
                    System.out.println("Error searching for: " + oldIconRelativePath);
                }
            }
        }
    }

    // JSON parser for icon-mapping.json
    private static Map<String, List<String>> parseIconMapping(Path mappingFile) throws IOException {
        Map<String, List<String>> map = new LinkedHashMap<>();
        String content = new String(Files.readAllBytes(mappingFile));
        Pattern entryPattern = Pattern.compile("\"([^\"]+)\"\\s*:\\s*\\[(.*?)\\]", Pattern.DOTALL);
        Matcher matcher = entryPattern.matcher(content);
        while (matcher.find()) {
            String key = matcher.group(1);
            String valueList = matcher.group(2);
            List<String> values = new ArrayList<>();
            Pattern valuePattern = Pattern.compile("\"([^\"]+)\"");
            Matcher valueMatcher = valuePattern.matcher(valueList);
            while (valueMatcher.find()) {
                values.add(valueMatcher.group(1));
            }
            map.put(key, values);
        }
        return map;
    }
}