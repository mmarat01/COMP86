/*
 * COMP 86 - Assignment 4
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

@SuppressWarnings("deprecation")
public class Controls extends JPanel{
    //the controller's skeleton
    private MyLabel c_title;
    private MyLabel num_label;
    private JPanel first;
    private JPanel second;
    //the user controls
    private MyButton buttons[] = new MyButton[4];
    private MyCheckbox checkboxes[] = new MyCheckbox[6];
    private NumScrolls num_scrolls;
    //private reference
    private Model model;

    //constructor
    public Controls(Model model){
        this.model = model;
        //main panel logistics
        setLayout(new GridLayout(7, 1));
        setOpaque(false);
        //set border once, rest in Model
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        initPanels();
        //initialize controllers on panel
        initLabels();
        initControllers();
        //add to main panel
        add(c_title);
        add(first);
        for (MyCheckbox box : checkboxes){
            first.add(box);
        }
        add(second);
        second.add(num_label, BorderLayout.WEST);
        second.add(num_scrolls, BorderLayout.EAST);
        for (MyButton button : buttons){
            add(button);
        }
    }

    //utility
    private void initPanels(){
        first = new JPanel();
        first.setOpaque(false);
        first.setLayout(new GridLayout(2, 3));
        second = new JPanel();
        second.setOpaque(false);
        second.setLayout(new BorderLayout());
    }
    private void initLabels(){
        c_title = new MyLabel(" SETTINGS: ", true, false, 30);
        num_label = new MyLabel(" Number of scrolls: ", true, false, 20);
    }
    private void initControllers(){
        createButtons();
        createCheckBoxes();
        num_scrolls = new NumScrolls(this.model);

    }
    private void createButtons(){
        for (int i = 0; i < 4; i++){
            buttons[i] = new MyButton(buttonName(i), i+1, this.model);
        }
    }
    private String buttonName(int n){
          switch(n){
              case 0: return "D i s p l a y   M o d e";
              case 1: return "F u n   F a c t !";
              case 2: return "A b o u t";
              case 3: return "R E S E T";
              default: return "";
          }
    }
    private void createCheckBoxes(){
        for (int i = 0; i < 6; i++){
            checkboxes[i] = new MyCheckbox(checkBoxName(i), i+1, this.model);
        }
    }
    private String checkBoxName(int n){
        switch(n){
            case 0: return "Ant";
            case 1: return "Fly";
            case 2: return "Caterpillar";
            case 3: return "Ladybug";
            case 4: return "Cricket";
            case 5: return "Beetle";
            default: return "";
        }
    }

    //getters
    public MyLabel getTitle(){
        return c_title;
    }
    public MyLabel getNumLabel(){
        return num_label;
    }
}
