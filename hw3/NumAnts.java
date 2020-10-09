/*
 * COMP 86 - Assignment 3
 *
 * NumAnts class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("deprecation")
public class NumAnts extends JSlider implements ChangeListener{
    //constructor
    public NumAnts(){
        setMinimum(1);
        setMaximum(7);
        addChangeListener(this);
    }

    //listen
    public void stateChanged(ChangeEvent e){
        int val = getValue();
        if (!getValueIsAdjusting()){
            System.out.println("This will change the number of ants in the" +
                              " simulation to " + Integer.toString(val));
        }
    }

}
