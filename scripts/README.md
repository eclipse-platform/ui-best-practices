# Scripts

## ExtractTraditionalIcons.java

Extracts the original Eclipse icons referenced in `iconpacks/eclipse-dual-tone/icon-mapping.json`
from an existing Eclipse installation and saves them into `iconpacks/eclipse-traditional-icons/`.
It also produces an `icon-restore-mapping.json` that maps every extracted icon path back to the
dual-tone icon name that replaced it, so a restore script can undo the dual-tone replacement.

### Requirements

- Java 11 or later (single-file launch via `java SourceFile.java`)
- No external dependencies

### Usage

Run from the repository root:

```bash
java scripts/ExtractTraditionalIcons.java <eclipse-dir> [icon-mapping.json] [output-dir]
```

| Argument | Default |
|---|---|
| `eclipse-dir` | *(required)* path to the Eclipse installation |
| `icon-mapping.json` | `iconpacks/eclipse-dual-tone/icon-mapping.json` |
| `output-dir` | `iconpacks/eclipse-traditional-icons` |

### Example

```bash
java scripts/ExtractTraditionalIcons.java /opt/eclipse
```

### Output

```
iconpacks/eclipse-traditional-icons/
├── icon-restore-mapping.json          # maps each Eclipse path → dual-tone icon name
├── org.eclipse.debug.ui/
│   └── icons/full/elcl16/
│       ├── hierarchicalLayout.svg
│       └── ...
├── org.eclipse.jdt.ui/
│   └── ...
└── ...
```

**`icon-restore-mapping.json`** has the following format:

```json
{
  "org.eclipse.ui/icons/full/etool16/undo_edit.svg": "undo.svg",
  "org.eclipse.search/icons/full/elcl16/flatLayout.svg": "flat_layout.svg",
  ...
}
```

Each key is the Eclipse-relative path of the backed-up icon (mirrored under `eclipse-traditional-icons/`).
Each value is the dual-tone icon name from `icon-mapping.json` that replaced it.

### Notes

- Plugin JARs (e.g. `org.eclipse.debug.ui_3.x.x.jar`) and expanded plugin directories are both supported.
- Icons from optional plugins not present in the target installation are skipped and reported as missing.
- The script is idempotent: re-running it overwrites previously extracted files.
