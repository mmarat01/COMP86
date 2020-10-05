/*
 * COMP 86 - Assignment 2
 *
 * Canvas class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("deprecated")
public class Canvas extends JPanel{
    //constructor
    public Canvas(){
        setBorder(new LineBorder(new Color(173, 108, 134), 5));
        setOpaque(false);
    }
}
