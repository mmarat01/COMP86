/*
 * COMP 86 - Assignment 1
 * Simple GUI with multiple widgets. Different interactions cause different
   behaviors. Messages/labels are a combination of incoherent text and song
   lyrics.
 *
 * Main class
 * Written by: Mijael Maratuech
 * September, 2020
 */

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import java.awt.FlowLayout;
import java.awt.EventQueue;
import java.awt.Color;

public class Main extends JFrame {
    //main method
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Main(); // starting our Main in the GUI thread
            }
        });
    }

    //Main object constructor
    public Main(){
       setSize(800, 500); // frame size
       setLayout(new FlowLayout());
       setDefaultCloseOperation(EXIT_ON_CLOSE); // closing? exit
       getContentPane().setBackground(new Color(197, 173, 235));//bground color

       createWidgets(); //adds all new widgets we created

       setVisible(true); //set everything visible
    }

    //creates and adds widgets to the frame
    private void createWidgets(){
        add(new ScrollBar(1, 1));
        add(new Button("press this first", "thanks!", 1));
        add(new Button("no, press this first", "oh yeah, that was great", 2));
        add(new Button("why did you press those?",
                       "i don't like you", 3));
        add(new Button("don't press this", "you woke me up", 4));
        add(new Button("i really feel like counting today",
                       "numbers are infinite", 5));
        add(new ScrollBar(2, 2));
        add(new ProgressBar());
        add(new Label("THERE'S LEAD IN THE WATER"));
        add(new List());
        add(new ColorChooser());
    }
}
