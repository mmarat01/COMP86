/*
 * COMP 86 - Assignment 3
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
    private SectionTitle h_title = new SectionTitle(" A N T  W O R L D ", true,
                                                true, 40);

    //constructor
    public Header(){
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        setOpaque(false);
        add(h_title);
    }

    public SectionTitle getTitle(){
        return h_title;
    }
}
