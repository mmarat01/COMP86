/*
 * COMP 86 - Assignment 1
 * ProgressBar class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JProgressBar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class ProgressBar extends JProgressBar implements MouseListener{
    //constructor
    public ProgressBar(){
        /* min, max, and initial values for progressbar */
        setMinimum(0);
        setMaximum(100);
        setValue(75);
        setOrientation(HORIZONTAL);
        setBackground(new Color(164, 194, 132)); // nice color
        addMouseListener(this); //*this* reads mouse actions
    }

    /* implemented from MouseListener interface */ 
    public void mouseEntered(MouseEvent e){ //print when mouse enters bar
        System.out.println("enter the progress :)");
    }

    public void mouseClicked(MouseEvent e){ //print when mouse clicks bar
        System.out.println("#ClicksForProgress");
    }

    public void mouseExited(MouseEvent e){ //print when mouse leaves bar
        System.out.println("exit the progress :(");
    }

    public void mousePressed(MouseEvent e){ //don't want this from interface
        return;
    }

    public void mouseReleased(MouseEvent e){ //don't want this from interface
        return;
    }
}
