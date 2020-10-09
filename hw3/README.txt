/*
 * COMP 86 - Assignment 2
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

Notes:
    The inheritance could definitely be improved between the classes I built
    from scratch. Thinking about all the listeners I'll need and the
    information I'll eventually obtain from the simulation when it's up and
    running made the process difficult. As a final comment, the thing that
    worries me the most is *exactly* how I'm supposed to simulate the
    movement of the ants, as I've never done something like that. Is it
    timed? Is everything hard-coded?. If I give the user more power over, the
    ants, is it still a simulation? I look forward to clarifying these answers.

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
    Controls contains [ControlsTitle, NumAnts, ColorAnts, MyButton]
    Header contains HeaderTitle
    Main contains [Canvas, Header, Controls]
