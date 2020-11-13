/*
 * COMP 86 - Assignment 7
 *
 * MyProgressBar class
 * Written by: Mijael Maratuech
 * October, 2020
 */
import javax.swing.JProgressBar;

@SuppressWarnings("deprecation")
public class MyProgressBar extends JProgressBar{
    public MyProgressBar(){
        setValue(0);
        setStringPainted(true);
    }
}
