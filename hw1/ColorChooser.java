/*
 * COMP 86 - Assignment 1
 * ColorChooser class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JColorChooser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;

public class ColorChooser extends JColorChooser implements MouseMotionListener{
    //constructor
    public ColorChooser(){
        setColor(new Color(206, 202, 235)); //initial color
        addMouseMotionListener(this); //*this* will listen to mouse events
    }

    /* implemented from MouseMotionListener interface */
    public void mouseMoved(MouseEvent e){ //print when mouse hovers
        System.out.println("are you choosing a color?");
    }

    public void mouseDragged(MouseEvent e){ //dont't want this from interface
        return;
    }
}
