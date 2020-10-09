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
    private Main main;
    private Controls controls;
    private Header header;
    private Canvas canvas;

    private boolean light;

    //constructor.
    /* more functionality will be added as i plan on doing a few different
    manipulations based on the actions performed on the button. i haven't
    figured out how to work around them with the listeners yet, though. */
    public MyButton(String label, int id, Main main, Controls controls, Header
                    header, Canvas canvas){
        this.id = id;
        this.main = main;
        this.controls = controls;
        this.canvas = canvas;
        this.header = header;
        light = true;
        setLabel(label);
        setFont(new Font("Helvetica", Font.BOLD, 20));
        addActionListener(this);
    }

    //listen
    public void actionPerformed(ActionEvent e){
        System.out.println("This, depending on the label/id of the button will"
                           + " either change the display of the game, show"
                           + " a fun fact about ants (means: TBD), show an"
                           + " 'about' page, or start/stop the game");

        if (this.id == 1 && light){
            light = false;

            main.getContentPane().setBackground(new Color(74, 38, 8));

            controls.setBorder(new LineBorder(new Color(161, 88, 48), 5));
            canvas.setBorder(new LineBorder(new Color(161, 88, 48), 5));
            header.setBorder(new LineBorder(new Color(161, 88, 48), 5));

            controls.getTitle().setForeground(new Color(217, 217, 217));
            controls.getNumLabel().setForeground(new Color(217, 217, 217));
            controls.getColorLabel().setForeground(new Color(217, 217, 217));
            header.getTitle().setForeground(new Color(217, 217, 217));

            setLabel("Light Mode");
        } else if (this.id == 1 && !light){
            light = true;

            main.getContentPane().setBackground(new Color(161, 88, 48));

            controls.setBorder(new LineBorder(new Color(74, 38, 8), 5));
            canvas.setBorder(new LineBorder(new Color(74, 38, 8), 5));
            header.setBorder(new LineBorder(new Color(74, 38, 8), 5));

            controls.getTitle().setForeground(Color.BLACK);
            controls.getNumLabel().setForeground(Color.BLACK);
            controls.getColorLabel().setForeground(Color.BLACK);
            header.getTitle().setForeground(Color.BLACK);

            setLabel("Dark Mode");
        }
    }
}
