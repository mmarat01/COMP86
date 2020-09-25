/*
 * COMP 86 - Assignment 1
 * Label class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Font;

public class Label extends JLabel implements MouseMotionListener{
    public Label(String text){
        setText(text); //text on GUI
        setFont(new Font("Helvetica", Font.ITALIC, 30));//set font, form, size
        addMouseMotionListener(this); //*this* reads the mouse motion
    }

    /* implemented from MouseMotionListener interface */
    public void mouseMoved(MouseEvent e){ //print when mouse hovers
        System.out.println("mouse on the label mouse on the label");
    }

    public void mouseDragged(MouseEvent e){ //dont't want this from interface
        return;
    }
}
