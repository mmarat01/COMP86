/*
 * COMP 86 - Assignment 4
 *
 * Vehicle class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import java.awt.Graphics2D;

/* different listeners will be implemented on different vehicles to justify the
abstraction */
abstract class Vehicle{
    //private data
    protected int x;
    protected int y;
    protected String filename;

    //constructor
    public Vehicle(int x, int y, String filename){
        this.x = x;
        this.y = y;
        this.filename = filename;
    }

    //methods
    public abstract void draw(Graphics2D g2d, Canvas canvas, int vehic_w,
                              int vehic_h);
    public abstract boolean isActive();
    public abstract void setActivity(boolean value);
    public abstract void resetXY();
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
