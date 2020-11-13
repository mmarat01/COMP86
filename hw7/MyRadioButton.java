/*
 * COMP 86 - Assignment 7
 *
 * MyButton class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JRadioButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("deprecation")
public class MyRadioButton extends JRadioButton implements ItemListener{
    //constructor
    Model model;
    public MyRadioButton(String text, Model model){
        this.model = model;
        setText(text);
        setEnabled(false);
        addItemListener(this);
    }
    //listen
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            this.model.setInsectColor(true);
            this.model.repaint();
        } else if (e.getStateChange() == ItemEvent.DESELECTED){
            this.model.setInsectColor(false);
        }
        this.model.repaint();
    }
}
