
/*
 * COMP 86 - Assignment 2
 *
 * Controls class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

@SuppressWarnings("deprecated")
public class Controls extends JPanel{
    //private data
    private ControlsTitle c_title = new ControlsTitle(" SETTINGS: ");
    private NumAnts num_ants = new NumAnts();
    private ColorAnts color_ants = new ColorAnts();
    private MyButton dark_light = new MyButton("Dark Mode", 1);
    private MyButton fun_fact = new MyButton("Fun fact!", 2);
    private MyButton about = new MyButton("About", 3);
    private MyButton start_stop = new MyButton("START", 4);

    //constructor
    public Controls(){
        //panel logistics
        setBorder(new LineBorder(new Color(173, 108, 134), 5));
        setOpaque(false);
        setLayout(new GridLayout(7, 1));

        //title at the top
        add(c_title);

        //panel to organize first setting
        JPanel first = new JPanel();
        first.setOpaque(false);
        first.setLayout(new BorderLayout());
        add(first);
        JLabel first_name = new JLabel(" Number of ants: ");
        first_name.setFont(new Font("Helvetica", Font.BOLD, 20));

        //add first setting
        first.add(first_name, BorderLayout.WEST);
        first.add(num_ants, BorderLayout.EAST);

        //panel to organize second setting
        JPanel second = new JPanel();
        second.setOpaque(false);
        second.setLayout(new BorderLayout());
        add(second);
        JLabel second_name = new JLabel(" Color of ants: ");
        second_name.setFont(new Font("Helvetica", Font.BOLD, 20));

        //add buttons
        add(dark_light);
        add(fun_fact);
        add(about);
        add(start_stop);

        //add second setting
        second.add(second_name, BorderLayout.WEST);
        second.add(color_ants, BorderLayout.EAST);
    }
}
