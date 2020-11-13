/*
 * COMP 86 - Assignment 7
 *
 * Vehicle class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import java.awt.Graphics2D;

abstract class Vehicle{
    //private data
    protected int x; // maze x
    protected int y; // maze y
    protected int real_x; // real, adjusted to screen size x
    protected int real_y; //real, adjusted to screen size y
    protected String filename;
    protected boolean active;

    //constructor
    public Vehicle(int x, int y, String filename){
        this.x = x;
        this.y = y;
        real_x = x*40;
        real_y = y*40;
        this.filename = filename;
    }

    //methods
    public abstract void draw(Graphics2D g2d, Canvas canvas, int vehic_w,
                              int vehic_h);
    public abstract void resetXY();
    public abstract void setIcon(boolean alt);
    public abstract void tick(int frame_num);
    public abstract boolean pickCorrelation(int x, int y);
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();

    //getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //setter and other public utility
    public void setActivity(boolean value){
        active = value;
    }

    public boolean isActive(){
        return active;
    }
}
