# 03 How to Create a New Icon Design — Standard Icon

This guide walks through the full workflow for designing a standard (base) icon in Inkscape: from picking up a GitHub issue to verifying the finished design against the Style Guide.

---

## Choose an Existing Issue on GitHub

Only work on icons that have an open, approved issue. This prevents duplicate effort and ensures the design has been scoped before work begins.

1. Open the **Issues** tab of the repository on GitHub.
2. Filter by the label **"enhancement"** to find icon proposals.
3. Pick an unassigned issue — check that no one else has already claimed it.
4. Leave a comment on the issue to signal that you are working on it (e.g. _"I'll pick this up."_).

---

## Open Inkscape and Set All Preferences

Getting the Inkscape workspace configured correctly before drawing ensures your icon will meet the spec without manual corrections later.

### 1. Create a new document with the correct canvas size

1. Open Inkscape.
2. Go to **File → Document Properties** (`Shift+Ctrl+D`).
3. Set **Width** and **Height** to `16 px`.
4. Set the display unit to `px`.
5. Close Document Properties.

### 2. Enable the pixel grid

A 1 px grid aligned to the canvas makes it easy to place elements at whole-pixel coordinates.

1. Open **File → Document Properties → Grids** tab.
2. Click **Add** and select **Rectangular grid**.
3. Set both **Spacing X** and **Spacing Y** to `1 px`.
4. Set **Origin X** and **Origin Y** to `0`.
5. Enable **"Snap to grids"** (`%` key to toggle snapping on/off while drawing).

### 3. Configure stroke defaults

All strokes in the icon pack must be `2 px` wide with round caps and joins.

1. Draw any temporary path, then open **Object → Fill and Stroke** (`Shift+Ctrl+F`).
2. Under **Stroke style**, set:
   - **Width:** `2 px`
   - **Line cap:** Round
   - **Line join:** Round
3. Delete the temporary path — Inkscape remembers these defaults for the session.

### 4. Set the default color

Base icons use gray `#A8A8A8`. Set this as your working color so new shapes start correctly.

1. Click the gray swatch in the palette, or
2. Open **Object → Fill and Stroke** and enter `A8A8A8FF` in the hex field.

---

## Build the Icon Design According to the Style Guide

### 1. Check for reusable components first

Before drawing anything, check the [`components/`](../components/) folder. Open a component SVG in Inkscape, copy the path, and paste it into your working file. Using existing components (File, Folder, Run, New, etc.) ensures visual consistency and saves time.

### 2. Draw the icon shape

- Keep all shapes within the **16 × 16 px** canvas.
- The motive must be **centered** and must reach **16 px on at least one axis** (full width or full height).
- Use the **Pen/Bézier tool** (`B`) for custom paths or the **Rectangle/Circle tools** for geometric shapes.
- Apply `1.0 px` corner radius to all rounded corners: select the shape, then drag the corner handles in the canvas or set the radius numerically in the toolbar.

### 3. Maintain spacing rules

- Keep a minimum of **1.5 px** between any two separate elements within the icon.
- Use the grid and the **Align and Distribute** panel (`Shift+Ctrl+A`) to position elements precisely.

### 4. Apply the correct color

Use the color table from the Style Guide to assign colors. For a standard base icon all elements should be `#A8A8A8` (gray).

### 5. Convert all shapes to paths

Before saving, every shape must be a plain SVG path — no rectangles, circles, or text objects.

1. Select all objects (`Ctrl+A`).
2. Go to **Path → Object to Path** (`Shift+Ctrl+C`).

### 6. Ungroup everything

The final SVG must contain no groups.

1. Select all (`Ctrl+A`).
2. Go to **Object → Ungroup** (`Ctrl+Shift+G`).
3. Repeat until **Ungroup** is greyed out.

### 7. Save as plain SVG

1. Go to **File → Save As** (`Shift+Ctrl+S`).
2. Choose **Plain SVG** (not Inkscape SVG) as the format to keep the file clean.
3. Name the file according to the **New Name** field from the GitHub issue (e.g. `clipboard-variable.svg`).

---

## Check the Design Against the Style Guide Rules

Use this checklist before marking the issue as done or opening a pull request. Go through each item in Inkscape with your icon open.

- **Canvas size:** Document is exactly 16 × 16 px (`File → Document Properties`)
- **Icon fills the canvas:** The icon reaches 16 px on at least one axis
- **All strokes are 2 px:** Check each path in `Object → Fill and Stroke → Stroke style`
- **Stroke caps and joins are round:** Verify in `Stroke style`
- **Minimum spacing 1.5 px:** No two elements are closer than 1.5 px apart
- **Corners are rounded with 1.0 px radius:** Only outer corners; inner corners may stay sharp
- **Color matches purpose:** Gray `#A8A8A8` for base icons, or the correct color per the table above
- **All shapes converted to paths:** `Path → Object to Path` — no rectangles, circles, or text remain
- **All groups ungrouped:** `Object → Ungroup` until greyed out
- **File named correctly:** Matches the **New Name** from the GitHub issue

Once all boxes are checked, the icon is ready for contribution. Continue with the next guide to learn how to submit it via a pull request.
