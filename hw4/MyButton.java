/*
 * COMP 86 - Assignment 3
 *
 * MyButton class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("deprecation")
public class MyButton extends JButton implements ActionListener{
    //private data
    private int id;
    private Model model;

    //constructor
    public MyButton(String label, int id, Model model){
        this.id = id;
        this.model = model;
        setLabel(label);
        setFont(new Font("Helvetica", Font.BOLD, 20));
        addActionListener(this);
    }

    //listen
    public void actionPerformed(ActionEvent e){
        if (this.id == 1) model.darkLight();
    }
}
