<img width=100% height=100% alt="image" src="https://github.com/user-attachments/assets/00194d80-d7ad-483a-8bae-9c13a0afa747" />

# Eclipse Dual Tone Icon Pack

A community-driven collection of refreshed, high-quality vector icons for the Eclipse IDE. This project replaces outdated raster icons with clean, scalable SVG alternatives organized as a dual tone design system.

<img width=40% height=40% alt="image" src="https://github.com/user-attachments/assets/cf094dc2-7644-414b-ba16-21f3f04a4561" />

---

## Repository Structure

```
eclipse-dual-tone/
├── dual-tone-icons/               # 311 finished SVG icons
├── components/                    # Reusable design building blocks (14 components)
├── design-guide/                  # Step-by-step guides for contributors
├── icon-creation-process-templates/  # Issue, PR and quality review templates
├── icon-mapping.json              # Maps dual tone icons to original Eclipse plugin paths
├── semantic-icon-library.json     # Short descriptions for every icon
├── STYLE_GUIDE.md                 # Visual design rules for the icon pack
└── Issue-Template.md              # Template for proposing new icons
```

---

## Design Guide

New to the project? The design guide walks you through every step — from setting up your tools to submitting a pull request.

| # | Guide | Topic |
|---|-------|-------|
| 01 | [Getting Started](design-guide/01_getting-started.md) | Download Inkscape, clone the repo, read the Style Guide |
| 02 | [Propose a New Icon](design-guide/02_propose-new-icon-design.md) | Find an icon in Eclipse, check for duplicates, open a GitHub issue |
| 03 | [Create a Standard Icon](design-guide/03_create-standard-icon.md) | Inkscape setup, drawing rules, checklist |
| 04 | [Create a Dual Tone Icon](design-guide/04_create-dual-tone-icon.md) | Base icon + key element, cutout technique, checklist |
| 05 | [Contribute an Icon](design-guide/05_contribute-icon.md) | Branch, JSON updates, pull request, reviewer |
| 06 | [Replace Icons (Prototype)](design-guide/06_replace-icons.md) | Run the IconReplacer tool, preview in Eclipse |

---

## Style Guide

The [Style Guide](STYLE_GUIDE.md) defines the visual rules all icons must follow:

- **Canvas:** 16 × 16 px, key element 8 × 8 px
- **Strokes:** 2 px, round cap and join
- **Corners:** 1.0 px radius
- **Spacing:** 1.5 px minimum between elements

**Color system:**

| Color | Hex | Purpose |
|-------|-----|---------|
| Gray | `#A8A8A8` | Base icons |
| Green | `#499C54` | Run, New, OK |
| Red | `#C80000` | Error, Stop |
| Yellow | `#FFD700` | Warnings |
| Blue | `#0065C7` | General information |
| Orange | `#FF7F27` | Interaction (e.g. Pause) |

---

## Reusable Components

The [`components/`](components/) folder contains ready-to-use SVG building blocks. Use them when designing new icons to ensure visual consistency.

| Component | File |
|-----------|------|
| New | `component_new.svg` |
| Run | `component_run.svg` |
| Import | `component_import.svg` |
| Export | `component_export.svg` |
| File | `component_file.svg` |
| Folder | `component_folder.svg` |
| Project | `component_project.svg` |
| Group | `component_group.svg` |
| Write | `component_write.svg` |
| Compare | `component_compare.svg` |
| Single Rectangle | `component_single_rectangle.svg` |
| Double Rectangle | `component_double_rectangle.svg` |
| Repeat Action | `component_repeat-action.svg` |
| Java | `component-java.svg` |

---

## Templates

| Template | Purpose |
|----------|---------|
| [Issue Template](icon-creation-process-templates/GitHub-Issue-Template.md) | Use when proposing a new icon via a GitHub issue |
| [Pull Request Template](icon-creation-process-templates/GitHub-Pull-Request-Template.md) | Use when submitting a finished icon |
| [Quality Review Template](icon-creation-process-templates/Quality_Review_Template.svg) | Paste your icon onto all background swatches for the PR review |

---

## Contributing

1. Start with the [Design Guide](design-guide/01_getting-started.md).
2. Pick an open issue labelled **enhancement** or [propose a new icon](design-guide/02_propose-new-icon-design.md).
3. Design the icon following the [Style Guide](STYLE_GUIDE.md).
4. Submit a pull request following [guide 05](design-guide/05_contribute-icon.md) and request a review from **@jasmin261098** or **@BeckerWdf**.

No contribution is too small — even a single icon makes a difference. Thank you for helping to improve Eclipse!
