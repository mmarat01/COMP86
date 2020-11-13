/*
 * COMP 86 - Assignment 7
 *
 * MyButton class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


@SuppressWarnings("deprecation")
public class MyButton extends JButton implements ActionListener{
    //private data
    private int id;
    private Model model;
    private Controls controls;

    //constructor
    public MyButton(String label, int id, Model model, Controls controls){
        this.id = id;
        this.model = model;
        this.controls = controls;
        setLabel(label);
        setFont(new Font("Helvetica", Font.BOLD, 20));
        setEnabled(false);
        addActionListener(this);
    }

    //listen
    public void actionPerformed(ActionEvent e){
        if (this.id == 1) this.model.darkLight();
        if (this.id == 2) funFactPopUp();
        if (this.id == 3) instrunctionsPopUp();
        if (this.id == 4) this.model.startStop();
        if (this.id == 5) this.model.arrowMove("up");
        if (this.id == 6) this.model.arrowMove("down");
        if (this.id == 7) this.model.arrowMove("left");
        if (this.id == 8) this.model.arrowMove("right");
    }

    //getters
    public int getID(){
        return id;
    }

    //utlity
    private void instrunctionsPopUp(){
        JOptionPane popup = new JOptionPane();
        popup.showMessageDialog(this.controls.getMain(),
            "1) Please select the insects to spawn (0-6), and select the color"
            + " of the insects (default or earth).\n \n"
            + "2) Click on the insect you want to move and use the buttons to\n"
            + "move it to your desired location.\n \n"
            + "3) If you hit a all scrolls, you can learn something new!",
            "Instructions", JOptionPane.WARNING_MESSAGE);
        this.controls.enableSim();
    }

    private void funFactPopUp(){
      JOptionPane popup = new JOptionPane();
      popup.showMessageDialog(this.controls.getMain(),
          "* Insects breathe through their exoeskeletons, via holes called\n"
          + " spiracles\n \n"
          + "* The largest insect ever known had a wingspan of 2.05ft.\n\n"
          + "* Most insects live for only a few days or weeks as adults :(\n\n"
          + "* Insects make up two thirds of all known organisms on Earth!\n\n"
          + "Hope you learned something new, thanks for playing!\n\n"
          + "Please, close and reopen the game if you wish to play again.",
          "Time to learn!", JOptionPane.WARNING_MESSAGE);

    }
}
