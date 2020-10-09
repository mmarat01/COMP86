
/*
 * COMP 86 - Assignment 3
 *
 * Controls class
 * Written by: Mijael Maratuech
 * October, 2020
 */

/*****************************************************************************


        TO DO: CHANGE LABELS SET UP SO I CAN CHANGE THEM W MYBUTTON LISTENER


*****************************************************************************/
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

@SuppressWarnings("deprecation")
public class Controls extends JPanel{
    //private data
    private SectionTitle c_title = new SectionTitle(" SETTINGS: ", true, false,
                                                    30);
    private JLabel num_label = new JLabel(" Number of ants: ");
    private JLabel color_label = new JLabel(" Color of ants: ");
    private NumAnts num_ants = new NumAnts();
    private ColorAnts color_ants = new ColorAnts();

    //constructor
    public Controls(Main main, Canvas canvas, Header header){
        //panel logistics
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        setLayout(new GridLayout(7, 1));
        setOpaque(false);
        //title at the top
        add(c_title);

        //panel to organize first setting
        JPanel first = new JPanel();
        first.setOpaque(false);
        first.setLayout(new BorderLayout());
        add(first);
        num_label.setFont(new Font("Helvetica", Font.BOLD, 20)); // CHANGE

        //add first setting
        first.add(num_label, BorderLayout.WEST);
        first.add(num_ants, BorderLayout.EAST);

        //panel to organize second setting
        JPanel second = new JPanel();
        second.setOpaque(false);
        second.setLayout(new BorderLayout());
        add(second);
        color_label.setFont(new Font("Helvetica", Font.BOLD, 20));  // CHANGE

        //add buttons
        add(new MyButton("D a r k   M o d e", 1, main, this, header, canvas));
        add(new MyButton("F u n   f a c t !", 2, main, this, header, canvas));
        add(new MyButton("A b o u t", 3, main, this, header, canvas));
        add(new MyButton("S T A R T", 4, main, this, header, canvas));

        //add second setting
        second.add(color_label, BorderLayout.WEST);
        second.add(color_ants, BorderLayout.EAST);
    }

    //getters
    public SectionTitle getTitle(){
        return c_title;
    }
    public JLabel getNumLabel(){
        return num_label;
    }
    public JLabel getColorLabel(){
        return color_label;
    }
}
