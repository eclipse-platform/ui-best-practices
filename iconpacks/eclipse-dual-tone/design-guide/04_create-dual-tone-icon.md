# 04 How to Create a New Icon Design — Dual Tone Icon

A dual tone icon combines a gray base icon with a smaller, colored **key element** placed in a corner. This guide covers all the additional steps on top of the standard icon workflow that are specific to dual tone icons.

> **Prerequisite:** Read [03 How to Create a New Icon Design — Standard Icon](03_create-standard-icon.md) first. This guide only covers the parts that differ or extend that workflow.

---

## Choose an Existing Issue on GitHub

Follow the same steps as for a standard icon (see guide 03). When reading the issue, pay extra attention to:

- The **purpose of use** field — this determines which key element color to use.
- The **Similar Dual-Tone Icons** field — referenced icons may have a key element you can reuse directly.

---

## Open Inkscape and Set All Preferences

Follow the same Inkscape setup steps as for a standard icon (see guide 03):

- Set the canvas to 16 × 16 px
- Enable the 1 px grid with origin at 0
- Set stroke defaults to 2 px, round cap, round join

---

## Build the Base Icon According to the Style Guide

Design the gray base icon following the same rules as a standard icon (see guide 03). At this stage, build the base icon as if there were no key element — fill the full canvas normally. The cutout for the key element is created in a later step using a precise technique.

---

## Build the Key Element According to the Style Guide

The key element is a small, colored shape placed in a corner that communicates the icon's action or state at a glance.

### Size and placement rules

- The key element must have a width **and/or** height of exactly **8 px**.
- Place it in the **bottom-right corner** of the 16 × 16 px canvas (top-right is also valid).

### Using an existing component

Check the [`components/`](../components/) folder first — several ready-to-use key element SVGs are available:

| Component file | Key element |
|---------------|-------------|
| `component_new.svg` | Green "+" (New / Add) |
| `component_run.svg` | Green triangle (Run) |
| `component_import.svg` | Import arrow |
| `component_export.svg` | Export arrow |

Open the relevant component SVG, copy the key element path, and paste it into your working file. This guarantees consistent shape and sizing.

### Drawing a custom key element

If no existing component fits, draw the key element from scratch:

1. Draw the shape so it fits within 8 × 8 px — verify with the **W** and **H** fields in the toolbar.
2. Apply the same stroke rules as the base icon: 2 px width, round cap, round join, 1.0 px corner radius.

---

## Choose the Correct Color for the Key Element

The key element color must match the icon's purpose. Use the table below — the same one from the Style Guide:

| Color | Hex | When to use |
|-------|-----|-------------|
| Green | `#499C54` | Run, New, OK, Add |
| Red | `#C80000` | Error, Stop, Remove |
| Yellow | `#FFD700` | Warning |
| Blue | `#0065C7` | General information |
| Orange | `#FF7F27` | Interaction (e.g. Pause) |

Apply the color to the key element path via **Object → Fill and Stroke** (`Shift+Ctrl+F`). Enter the hex value in the fill color field.

---

## Cut Out the Key Element from the Base Icon

The 1.5 px gap between the base icon and the key element is created by expanding the key element's outline by exactly 1.5 px on all sides and using that expanded shape to cut into the base icon. A 3 px stroke expands 1.5 px outward on each side, making it the perfect tool for generating the cutout shape.

> **Video demo:** [Demo_Formen_ausschneiden.mov](Demo_Formen_ausschneiden.mov)

### Steps

1. **Duplicate the key element in place** — select the key element and press `Ctrl+D`. The copy lands exactly on top of the original.

2. **Add a 3 px stroke to the copy** — with the duplicate selected, open **Object → Fill and Stroke** (`Shift+Ctrl+F`):
   - Set **Fill** to none.
   - Set **Stroke paint** to any flat color (the color doesn't matter, it will be discarded).
   - Set **Stroke width** to `3 px` with round cap and round join.

3. **Convert the stroke to a path** — go to **Path → Stroke to Path** (`Ctrl+Alt+C`). This turns the 3 px outline into a filled path that is 1.5 px larger than the key element on every side.

4. **Ungroup the result** — go to **Object → Ungroup** (`Ctrl+Shift+G`) and repeat until the result is a single flat path with no groups.

5. **Cut out from the base icon** — select the base icon path first, then `Shift+click` the expanded cutout shape. Go to **Path → Difference** (`Ctrl+–`). Inkscape subtracts the cutout shape from the base icon, leaving a clean gap of exactly 1.5 px around the key element.

6. **Verify the result** — zoom in and confirm the gap between the trimmed base icon edge and the key element looks correct and consistent on all sides.

---

## Check the Design Against the Style Guide Rules

Use this extended checklist for dual tone icons. It includes all standard checks plus the dual-tone-specific ones.

**Base icon**
- Canvas size is exactly 16 × 16 px
- Base icon reaches 16 px on at least one axis
- All strokes are 2 px, round cap, round join
- Minimum spacing of 1.5 px between all base icon elements
- Corners rounded with 1.0 px radius (outer corners only)
- Base icon color is gray `#A8A8A8`
- All shapes converted to paths (`Path → Object to Path`)
- All groups ungrouped (`Object → Ungroup` until greyed out)

**Key element**
- Key element has a width and/or height of exactly 8 px
- Key element is placed in the top-right or bottom-right corner
- Spacing between key element and base icon is at least 1.5 px
- Key element color matches its purpose (see color table above)
- Key element shape is converted to a path
- Key element is not grouped

**File**
- File is saved as plain SVG (not Inkscape SVG)
- File name matches the **New Name** from the GitHub issue

Once all checks pass, the icon is ready for contribution. Continue with the next guide to learn how to submit it via a pull request.
