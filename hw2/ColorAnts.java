/*
 * COMP 86 - Assignment 2
 *
 * ColorAnts class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("deprecated")
public class ColorAnts extends JComboBox<String> implements ItemListener{
    //private data
    private String[] colors = {"black", "brown", "gray", "green", "red",
                              "purple"};

    //constructor
    public ColorAnts(){
        for (String i : colors){
            addItem(i);
        }
        addItemListener(this);
    }

    //listen
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
           System.out.println("This will change the color of the ants in the"
                              + " simulation to " +
                              getSelectedItem().toString());
        }
    }
}
