/*
 * COMP 86 - Assignment 4
 *
 * NumScrolls class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("deprecation")
public class NumScrolls extends JSlider implements ChangeListener{
    private Model model;
    //constructor
    public NumScrolls(Model model){
        setMinimum(1);
        setMaximum(8);
        setValue(1);
        this.model = model;
        addChangeListener(this);
    }

    //listen
    public void stateChanged(ChangeEvent e){
        if (!getValueIsAdjusting()){
            this.model.setScrolls(getValue());
            this.model.repaint();
        }
    }

}
