/*
 * COMP 86 - Assignment 4
 *
 * Model class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import java.util.ArrayList;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Graphics2D;

public class Model{
    /* needed reference to main for dark/light mode functionality --
      the window coloring will also be set up in Model because the
      Color variables already exist here given the dark/light mode
      functionality so why not */
    private Main main;

    //data
    private Vehicle vehicles[] = new Vehicle[14];
    private boolean light;
    private final Color MAIN_BG = new Color(161, 88, 48);
    private final Color ALT_BG = new Color(74, 38, 8);
    private final Color ALT_FONT = new Color(217, 217, 217);
    private final Color MAIN_FONT = Color.BLACK;
    private final int BORDER_W = 5;
    private Maze maze = new Maze();

    //constructor
    public Model(Main main){
        this.main = main;
        light = true;
        main.getContentPane().setBackground(MAIN_BG);
        createVehicles();
    }

    //methods
    public void darkLight(){
        if (light){
            main.getContentPane().setBackground(ALT_BG);
            main.getHeader().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getCanvas().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getControls().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getControls().getTitle().setForeground(ALT_FONT);
            main.getControls().getNumLabel().setForeground(ALT_FONT);
            main.getHeader().getTitle().setForeground(ALT_FONT);
            light = false;
        } else {
            main.getContentPane().setBackground(MAIN_BG);
            main.getHeader().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getCanvas().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getControls().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getControls().getTitle().setForeground(MAIN_FONT);
            main.getControls().getNumLabel().setForeground(MAIN_FONT);
            main.getHeader().getTitle().setForeground(MAIN_FONT);
            light = true;
        }
    }

    public void drawSim(Graphics2D g2D, Canvas canvas, int width, int start_w,
                        int height, int start_h){
        int rect_w = (int) (40 * ((float) width / (float) start_w));
        int rect_h = (int) (40 * ((float) height / (float) start_h));
        drawMaze(g2D, rect_w, rect_h);
        drawVehicles(g2D, canvas, rect_w, rect_h); //TODO: MIGHT ADJUST RATIO FOR VEHICLES
    }

    private void drawMaze(Graphics2D g2D, int rect_w, int rect_h){
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j] == '#') {
                    //don't resize below this ratio
                    if (rect_w < 40 && rect_h < 40){
                        g2D.fillRect(j*40, i*40, 40, 40);
                     //resize height only
                    } else if (rect_w < 40 && rect_h >= 40){
                        g2D.fillRect(j*40, i*rect_h, 40, rect_h);
                    //resize width only
                    } else if (rect_w >= 40 && rect_h < 40){
                        g2D.fillRect(j*rect_w, i*40, rect_w, 40);
                    //resize both
                    } else {
                        g2D.fillRect(j*rect_w, i*rect_h, rect_w, rect_h);
                    }
                }
            }
        }
    }

    private void createVehicles(){
        vehicles[0] = new Ant(6, 7, "ant.png");
        vehicles[1] = new Fly(7, 7, "fly.png");
        vehicles[2] = new Caterpillar(8, 7, "caterpillar.png");
        vehicles[3] = new Ladybug(6, 8, "ladybug.png");
        vehicles[4] = new Cricket(7, 8, "cricket.png");
        vehicles[5] = new Beetle(8, 8, "beetle.png");
        vehicles[6] = new Scroll(1, 1, "scroll.png");
        vehicles[7] = new Scroll(7, 1, "scroll.png");
        vehicles[8] = new Scroll(13, 1, "scroll.png");
        vehicles[9] = new Scroll(1, 7, "scroll.png");
        vehicles[10] = new Scroll(13, 7, "scroll.png");
        vehicles[11] = new Scroll(1, 13, "scroll.png");
        vehicles[12] = new Scroll(7, 13, "scroll.png");
        vehicles[13] = new Scroll(13, 13, "scroll.png");
    }

    private void drawVehicles(Graphics2D g2D, Canvas canvas, int rect_w,
                              int rect_h){
        for (Vehicle v : vehicles){
            if(v.isActive()) v.draw(g2D, canvas, rect_w, rect_h);
        }
    }

    public Vehicle[] getVehicles(){
        return vehicles;
    }

    public void setScrolls(int max){
        for (int i = 6; i < 6 + max; i++) vehicles[i].setActivity(true);
        for (int i = 6 + max; i < 14; i++) vehicles[i].setActivity(false);
    }
    public void repaint(){
        this.main.getCanvas().repaint();
    }

}
