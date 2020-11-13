/*
 * COMP 86 - Assignment 7
 *
 * MyCheckbox class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JCheckBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("deprecation")
public class MyCheckbox extends JCheckBox implements ItemListener{
    //private data
    private int id;
    private Model model;
    //constructor
    public MyCheckbox(String text, int id, Model model){
        this.id = id;
        this.model = model;
        setText(text);
        setEnabled(false);
        addItemListener(this);
    }

    //listen
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            this.model.addRemoveInsect(this.id - 1, true);
        } else if (e.getStateChange() == ItemEvent.DESELECTED){
            this.model.addRemoveInsect(this.id - 1, false);
        }
        this.model.repaint();
    }
}
