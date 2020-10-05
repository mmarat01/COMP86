/*
 * COMP 86 - Assignment 2
 *
 * ControlsTitle class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JLabel;

import java.awt.Font;

@SuppressWarnings("deprecated")
public class ControlsTitle extends JLabel{
    //constructor
    public ControlsTitle(String text){
        setText(text);
        setFont(new Font("Helvetica", Font.BOLD, 30));
    }
}
