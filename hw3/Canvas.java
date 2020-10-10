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
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
        Graphics2D g2D = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2D.setColor(new Color(164, 175, 103)); //bg logistics
        //bg dots
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if ((i % 30 == 0) && (j % 30 == 0)){
                    g2D.drawOval(j, i, 10, 10);
                    g2D.fillOval(j, i, 10, 10);
                }
            }
        }
        // add(new Object(new Ant("black-ant.png")));
    }
}
