/*
 * COMP 86 - Assignment 1
 * ScrollBar class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JScrollBar;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.Color;

public class ScrollBar extends JScrollBar implements AdjustmentListener{
    private int id;

    //constructor
    public ScrollBar(int id, int orient_code){
        this.id = id; //take input var and store
        if (orient_code == 1){ //let driver decide orientation
            setOrientation(HORIZONTAL);
        } else if (orient_code == 2){
            setOrientation(VERTICAL);
        }
        setMinimum(0);
        setMaximum(100);
        setBackground(new Color(244, 144, 147)); //nice color
        setValue(25); //initial
        addAdjustmentListener(this); // *this* will listen to adjustment events
    }

    /* implemented from AdjustmentListener interface */
    public void adjustmentValueChanged(AdjustmentEvent e){ //print when adjusted
        System.out.println("scroll bar "+ id + " moved to value:" + getValue());
    }
}
