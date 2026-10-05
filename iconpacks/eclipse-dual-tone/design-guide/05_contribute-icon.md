# 05 How to Contribute a New Icon Design

Once your icon design is finished and passes the Style Guide checklist, follow these steps to contribute it to the repository.

---

## Create a New Branch

All contributions are made from a dedicated branch — never commit directly to `main`.

1. Make sure your local `main` branch is up to date:
   ```bash
   git checkout main
   git pull
   ```
2. Create a new branch using the naming convention `Add-Icon-<icon-name>`:
   ```bash
   git checkout -b Add-Icon-<icon-name>
   ```
   For example:
   ```bash
   git checkout -b Add-Icon-clipboard-variable
   ```
3. Add the finished SVG file to the `dual-tone-icons/` folder:
   ```bash
   cp path/to/your/<icon-name>.svg dual-tone-icons/
   ```
4. Stage and commit the file, referencing the GitHub issue in the commit message:
   ```bash
   git add dual-tone-icons/<icon-name>.svg
   git commit -m "Add Icon <icon-name>.svg

   Fixes: <link to issue>"
   ```
5. Push the branch to GitHub:
   ```bash
   git push -u origin Add-Icon-<icon-name>
   ```

---

## Update the Icon Mapping and Semantic Icon Library

Two JSON files must be updated alongside every new icon. Both files live in the root of the `eclipse-dual-tone/` folder.

### `icon-mapping.json`

This file maps each dual tone icon to the original Eclipse plugin path(s) it replaces. Add an entry for your icon:

```json
"<icon-name>.svg": [
  "org.eclipse.<plugin>/icons/full/<folder>/<original-name>.svg"
]
```

The original plugin path can be found in the **Location** field of the GitHub issue. If the icon replaces multiple originals, list all of them as separate entries in the array:

```json
"<icon-name>.svg": [
  "org.eclipse.<plugin>/icons/full/etool16/<original-name>.svg",
  "org.eclipse.<plugin>/icons/full/elcl16/<original-name>.svg"
]
```

### `semantic-icon-library.json`

This file contains a short description of what each icon represents. Add one line for your icon:

```json
"<icon-name>.svg": "Short description of what the icon represents."
```

Keep the description concise — one sentence, starting with a verb or noun (e.g. `"Indicates a running action."`, `"Opens the file explorer."`). Look at existing entries in the file for reference.

### Commit the JSON updates

Stage and commit both files together:

```bash
git add icon-mapping.json semantic-icon-library.json
git commit -m "Update icon mapping and semantic library for <icon-name>"
```

---

## Create a Pull Request Linking the Resolved Issue

1. Go to the repository on GitHub and open the **Pull Requests** tab.
2. Click **New Pull Request** and select your branch (`Add-Icon-<icon-name>`) as the source, with `main` as the target.
3. Use the PR template below as the PR description. Copy it into the description field:

   ```
   **Dual-Tone-Icon-Pack: Platform Icon "<icon-name>"**

   **Name:**
   <!-- e.g. show_view.svg -->

   **Quality Review:**
   <!-- Paste Quality_Review_Template with finished icon -->

   Fixes <!-- insert link to issue -->.
   ```

4. Fill in each field:

   | Field | What to enter |
   |-------|---------------|
   | **Title** | `Dual-Tone-Icon-Pack: Platform Icon "<icon-name>"` |
   | **Name** | The SVG file name (e.g. `clipboard-variable.svg`) |
   | **Quality Review** | Open [`Quality_Review_Template.svg`](../icon-creation-process-templates/Quality_Review_Template.svg) in Inkscape, place your finished icon on all background swatches (white, light gray, dark gray, black), export as PNG or SVG, and paste it here |
   | **Fixes** | The full URL of the GitHub issue this PR resolves |

5. Submit the PR.

---

## Mark a Reviewer

After submitting the PR, request a review from one of the maintainers:

- **@jasmin261098**
- **@BeckerWdf**

To assign a reviewer on GitHub:
1. Open your PR.
2. In the right-hand sidebar, click the gear icon next to **Reviewers**.
3. Search for and select one of the maintainers listed above.

The reviewer will check the icon design, the mapping, and the semantic library entry before approving the merge. Address any feedback they leave as comments and push updated commits to the same branch — the PR updates automatically.

Once the review is approved, a maintainer will merge the PR.
