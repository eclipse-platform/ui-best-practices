## Eclipse Modern Icon Pack Style Guide
This style guide serves as an orientation for designing icons in the modern Eclipse icon pack. Its primary goal is to ensure visual consistency across all icons so they appear as part of a cohesive design system. The rules outlined here provide a solid foundation for icon creation and help maintain a unified look and feel.

However, visual harmony sometimes requires flexibility. In certain cases, it may be necessary to bend the rules slightly to achieve the best visual result for a specific icon. This guide is not a rigid set of constraints, but a framework that can evolve over time. It may be refined as new needs emerge or design patterns shift.

In addition to the rules described in this document, it is equally important to take inspiration from existing icons in the modern icon pack. These existing designs offer valuable guidance and can help ensure new icons align with the established style.

### **Icon Types**
Every Icon is categorized into one of three distinct types:

1. **Base Icons (Gray Scale)**
   - Most icons are colored in a standard gray tone, ensuring a neutral and consistent appearance.
   - The gray tone differs from light mode to dark mode. 

     ![Image](https://github.com/user-attachments/assets/f87ca5fb-eb5a-4dc2-b59c-8393211222aa)

2. **Monochromatic Colored Icons**
   - Used for important actions such as "Run" (green) or "Stop" (red).
   - These icons employ a single, distinct color to indicate their function clearly.

     ![Image](https://github.com/user-attachments/assets/787c7756-7bfb-481a-88d6-baed6200842d)

3. **Dual-Tone Icons**
   - A hybrid of the base and monochromatic styles.
   - The main part of the icon remains in base gray, while a key element (e.g., the "pin" in a "Pin Editor" icon) is highlighted in a single distinct accent color.

     ![Image](https://github.com/user-attachments/assets/8f77772f-c1c5-46be-89b7-0b232be29bed)

---

### **Color Assignments**
Each color has a specific meaning and should be applied consistently:

| Color       | Purpose                                          | Light Mode      | Dark Mode       |
|-------------|--------------------------------------------------|------------------|------------------|
| **Gray**    | Default color for all icons                      | `#6E6E6E`         | `#A8A8A8`         |
| **Green**   | Indicates action (e.g., "Run")                   | `#008000`         | Same              |
| **Red**     | Error, alert, or stop (e.g., "Stop")             | `#C80000` | Same              |
| **Yellow**  | Warnings                                         | `#FFD700` | Same              |
| **Purple**  | For "Web Site," "Fragment," "Interface," etc.   | `#800080` | Same              |

---

### **Icon Sizes & Placement**

- The icon’s motive must be centered within the view area.
- The design should fully utilize the available space while maintaining balance and clarity.
- If full width and height cannot be used simultaneously, at least one of them should be fully utilized.

   <img src="https://github.com/user-attachments/assets/e69066c1-d21c-492c-b1c4-7ec3d073e5ef" width="200"/>

### **Standard Icons**
- View area: **16x16 pixels**

### **Overlay Icons**
- View area: **8x7 pixels**
- Overlay icons must be **monochromatic colored** to ensure they remain distinguishable from the base icon.

### **Wizard Icons**
- Standard size: **75x58 pixels**

---

### **Disabled Icon State**
Disabled icons should maintain their original form while visually indicating inactivity:

- **Light Mode:** Icons become brighter  
- **Dark Mode:** Icons become darker  
- **Transparency Adjustment:**
  - The disabled state is achieved programmatically by modifying transparency.
  - Colored icons retain a faint version of their original hue to preserve recognition while ensuring they appear deactivated.

---

### **Specifications**

This section outlines the design rules for Eclipse icons in the modern icon pack.

**Stroke style**
- Every path/stroke must have a fixed width of 2.0 px to ensure visibility at small sizes.
- All strokes must have rounded corners for a smooth appearance.

**Spacing**
- Spacing between elements within an icon is allowed but should always be 1.5 px wide.

**Corners**
- The corners of each stroke and shape should be rounded with a radius of 1.0px.

**Dual-Tonality**
- The spacing between the main part and the key element must be 1.5 px wide.
- The key element itself must have a width AND/OR a height of 10.0 px.
- The key element should always be placed in the top or bottom right corner of the view area. 

   <img src="https://github.com/user-attachments/assets/7cade825-786e-4a7e-9464-36a449c712b1" width="200"/>
