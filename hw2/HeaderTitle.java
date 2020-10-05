/*
 * COMP 86 - Assignment 2
 *
 * HeaderTitle class
 * Written by: Mijael Maratuech
 * October, 2020
 */
 
import javax.swing.JLabel;

import java.awt.Font;

@SuppressWarnings("deprecated")
public class HeaderTitle extends JLabel{
    //constructor
    public HeaderTitle(String text){
        setText(text);
        setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 40));
    }
}
