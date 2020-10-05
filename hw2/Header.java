/*
 * COMP 86 - Assignment 2
 *
 * Header class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("deprecated")
public class Header extends JPanel{
    //private data
    private HeaderTitle title = new HeaderTitle(" A N T  W O R L D ");

    //constructor
    public Header(){
        setBorder(new LineBorder(new Color(173, 108, 134), 5));
        setOpaque(false);
        add(title);
    }
}
