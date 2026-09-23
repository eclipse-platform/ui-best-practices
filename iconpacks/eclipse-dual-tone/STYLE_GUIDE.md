<img width="1450" height="331" alt="image" src="https://github.com/user-attachments/assets/00194d80-d7ad-483a-8bae-9c13a0afa747" />

## Eclipse Dual Tone Icon Pack Style Guide
This style guide serves as an orientation for designing icons in the dual tone Eclipse icon pack. Its primary goal is to ensure visual consistency across all icons so they appear as part of a cohesive design system. The rules outlined here provide a solid foundation for icon creation and help maintain a unified look and feel.

However, visual harmony sometimes requires flexibility. In certain cases, it may be necessary to bend the rules slightly to achieve the best visual result for a specific icon. This guide is not a rigid set of constraints, but a framework that can evolve over time. It may be refined as new needs emerge or design patterns shift.

In addition to the rules described in this document, it is equally important to take inspiration from existing icons in the dual tone icon pack. These existing designs offer valuable guidance and can help ensure new icons align with the established style.

### **Icon Types**
Every Icon is categorized into one of three distinct types.

<img width=40% height=40% alt="image" src="https://github.com/user-attachments/assets/cf094dc2-7644-414b-ba16-21f3f04a4561" />

1. **Base Icons (Gray Scale)**: Most icons are colored in a standard gray tone, ensuring a neutral and consistent appearance. 
2. **Dual-Tone Icons**: Basic icon combined with a key element. The key element conveys various information about functionality depending on the color. For instance, green key elements signify "Run, New & OK,".
4. **Monochromatic Colored Icons**: Used to represent individual functions. The coloring corresponds to that of the key elements.

---

### **Icon Specifications**

<img width=25% height=25% alt="image" src="https://github.com/user-attachments/assets/2f5b45a7-c3c1-4019-a614-e876f3ed5083" />

**Icon Sizes & Placement**

- Base Icon: 16 x 16 px
- Key Element: 8 x 8 px

**Please note:** 
- The icon’s motive must be centered within the view area.
- The design should fully utilize the available space while maintaining balance and clarity.
- If full width and height cannot be used simultaneously, at least one of them should be fully utilized.

**Stroke & Shape**
- All paths and strokes must have a fixed width of 2.0 px.
- This ensures consistent visibility at small sizes.

**Corners**
- All stroke and shape corners should be rounded.
- Use a corner radius of 1.0 px.

**Spacing**
- Spacing between elements within an icon should be 1.5 px.
- The spacing between the main icon element and the key element must also be 1.5 px.

**Key Elements Details**

The key element provides the second visual tone of the icon.

- The key element must be colored according to the defined color specifications.
- It must have a width and/or height of 8 px.
- The key element should be positioned in the top-right or bottom-right corner of the view area.
- Maintain 1.5 px spacing between the key element and the main icon element.

**Wizard Icons Details**
- Standard size: **75x58 pixels**

---

### **Coloring**

<img width=25% height=25% alt="image" src="https://github.com/user-attachments/assets/222aa49e-d10a-4182-a102-8e7da055b685" />

Each color has a specific meaning and should be applied consistently:

| Color       | Purpose                                          | Hex-Code        |
|-------------|--------------------------------------------------|-----------------|
| **Gray**    | Default color for all base icons                      | `#A8A8A8`       |
  | **Green**   | Indicates action (e.g. "Run")                   | `#499C54` |
  | **Red**     | Error, alert, or stop (e.g. "Stop")             | `#C80000` |
  | **Yellow**  | Warnings                                         | `#FFD700` |
  | **Blue**    | General Information                              | `#0065C7` |
  | **Orange**  | Interaction (e.g. "Pause")                      | `#FF7F27` |
  
---

### **Disabled Icon State**
Disabled icons should maintain their original form while visually indicating inactivity:

- **Light Mode:** Icons become brighter  
- **Dark Mode:** Icons become darker  
- **Transparency Adjustment:**
  - The disabled state is achieved programmatically by modifying transparency.
  - Colored icons retain a faint version of their original hue to preserve recognition while ensuring they appear deactivated.

---

### **Components**

The following components represent already developed design elements of the icon pack. They serve as reusable building blocks and play an important role in maintaining a consistent and recognizable visual style.

When creating new icons, these components should be used whenever they are thematically appropriate. This helps ensure that style, proportions, and visual language remain consistent throughout the icon pack, while also enabling faster and more efficient icon creation.

For each component, both the implemented example icon and the component itself are available as an SVG file in the appropriate size. The SVG can be downloaded in the components folder and directly used as a foundation when designing new icons.

  | Element | Example Icon Design | Design Component  |
  |-------------|--------------------------------------------------|-----------|
  | **New** | ![new_file](https://github.com/user-attachments/assets/6c874d26-987c-4a55-a18a-f8c0a13fc2e0) | ![component_new](https://github.com/user-attachments/assets/b79a76a6-3d23-4b9b-8a5a-ff588c4aeec6) |
  | **Import** | ![import_dir](https://github.com/user-attachments/assets/b9c95ef0-c4c3-4bb0-aa8d-332b4969f281) | ![component_import](https://github.com/user-attachments/assets/781657e2-6976-4157-b064-670bb7c3cb4d) |
  | **Export** | ![export_dir](https://github.com/user-attachments/assets/f6877710-2fd1-4033-8080-5858d425f0d1) | ![component_export](https://github.com/user-attachments/assets/d13c2bcb-dc7b-43db-8072-70cddc13da71) |
  | **Run** | ![rundebug](https://github.com/user-attachments/assets/624cc667-a705-42c8-a983-ae2e81298283) | ![component_run](https://github.com/user-attachments/assets/b59dac69-f368-4348-af0c-ab2fee1df0d9) |
  | **Group** | ![group_by_folder](https://github.com/user-attachments/assets/c6536e11-4342-4ae5-a3e8-60297b242120) | ![component_group](https://github.com/user-attachments/assets/770518a0-4074-4c79-ab85-6d887ae9e499) |
  | **File** | ![component_file](https://github.com/user-attachments/assets/6453f19c-d1c7-4779-a52a-8051b3b902e8) | ![component_file](https://github.com/user-attachments/assets/6453f19c-d1c7-4779-a52a-8051b3b902e8) |
  | **Folder** | ![component_folder](https://github.com/user-attachments/assets/081d0c91-096f-48f9-8567-396a527111f4) | ![component_folder](https://github.com/user-attachments/assets/081d0c91-096f-48f9-8567-396a527111f4) |
  | **Project** | ![component_project](https://github.com/user-attachments/assets/4c9382b6-7dd9-46ed-882c-877e72adf6e4) | ![component_project](https://github.com/user-attachments/assets/4c9382b6-7dd9-46ed-882c-877e72adf6e4) |
  | **Write** | ![component_write](https://github.com/user-attachments/assets/f13d8d3e-2d1f-46d8-a81a-b506d3134d48) | ![component_write](https://github.com/user-attachments/assets/f13d8d3e-2d1f-46d8-a81a-b506d3134d48) |
  | **Compare** | ![component_compare](https://github.com/user-attachments/assets/093aa9db-6f95-49ab-b740-3f2f21a78c12) | ![component_compare](https://github.com/user-attachments/assets/093aa9db-6f95-49ab-b740-3f2f21a78c12) |
  | **Single Rectangle** | ![remove](https://github.com/user-attachments/assets/b3cacf6d-e78d-4090-ab09-ff689db08223) | ![component_single_rectangle](https://github.com/user-attachments/assets/457ef8c0-f70c-4eea-a641-7fb9535b4050) |
  | **Double Rectangle** | ![remove-all](https://github.com/user-attachments/assets/256559e1-2d50-4d4b-84a0-eb9a1342be47) | ![component_double_rectangle](https://github.com/user-attachments/assets/00e60b32-3754-4447-bcf5-4a2a999342f3) |
    
---

### **Checklist for Icon Designs**

This checklist provides a quick reference to ensure that newly created icons follow the design principles and visual standards of the Dual Tone Icon Pack.
It is recommended to work with Inkscape.

- [ ] Canvas size: 16x16px
- [ ] Icon size: Minimum dimension of 16 px on one side
- [ ] Key Element size: 8px on one side
- [ ] All Strokes: 2px
- [ ] Min. distance of elements: 1,5px
- [ ] Corners: Rounded with a radius of 1.0px (only outer corners)
- [ ] Does the color fit the purpose? (As listed in Color Assignment Section)
- [ ] Are all shapes transformed to paths?
- [ ] Are all groups ungrouped?  
- [ ] Is the file named according to the new Icon name?

---

### **How to contribute a new Icon Design**

To contribute a new Icon please follow the upcoming steps: 

1. Choose an existing issue in the Dual Tone Icon Repo *
2. Design the new icon according to the Style Guide
3. Save the file as svg
4. Create a new branch from main (naming convention: Add-Icon-<Icon Name>.svg)
5. Add the designed Icon in the dual-tone-icons folder
6. Update the icon-mapping.json
7. Update the semantic-icon-library.json
8. Link the issue in the commit message (naming convention: Fixes: <Link to issue>)
9. Create a Pull Request
10. Mark one of the following persons to check the Icon, Mapping and Library: @Michael5601, @jasmin261098, @BeckerWdf
11. Wait for the PR to be reviewed and address any feedback
12. PR can be merged

**If you want to propose a new icon design for the pack, please follow these steps:**

1. In the repository’s Issue overview (link), create a new issue using “Suggest an enhancement.”
2. Delete the prefilled issue template 
3. Use the provided issue template
4. Fill out the template completely  
5. Create the Issue
