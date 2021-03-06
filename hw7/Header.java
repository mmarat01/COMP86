/*
 * COMP 86 - Assignment 7
 *
 * Header class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("deprecation")
public class Header extends JPanel{
    //private data
    private MyLabel h_title = new MyLabel(" I N S E C T  W O R L D ", true,
                                          true, 40);
    //constructor
    public Header(){
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        setOpaque(false);
        add(h_title);
    }

    //getter
    public MyLabel getTitle(){
        return h_title;
    }
}
