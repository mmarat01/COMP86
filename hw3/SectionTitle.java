/*
 * COMP 86 - Assignment 3
 *
 * SectionTitle class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JLabel;

import java.awt.Font;

@SuppressWarnings("deprecation")
public class SectionTitle extends JLabel{
    int id;
    //constructor
    public SectionTitle(String text, boolean bold, boolean italic, int size){
        this.id = id;
        setText(text);
        if (bold && italic){
            setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, size));
        } else if (bold){
            setFont(new Font("Helvetica", Font.BOLD, size));
        } else if (italic){
            setFont(new Font("Helvetica", Font.ITALIC, size));
        } else {
            setFont(new Font("Helvetica", Font.PLAIN, size));
        }
    }
}
