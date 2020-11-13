/*
 * COMP 86 - Assignment 7
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
    private boolean main_pos;
    private int main_x;
    private int main_y;
    private int alt_x;
    private int alt_y;
    //constructors
    public Scroll(int x, int y, int alt_x, int alt_y, String filename){
        super(x, y, filename);
        main_x = x;
        main_y = y;
        this.alt_x = alt_x;
        this.alt_y = alt_y;
        icon = new ImageIcon(filename);
        active = true;
        main_pos = true;
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

    public void tick(int frame_num){
        if (frame_num % 2 == 0){
            x = alt_x;
            y = alt_y;
            main_pos = false;
        } else {
            x = main_x;
            y = main_y;
            main_pos = true;
        }
    }

    /* as scrolls don't have the feature of being clickable, they should never
      correlate */
    public boolean pickCorrelation(int x, int y){
        return false;
    }
    public void resetXY(){};
    public void setIcon(boolean alt){};
    public void moveUp(){};
    public void moveDown(){};
    public void moveLeft(){};
    public void moveRight(){};
}
