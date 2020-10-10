/*
 * COMP 86 - Assignment 3
 *
 * Canvas class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import javax.swing.ImageIcon;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("deprecation")
public class Ant extends ImageIcon implements MouseListener{
    String filename; //stores name
    //constructor
    public Ant(String filename){
        this.filename = filename;
        super(filename);
    }

    //listen
    public void mouseClicked(MouseEvent e){
        System.out.println("click on ant");
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
