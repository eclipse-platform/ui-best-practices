# 02 How to Propose a New Icon Design

Before designing a new icon, you first need to identify it within Eclipse and document it properly via a GitHub issue. This process ensures that no duplicate work happens and that reviewers have all the context they need.

---

## Choose an Icon in the Eclipse IDE

Start by browsing the Eclipse IDE to find an icon that is outdated, missing, or in need of improvement.

1. Open the Eclipse IDE.
2. Navigate through menus, toolbars, views, and dialogs to find candidate icons.
3. Note the name of the icon and the plugin/view it belongs to so you can locate the original file later.

> **Tip:** Icons that are still rasterized (`.png`, `.gif`) or visually inconsistent with the rest of the pack are good candidates.

---

## Look for Existing Icons as Possible Replacements or Reusable Parts

Before starting from scratch, check whether an icon already exists in the dual tone pack that could serve as a replacement or provide reusable design elements.

1. Browse the [`dual-tone-icons/`](../dual-tone-icons/) folder in the repository.
2. Check the [`components/`](../components/) folder for building blocks (File, Folder, Run, New, etc.) that could be incorporated into your new design.
3. Search the [`icon-mapping.json`](../icon-mapping.json) to see if the icon is already mapped to an existing dual tone icon.

If a suitable replacement or reusable part exists, note it — you will need this information when filling out the issue template.

---

## Create a New Issue on GitHub

Once you have identified your icon and checked for existing assets, open a GitHub issue to propose the new design.

1. Navigate to the repository's **Issues** tab on GitHub.
2. Click **New Issue**.
3. Select the **"Suggest an enhancement"** issue type.
4. Delete the pre-filled issue template content — you will replace it with the project-specific template in the next step.

---

## Copy the Issue Template

The project uses a dedicated issue template to capture all required information consistently.

Copy the following template into the issue body:

```
Dual-Tone-Icon-Pack: Platform Icon "<icon-name>"

**Old Name:**

**New Name:**

**Purpose of use:**

**Location:**

**Known Duplicates:**

**Original:**

**Sketch for orientation:**

**Similar Dual-Tone Icons to reuse parts from:**
```

---

## Fill Out the Template

Fill in each field with information about the icon you want to propose.

| Field | What to enter |
|-------|---------------|
| **Title** | `Dual-Tone-Icon-Pack: Platform Icon "<icon-name>"` — replace `<icon-name>` with the icon's actual name |
| **Old Name** | The current file name of the icon as found in the Eclipse plugin (e.g. `run_exc.png`) |
| **New Name** | The proposed new file name following the naming convention of the dual tone pack (e.g. `run.svg`) |
| **Purpose of use** | A short description of what the icon represents and where it is used in the IDE |
| **Location** | The plugin and path where the original icon lives (e.g. `org.eclipse.debug.ui/icons/full/etool16/`) |
| **Known Duplicates** | Other icons in Eclipse that look the same or very similar — list their names and locations |
| **Original** | Attach a screenshot or paste a direct link to the original icon file |
| **Sketch for orientation** | Attach a rough sketch or reference image showing the intended design direction |
| **Similar Dual-Tone Icons to reuse parts from** | List any existing dual tone icons whose shapes or components could be reused in the new design |

Once the template is fully filled out, submit the issue. A maintainer will review it and confirm whether to proceed.

---

## Next Steps

With an approved issue in place, you are ready to open Inkscape and design the icon. Continue with the next guide to learn about the icon design workflow in Inkscape.
