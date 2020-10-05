/*
 * COMP 86 - Assignment 1
 * Button class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

@SuppressWarnings("deprecated")
public class Button extends JButton implements ActionListener {
    private int id, counter;
    private String label, message;

    //constructor
    public Button(String label, String message, int id) {
        setText(label);
        setBackground(new Color(74, 200, 221)); // nice color
        /*take input vars */
        this.id = id;
        this.label = label;
        this.message = message;
        counter = 0; // this will be used for one button only
        addActionListener(this); //*this* reads actions
    }

    /* implemented from ActionListener interface */
    public void actionPerformed(ActionEvent e){ //print when button action
	      System.out.println("button " + id + " says: " + message);
        if (this.id == 5) //button 5 changes label
            setText("I count " + Integer.toString(counter++));
    }
}
