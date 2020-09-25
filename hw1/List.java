/*
 * COMP 86 - Assignment 1
 * List class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class List extends JList<String> implements MouseListener{
    private String[] members = {"the dream", "seeking", "peeking",
                                "real life"}; //members of the list

    //constructor
    public List(){
        setListData(members); //add members
        addMouseListener(this); //make *this* the mouseevent listener
    }

    /* implemented from MouseListener interface */
    public void mouseClicked(MouseEvent e){ //print when mouse clicks list
        System.out.println("you just clicked on the list!");
    }

    public void mouseEntered(MouseEvent e){ //don't want this from interface
        return;
    }

    public void mouseExited(MouseEvent e){ //don't want this from interface
        return;
    }

    public void mousePressed(MouseEvent e){ //don't want this from interface
        return;
    }

    public void mouseReleased(MouseEvent e){ //don't want this from interface
        return;
    }
}
