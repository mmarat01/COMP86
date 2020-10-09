/*
 * COMP 86 - Assignment 3
 *
 * Canvas class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("deprecation")
public class Canvas extends JPanel{
    //constructor
    public Canvas(){
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        setBackground(new Color(137, 148, 78));
        setOpaque(true);
    }

    //paint
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
