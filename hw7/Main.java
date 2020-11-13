/*
 * COMP 86 - Assignment 7
 *
 * Main class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.BorderLayout;

@SuppressWarnings("deprecation")
public class Main extends JFrame{
    //private data for the window only
    private static final int WIDTH = 1005;
    private static final int HEIGHT = 698;
    private static final int LAYOUT_GAPS = 10;

    /*private pieces of window, storing them to facilitate dark/light mode
      functionality through Model*/
    private Model model;
    private Canvas canvas;
    private Controls controls;
    private Header header;


    //main method
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Main(); // starting our Main in the GUI thread
            }
        });
    }

    //constructor
    public Main(){
        //window logistics
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(LAYOUT_GAPS, LAYOUT_GAPS));
        setTitle("Insect World, by Mijael Maratuech Seminario");

        //build it
        model = new Model(this);
        header = new Header();
        add(header, BorderLayout.NORTH);
        canvas = new Canvas(model); // reference to model for View
        add(canvas, BorderLayout.CENTER);
        controls = new Controls(model, this); // reference to model for Controller
        add(controls, BorderLayout.WEST);


        //show it
        setVisible(true);
    }

    //getters
    public Header getHeader(){
        return header;
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public Controls getControls(){
        return controls;
    }
}
