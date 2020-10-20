/*
 * COMP 86 - Assignment 4
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
  - As of HW4, I finished figuring the rules of the simulation out. Its name
    will be Insect World, and it's an educational game. The user will be able
    to spawn different insects on the middle of the maze, and will be able to
    move each of them through the maze until finding a scroll. Once a scroll
    is found, a "fun fact" is unlocked, and the user will be able to click
    on the button of the same name, after which a new window will pop up
    with some interesting fact about the insects on the scree. The user will
    also be able to adjust the number of scrolls on the screen and to change
    the display mode between dark mode and light mode. Another important rule
    is that the user can have multiple insects on the screen, but if one is
    unselected through its checkbox, next time it's checked, it will re-spawn
    back to the middle. Implementation-wise, an MVC pattern was added, to
    better streamline the transfer of information between different parts of
    the simulation.

Description of UI:
  - The main skeleton of the UI involves a BorderLayout with three main areas:
    the header (north), the settings panel (west), and the canvas (west).
    Out of all these three, most of the UI action occurs on the settings panel.
    This section uses a GridLayout with another BorderLayout inside of it in
    order to facilitate the arrangement of one of the  widgets with its
    label. The functionality of these settings includes: setting the insects
    that can be spawned on the screen, setting the number of scrolls, a button
    for fun fact pop-ups, a button for changing between dark and light mode,
    and a button to reset the simulation to initial values.

    ----As of HW4, on top of the dark and light mode that had previously been
    implemented, and some previous responsive drawing on the canvas' background,
    the maze, vehicles, and scrolls have been drawn too -- also in a responsive
    way. Further, the functionality of spawning vehicles with the checkboxes
    and the functionality of using the slider to set the number of scrolls was
    also added.

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
      JLabel
          MyLabel
      JSlider
          NumScrolls
      JFrame
          Main
      Vehicle
          Scroll
          Ant
          Beetle
          Caterpillar
          Cricket
          Fly
          Ladybug
  - Aggregation:
      Main contains [Canvas, Controls, Header, Model]
      Canvas contains [Model]
      Controls contains [MyLabel, MyCheckbox, MyButton, NumScrolls, Model]
      Header contains [MyLabel]
      Model [Main, Vehicle (and subclasses), Maze]
