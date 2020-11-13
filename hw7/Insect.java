/*
 * COMP 86 - Assignment 7
 *
 * Insect class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import javax.swing.ImageIcon;

import java.awt.Graphics2D;

@SuppressWarnings("deprecation")
public class Insect extends Vehicle{
    //core data
    private final ImageIcon def_icon;
    private final ImageIcon alt_icon;
    private final String alt_filename;
    private boolean curr_icon;
    //these store initial position to re-spawn
    private final int SPAWN_X;
    private final int SPAWN_Y;
    //constructor
    public Insect(int x, int y, String def_filename, String alt_filename){
        super(x, y, def_filename); //run and store in parent constructor
        this.alt_filename = alt_filename;
        SPAWN_X = x;
        SPAWN_Y = y;
        active = false;
        def_icon = new ImageIcon(def_filename);
        alt_icon = new ImageIcon(this.alt_filename);
        curr_icon = true;
    }
    //methods
    public void draw(Graphics2D g2d, Canvas canvas, int rect_w, int rect_h){
        //if else to check current state of the maze and draw appropriately
        if (rect_w < 40 && rect_h < 40){
            real_x = x*40;
            real_y = y*40;
            getCurrentIcon().paintIcon(canvas, g2d, real_x, real_y);
        } else if (rect_w < 40 && rect_h >= 40){
            real_x = x*40;
            real_y = y*rect_h;
            getCurrentIcon().paintIcon(canvas, g2d, real_x, real_y);
        } else if (rect_w >= 40 && rect_h < 40){
            real_x = x*rect_w;
            real_y = y*40;
            getCurrentIcon().paintIcon(canvas, g2d, real_x, real_y);
        } else {
            real_x = x*rect_w;
            real_y = y*rect_h;
            getCurrentIcon().paintIcon(canvas, g2d, real_x, real_y);
        }
    }

    public void moveUp(){
        y -= 1;
    }

    public void moveDown(){
        y += 1;
    }

    public void moveRight(){
        x += 1;
    }

    public void moveLeft(){
        x -= 1;
    }

    public boolean pickCorrelation(int xVal, int yVal){
        int icon_w = getCurrentIcon().getIconWidth();
        int icon_h = getCurrentIcon().getIconHeight();
        if (xVal >= real_x && xVal <= (real_x + icon_w)){
            if (yVal >= real_y && yVal <= (real_y + icon_h)){
                return true;
            }
        }
        return false;
    }

    //setters
    public void resetXY(){
        x = SPAWN_X;
        y = SPAWN_Y;
    }

    public void setIcon(boolean alt){
        if (alt){
          curr_icon = false;
        } else {
          curr_icon = true;
        }
    }

    //utility
    private ImageIcon getCurrentIcon(){
        if (curr_icon){ //if true, default icon
            return def_icon;
        } else {
            return alt_icon;
        }
    }


    public void tick(int frame_num){}
}
