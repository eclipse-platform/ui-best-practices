# IconReplacer Usage Manual

## Overview

`IconReplacer` is a Java tool to replace icons in the Eclipse workspace repositories with a new icon pack, based on a mapping file. This tool does NOT replace icons of an eclipse installation but only icons that are loaded into the workspace. After the replacement an eclipse instance with the new icons can be started in the eclipse run configuration. The tool is fully written in Java and does not use any third party dependencies.

## Prerequisites
- The `icon-mapping.json` and `dual-tone-icons` folder must be present in your dual-tone icon pack directory
- All target repositories must be accessible in a single root directory

## Compilation
In a terminal navigate to the folder containing `IconReplacer.java` and run:

```
javac IconReplacer.java
```

## Usage
Run the tool with two arguments:

```
java IconReplacer <eclipse-dual-tone-directory> <git-repositories-root-directory>
```

- `<eclipse-dual-tone-directory>`: Path to the directory containing `icon-mapping.json` and `dual-tone-icons`.
- `<git-repositories-root-directory>`: Path to the root directory containing all Eclipse workspace repositories.

### Example
```
java IconReplacer D:/dev/ui-best-practices/iconpacks/eclipse-dual-tone D:/dev/oomph/eclipse-installation/git
```