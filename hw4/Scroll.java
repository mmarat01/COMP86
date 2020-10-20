/*
 * COMP 86 - Assignment 4
 *
 * Scroll class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.ImageIcon;

import java.awt.Graphics2D;

public class Scroll extends Vehicle{
    //data
    private ImageIcon icon;
    private boolean active;
    //constructors
    public Scroll(int x, int y, String filename){
        super(x, y, filename);
        icon = new ImageIcon(filename);
    }
    //methods
    public void draw(Graphics2D g2d, Canvas canvas, int rect_w, int rect_h){
        //if else to check current state of the maze and draw appropriately
        if (rect_w < 40 && rect_h < 40){
            icon.paintIcon(canvas, g2d, x*40, y*40);
        } else if (rect_w < 40 && rect_h >= 40){
            icon.paintIcon(canvas, g2d, x*40, y*rect_h);
        } else if (rect_w >= 40 && rect_h < 40){
            icon.paintIcon(canvas, g2d, x*rect_w, y*40);
        } else {
            icon.paintIcon(canvas, g2d, x*rect_w, y*rect_h);
        }
    }

    public boolean isActive(){
        return active;
    }

    public void setActivity(boolean value){
        active = value;
    }

    public void resetXY(){};
}
