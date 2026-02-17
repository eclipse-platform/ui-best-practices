#!/bin/bash

# replace_icons.sh
# Replaces Eclipse icons with new icons based on a mapping file.

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <eclipse_plugins_dir> <mapping_json_file>"
    exit 1
fi

PLUGINS_DIR="$1"
MAPPING_FILE="$2"
# Base directory of the mapping file to find the new icons
ICONS_BASE_DIR=$(dirname "$MAPPING_FILE")

if [ ! -d "$PLUGINS_DIR" ]; then
    echo "Error: Plugins directory $PLUGINS_DIR does not exist."
    exit 1
fi

if [ ! -f "$MAPPING_FILE" ]; then
    echo "Error: Mapping file $MAPPING_FILE does not exist."
    exit 1
fi

# We need jq to parse JSON. Check if it's available.
if ! command -v jq &> /dev/null; then
    echo "Error: jq is required to parse the mapping file. Please install it."
    exit 1
fi

# We need jar to update jar files.
if ! command -v jar &> /dev/null; then
    echo "Error: jar command is required to update JAR-based plugins. Please install a JDK."
    exit 1
fi

# Iterate over each source icon in the mapping
jq -r 'to_entries[] | .key + " " + (.value | join(" "))' "$MAPPING_FILE" | while read -r line; do
    read -ra parts <<< "$line"
    src_icon_name="${parts[0]}"
    # Search for the source icon recursively within the ICONS_BASE_DIR
    src_icon_path=$(find "$ICONS_BASE_DIR" -name "$src_icon_name" | head -n 1)

    if [ -z "$src_icon_path" ] || [ ! -f "$src_icon_path" ]; then
        echo "Warning: Source icon $src_icon_name not found in $ICONS_BASE_DIR. Skipping."
        continue
    fi

    # The rest are targets
    for target in "${parts[@]:1}"; do
        # Target format: plugin_id/path/to/icon.svg
        plugin_id="${target%%/*}"
        target_relative_path="${target#*/}"

        # Find the plugin in the plugins directory.
        # It could be a folder: plugin_id_version
        # or a jar: plugin_id_version.jar
        plugin_path=$(find "$PLUGINS_DIR" -maxdepth 1 -name "${plugin_id}_*" | head -n 1)

        if [ -z "$plugin_path" ]; then
            echo "Warning: Plugin $plugin_id not found in $PLUGINS_DIR. Skipping $target."
            continue
        fi

        if [ -d "$plugin_path" ]; then
            # Folder-based plugin
            dest_path="$plugin_path/$target_relative_path"
            dest_dir=$(dirname "$dest_path")
            mkdir -p "$dest_dir"
            cp "$src_icon_path" "$dest_path"
            echo "Replaced $target in folder: $plugin_path"
        elif [ -f "$plugin_path" ] && [[ "$plugin_path" == *.jar ]]; then
            # JAR-based plugin
            # We need to update the JAR file.
            # Using 'jar uf' or 'zip' to update the entry.
            # Create a temporary directory to replicate the structure for the jar update
            temp_jar_dir=$(mktemp -d)
            mkdir -p "$temp_jar_dir/$(dirname "$target_relative_path")"
            cp "$src_icon_path" "$temp_jar_dir/$target_relative_path"
            
            (cd "$temp_jar_dir" && jar uf "$plugin_path" "$target_relative_path")
            
            rm -rf "$temp_jar_dir"
            echo "Replaced $target in JAR: $plugin_path"
        fi
    done
done

echo "Icon replacement completed."
