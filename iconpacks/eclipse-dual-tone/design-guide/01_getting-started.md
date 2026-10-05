# 01 Getting Started

Welcome to the design guide for the **Eclipse Dual Tone Icon Pack**. This guide walks you through everything you need to get started contributing new icon designs.

---

## Step 1: Download Inkscape

Inkscape is the recommended vector graphics editor for designing icons in this project.

1. Go to the official Inkscape website: [https://inkscape.org/release/](https://inkscape.org/release/)
2. Download the installer for your operating system (Windows, macOS, or Linux).
3. Follow the installation instructions on the website.

> **Why Inkscape?** Inkscape is a free, open-source SVG editor that works well with the SVG format required by this project. It provides precise control over paths, strokes, and dimensions — all of which are critical for producing pixel-perfect icons at 16×16 px.

---

## Step 2: Clone the Repository

To work on icons locally, clone the `ui-best-practices` repository from GitHub.

### Prerequisites
- [Git](https://git-scm.com/) installed on your machine
- A GitHub account

### Clone via HTTPS

```bash
git clone https://github.com/eclipse-platform/ui-best-practices.git
```

### Navigate to the icon pack

```bash
cd ui-best-practices/iconpacks/eclipse-dual-tone
```

### Create a working branch

Before making any changes, create a new branch from `main`. Follow the naming convention:

```bash
git checkout main
git pull
git checkout -b Add-Icon-<Icon-Name>
```

For example:
```bash
git checkout -b Add-Icon-clipboard-variable
```

---

## Step 3: Read the Style Guide

Before designing any icon, read the [Style Guide](../STYLE_GUIDE.md) carefully. It defines the visual rules that all icons in this pack must follow.

### Key rules at a glance

| Rule | Value |
|------|-------|
| Canvas size | 16 × 16 px |
| Key element size | 8 × 8 px |
| Stroke width | 2.0 px |
| Corner radius | 1.0 px (rounded) |
| Minimum spacing between elements | 1.5 px |

---

## Next Steps

Once you have Inkscape installed, the repository cloned, and the Style Guide read, you are ready to start designing. Continue with the next guide in this series to learn about the icon design workflow.
