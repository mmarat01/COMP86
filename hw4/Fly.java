/*
 * COMP 86 - Assignment 4
 *
 * Fly class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import javax.swing.ImageIcon;

import java.awt.Graphics2D;

public class Fly extends Vehicle{
    /* more icons might be added facing different directions, if transform
    not used */
    private ImageIcon def_icon;
    private boolean active;
    //these store initial position to re-spawn if deleted by checkbox
    private final int SPAWN_X;
    private final int SPAWN_Y;
    //constructor
    public Fly(int x, int y, String filename){
        super(x, y, filename); //run and store in parent constructor
        SPAWN_X = x;
        SPAWN_Y = y;
        active = false;
        def_icon = new ImageIcon(filename);
    }

    //methods
    public void draw(Graphics2D g2d, Canvas canvas, int rect_w, int rect_h){
        //if else to check current state of the maze and draw appropriately
        if (rect_w < 40 && rect_h < 40){
            def_icon.paintIcon(canvas, g2d, x*40, y*40);
        } else if (rect_w < 40 && rect_h >= 40){
            def_icon.paintIcon(canvas, g2d, x*40, y*rect_h);
        } else if (rect_w >= 40 && rect_h < 40){
            def_icon.paintIcon(canvas, g2d, x*rect_w, y*40);
        } else {
            def_icon.paintIcon(canvas, g2d, x*rect_w, y*rect_h);
        }
    }
    public boolean isActive(){
        return active;
    }
    public void setActivity(boolean value){
        active = value;
    }
    public void resetXY(){
        x = SPAWN_X;
        y = SPAWN_Y;
    }
}
