/*
 * COMP 86 - Assignment 2
 *
 * MyButton class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("deprecated")
public class MyButton extends JButton implements ActionListener{
    //private data
    private String label;
    private int id;

    //constructor.
    /* more functionality will be added as i plan on doing a few different
    manipulations based on the actions performed on the button. i haven't
    figured out how to work around them with the listeners yet, though. */
    public MyButton(String label, int id){
        this.label = label;
        this.id = id;
        setLabel(label);
        addActionListener(this);
    }

    //listen
    public void actionPerformed(ActionEvent e){
        System.out.println("This, depending on the label/id of the button will"
                           + " either change the display of the game, show"
                           + " a fun fact about ants (means: TBD), show an"
                           + " 'about' page, or start/stop the game");
    }
}
