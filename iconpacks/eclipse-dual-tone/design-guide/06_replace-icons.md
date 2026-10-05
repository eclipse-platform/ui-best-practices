# 06 How to Replace Icons (Prototype State)

The `IconReplacer` tool copies the dual tone icons into the actual Eclipse plugin repositories on your machine, based on the `icon-mapping.json`. Once replaced, a dedicated Eclipse demo instance can be launched to preview the icons live in the IDE.

> **Note:** The tool replaces icons in workspace repositories only — it does not modify an installed Eclipse application directly.

---

## Open the Project in VS Code

1. Open VS Code.
2. Go to **File → Open Folder** and select the `ui-best-practices` repository root.
3. Make sure the following paths are present in the project:
   - `iconpacks/eclipse-dual-tone/icon-mapping.json`
   - `iconpacks/eclipse-dual-tone/dual-tone-icons/`
   - `iconpacks/IconReplacementAlgorithm/IconReplacer.java`

---

## Compile the Java File

1. Open the integrated terminal in VS Code with `` Ctrl+` `` (or **Terminal → New Terminal**).
2. Navigate to the `IconReplacementAlgorithm` folder:
   ```bash
   cd iconpacks/IconReplacementAlgorithm
   ```
3. Compile the Java file:
   ```bash
   javac IconReplacer.java
   ```
   If successful, a `IconReplacer.class` file appears in the same folder. No output means compilation succeeded.

---

## Start the Replacement Process

Run the compiled tool with two arguments: the path to the `eclipse-dual-tone` directory and the path to the root directory containing the Eclipse plugin repositories.

```bash
java IconReplacer \
  /home/user/Documents/GitHub/ui-best-practices/iconpacks/eclipse-dual-tone \
  /home/user/icons_demo
```

- **Argument 1** — path to the `eclipse-dual-tone` folder (contains `icon-mapping.json` and `dual-tone-icons/`)
- **Argument 2** — path to the root folder that contains all Eclipse workspace repositories

The tool walks the repository tree, matches each original icon path from `icon-mapping.json`, and copies the corresponding dual tone SVG over it. Each replaced file is printed to the terminal:

```
Replaced: /home/user/icons_demo/org.eclipse.jdt.ui/icons/full/etool16/run_exc.svg
Replaced: /home/user/icons_demo/org.eclipse.ui/icons/full/ovr16/warning_ovr.svg
...
```

If an icon from the mapping is not found in the repositories, it is skipped with a message:
```
New icon not found: ...
```

---

## Show the Finished Replacement in Eclipse IDE

Launch a dedicated Eclipse demo instance to preview the replaced icons live.

### If a Run Configuration already exists

1. Open Eclipse: `~/icon_project_demo_workspace/Eclipse.app`
2. Select the existing Run Configuration and click **Run**.
3. A second Eclipse instance opens with the replaced icons applied.

### If no Run Configuration exists (first-time setup)

1. **Start the demo Eclipse instance:**
   ```
   ~/icon_project_demo_workspace/Eclipse.app
   ```
2. **Import the plugin repositories into the workspace:**
   - Go to **File → Import → Git → Projects from Git**
   - Follow the wizard to import the repositories from `/home/user/icons_demo`
3. **Create a new Run Configuration:**
   - Go to **Run → Run Configurations**
   - Select **Eclipse Application** in the left panel and click **New** (the blank page icon)
   - Leave all default settings and click **Apply**
4. **Start the demo instance** by clicking **Run** — a new Eclipse window opens with the replaced icons visible throughout the IDE.
