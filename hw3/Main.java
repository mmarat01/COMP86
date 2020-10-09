/*
 * COMP 86 - Assignment 3
 *
 * Main class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.BorderLayout;

@SuppressWarnings("deprecation")
public class Main extends JFrame{
    //private data
    private static final int LARGE_W = 1000;
    private static final int LARGE_H = 600;

    //main method
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Main(); // starting our Main in the GUI thread
            }
        });
    }

    //Main constructor
    public Main(){
        //window logistics
        setLocation(223,100); //center-ish of screen
        setSize(LARGE_W, LARGE_H); //large size, will make responsive later
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(161, 88, 48)); //bg color
        setLayout(new BorderLayout(10, 10)); //borderlayout with gaps

        Canvas canvas = new Canvas(); //drawing area
        add(canvas, BorderLayout.CENTER);
        Header header = new Header(); //title area
        add(header, BorderLayout.NORTH);
        Controls controls = new Controls(this, canvas, header); //controls area
        add(controls, BorderLayout.WEST);

        setVisible(true); //show it
    }


}
