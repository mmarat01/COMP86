/*
 * COMP 86 - Assignment 7
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
  - Insect World is an educational game. The user will be able
    to spawn different insects on the middle of the maze, and will be able to
    move them through the maze looking for a scroll. Once all six scrolls are
    found, a set of fun facts is unlocked. The user can track his or her
    progress on the bar on the left of the screen (state panel).
    The user can spawn different insects at any time, and select them by
    clicking on them. Their color can also be changed mid-game. Upon opening
    the program, all widgets appear as disabled with the exception of the
    button with the instructions. Once these are read, everything is enabled.
    Once all 6 scrolls are found, the game is over. Implementation-wise, an MVC
    pattern is followed, to better streamline the transfer of information
    between different parts of the simulation.

Description of UI:
  - The main skeleton of the UI involves a BorderLayout with three main areas:
    the header (north), the settings panel (west), and the canvas (west).
    Out of all these three, most of the UI action occurs on the settings panel.
    This section uses a GridLayout with different layouts inside of it in
    order to facilitate the arrangement of one of the  widgets with their
    label. The functionality of these settings includes: setting the insects
    that can be spawned on the screen, setting the number of scrolls, a button
    for fun fact pop-ups, a button for changing between dark and light mode,
    and a button to reset the simulation to initial values.

Design documentation:
  - Inheritance (class on top is parent, subclass below):
      JPanel ...
          Controls
          Header
          Canvas
      JButton ...
          MyButton
      JCheckBox ...
          MyCheckbox
      JRadioButton ...
          MyRadioButton
      JLabel ...
          MyLabel
      JProgressBar ...
          MyProgressBar
      JFrame ...
          Main
      Vehicle ...
          Scroll
          Insect
  - Aggregation:


  - Encapsulation:
    Vehicles classes make secret their initial coordinates, icons, X/Y coordinates
    and whether or not they are active.
    Maze makes secret its grid and size.
    Model makes secret boolean values pertaining to the simulation, its colors,
    and references.
    Canvas makes secret dimensions, references, the frame counter, timer, and colors
    All widgets make secret their design properties, labels, ids, and references.
    Controls makes secret its references, all widgets, and a boolean pertaining
    to the simulation.
