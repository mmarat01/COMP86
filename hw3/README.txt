/*
 * COMP 86 - Assignment 3
 *
 * Specifications
 * Written by: Mijael Maratuech
 * October, 2020
 */

Instructions:
  - to compile: javac Main.java
  *some warnings about deprecated APIs may show
  - to run: java main

Description of simulation:
  - The simulation will display an ant colony/farm, where ants move around
    the canvas area, eating or carrying materials for the colony (TBD). As it's
    supposed to be more of a nice/cute and relaxing simulation than a game,
    the user will be able to modify the simulation in multiple aways (more on
    this below).
  ----As of HW3, I've decided that the user will be able to control the ants
      by clicking on each of them and moving them one by one to their preference.
      They will be able to customize the ants colors, and perhaps the colony's
      obstacles as well (TBD). The main rules are determined by the labels of
      the buttons on the controls panel.

Description of UI:
  - The main skeleton of the UI involves a BorderLayout with three main areas:
    the header (north), the settings panel (west), and the canvas (west).
    Out of all these three, most of the UI action occurs on the settings panel.
    This section uses a GridLayout with some BorderLayouts inside of it in
    order to facilitate the arrangement of some interactive widgets with their
    labels. The functionality of these settings includes: setting the color of
    the ants, setting the number of the ants, setting dark/light mode in the
    window layout, showing the user fun facts about ants, showing an "about"
    page, and a start/stop button. Some of this functionality might change in
    the future.

    ----As of HW3, the dark mode / light mode button has been implemented. I
        used this by references to the proper elements to change passed into
        the MyButton class
    ----As core of the canvas, the background (and potential main grid) of
        AntWorld simulation has been implemented in such a way that it is
        perfectly resizable/

Notes:
    I struggled to find a proper way to generate the ants from an ImageIcon
    (as png images). I also struggled with drawing obstacles in the canvas.
    I tried making them responsive by positioning in terms of percentages
    but this just gets messed up when resizing the window in any non-regular
    way.

Design documentation:
  - Inheritance:
    Header inherits from JPanel
    Canvas inherits from JPanel
    Controls inherits from JPanel
    SectionTitle inherits from JLabel
    ColorAnts inherits from JComboBox
    Main inherits from JFrame
    MyButton inherits from JButton
    NumAnts inherits from JSlider

  - Aggregation:
    Controls contains [SectionTitle, NumAnts, ColorAnts, MyButton]
    Header contains SectionTitle
    Main contains [Canvas, Header, Controls]
    MyButton contains [Main, Controls, Header, Canvas]
