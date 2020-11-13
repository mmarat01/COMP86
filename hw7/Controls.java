/*
 * COMP 86 - Assignment 7
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
    private MyLabel progress_label;
    private JPanel first;
    private JPanel second;
    private JPanel third;
    //the user controls
    private MyButton buttons[] = new MyButton[8];
    private MyCheckbox checkboxes[] = new MyCheckbox[6];
    private MyProgressBar progress;
    private MyRadioButton def_alt;
    //private reference
    private Model model;
    private Main main;
    //data
    private boolean read_about;

    //constructor
    public Controls(Model model, Main main){
        this.model = model;
        this.main = main;
        read_about = false;
        //main panel logistics
        setLayout(new GridLayout(9, 1));
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
        add(def_alt);
        add(second);
        for (int i = 4; i < 8; i++){
            second.add(buttons[i]);
        }
        add(third);
        third.add(progress_label, BorderLayout.WEST);
        third.add(progress, BorderLayout.EAST);
        for (int i = 0; i < 4; i++){
            add(buttons[i]);
        }
    }

    //utility
    private void initPanels(){
        first = new JPanel();
        first.setOpaque(false);
        first.setLayout(new GridLayout(2, 3));
        second = new JPanel();
        second.setOpaque(false);
        second.setLayout(new GridLayout(2, 2));
        third = new JPanel();
        third.setOpaque(false);
        third.setLayout(new BorderLayout());
    }

    private void initLabels(){
        c_title = new MyLabel(" SETTINGS: ", true, false, 30);
        progress_label = new MyLabel(" Progress: ", true, false, 20);
    }

    private void initControllers(){
        createButtons();
        createCheckBoxes();
        progress = new MyProgressBar();
        def_alt = new MyRadioButton("Earth", this.model);
    }

    private void createButtons(){
        for (int i = 0; i < 8; i++){
            buttons[i] = new MyButton(buttonName(i), i+1, this.model, this);
        }
        buttons[2].setEnabled(true);
    }

    private String buttonName(int n){
          switch(n){
              case 0: return "D i s p l a y   M o d e";
              case 1: return "F u n   F a c t !";
              case 2: return "I n s t r u c ti o n s";
              case 3: return "S T A R T";
              case 4: return "U P";
              case 5: return "D O W N";
              case 6: return "L E F T";
              case 7: return "R I G H T";
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

    //functionality
    public void enableSim(){
        for (MyCheckbox box : checkboxes){
            box.setEnabled(true);
        }
        for (MyButton button : buttons){
            if (button.getID() != 2) button.setEnabled(true);
        }
        def_alt.setEnabled(true);
    }
    public void disableSim(){
        for (MyCheckbox box : checkboxes) box.setEnabled(false);
        for (MyButton button : buttons){
            if (button.getID() != 4) button.setEnabled(false);
        }
        def_alt.setEnabled(false);
    }

    //getters
    public MyLabel getTitle(){
        return c_title;
    }
    public MyLabel getProgLabel(){
        return progress_label;
    }
    public Main getMain(){
        return this.main;
    }
    public MyButton getButton(int id){
        return buttons[id - 1];
    }
    public MyProgressBar getProgress(){
        return progress;
    }
}
