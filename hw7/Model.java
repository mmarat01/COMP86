/*
 * COMP 86 - Assignment 7
 *
 * Model class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import java.util.ArrayList;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Graphics2D;

@SuppressWarnings("deprecation")
public class Model{

    private Main main;

    //data
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private Vehicle selected;
    private boolean light;
    private boolean started;
    private boolean tick_val;
    private final Color MAIN_BG = new Color(161, 88, 48);
    private final Color ALT_BG = new Color(74, 38, 8);
    private final Color ALT_FONT = new Color(217, 217, 217);
    private final Color MAIN_FONT = Color.BLACK;
    private final int BORDER_W = 5;
    private int caught_scrolls;
    private Maze maze = new Maze();

    //constructor
    public Model(Main main){
        this.main = main;
        light = true;
        started = false;
        tick_val = false;
        selected = null;
        caught_scrolls = 0;
        this.main.getContentPane().setBackground(MAIN_BG);
        createVehicles();
    }

    /************************
    *     functionality     *
    ************************/
    //dark and light mode functionality
    public void darkLight(){
        if (light){
            main.getContentPane().setBackground(ALT_BG);
            main.getHeader().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getCanvas().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getControls().setBorder(new LineBorder(MAIN_BG, BORDER_W));
            main.getControls().getTitle().setForeground(ALT_FONT);
            main.getControls().getProgLabel().setForeground(ALT_FONT);
            main.getHeader().getTitle().setForeground(ALT_FONT);
            light = false;
        } else {
            main.getContentPane().setBackground(MAIN_BG);
            main.getHeader().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getCanvas().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getControls().setBorder(new LineBorder(ALT_BG, BORDER_W));
            main.getControls().getTitle().setForeground(MAIN_FONT);
            main.getControls().getProgLabel().setForeground(MAIN_FONT);
            main.getHeader().getTitle().setForeground(MAIN_FONT);
            light = true;
        }
    }

    public void drawSim(Graphics2D g2D, Canvas canvas, int width, int start_w,
                        int height, int start_h){
        int rect_w = (int) (40 * ((float) width / (float) start_w));
        int rect_h = (int) (40 * ((float) height / (float) start_h));
        drawMaze(g2D, rect_w, rect_h);
        drawVehicles(g2D, canvas, rect_w, rect_h);
    }

    public void setInsectColor(boolean alt_icon){
        for (int i = 0; i < 6; i++){
            vehicles.get(i).setIcon(alt_icon);
        }
    }

    public void startStop(){
        if (!started){
            started = true;
            this.main.getControls().getButton(4).setLabel("S T O P");
            this.main.getCanvas().getTimer().start();
        } else {
            this.main.getCanvas().getTimer().stop();
            this.main.getControls().getButton(4).setLabel("S T A R T");
            started = false;
            for (Vehicle v : vehicles){
                if (v instanceof Insect) v.resetXY();
            }
            repaint();
        }
    }

    public void addRemoveInsect(int id, boolean active){
        if (active){
            vehicles.get(id).setActivity(active);
        } else {
            vehicles.get(id).setActivity(active);
            vehicles.get(id).resetXY();
        }
    }

    public void repaint(){
        this.main.getCanvas().repaint();
    }

    public void correlate(int x, int y){
        if (started){
            for (Vehicle v : vehicles){
                if (v.isActive() && (v instanceof Insect)){
                    if (v.pickCorrelation(x, y)){
                        selected = v;
                    }
                }
            }
        }
    }

    public void arrowMove(String command){
        if (started && (selected != null)){
            if (command == "up"){
                if (!defaultCollision(selected.getX(), selected.getY()-1)){
                    selected.moveUp();
                }
            } else if (command == "down"){
                if (!defaultCollision(selected.getX(), selected.getY()+1)){
                    selected.moveDown();
                }
            } else if (command == "right"){
                if (!defaultCollision(selected.getX()+1, selected.getY())){
                    selected.moveRight();
                }
            } else if (command == "left"){
                if (!defaultCollision(selected.getX()-1, selected.getY())){
                    selected.moveLeft();
                }
            }
            checkScrollCollision();
            repaint();
        }
    }

    /************************
    *    PRIVATE METHODS    *
    ************************/
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
        createInsects();
        createScrolls();
    }

    private void createInsects(){
        for (int i = 0; i < 6; i++){
            switch (i){
                case 0: vehicles.add(new Insect(6, 7, "ant.png", "ant-alt.png"));
                break;
                case 1: vehicles.add(new Insect(7, 7, "fly.png", "fly-alt.png"));
                break;
                case 2: vehicles.add(new Insect(8, 7, "caterpillar.png", "caterpillar-alt.png"));
                break;
                case 3: vehicles.add(new Insect(6, 8, "ladybug.png", "ladybug-alt.png"));
                break;
                case 4: vehicles.add(new Insect(7, 8, "cricket.png", "cricket-alt.png"));
                break;
                case 5: vehicles.add(new Insect(8, 8, "beetle.png", "beetle-alt.png"));
                break;
            }
        }
    }

    private void createScrolls(){
        for (int i = 6; i < 12; i++){
            switch (i){
                case 6: vehicles.add(new Scroll(1, 1, 7, 1, "scroll.png"));
                break;
                case 7: vehicles.add(new Scroll(13, 1, 7, 13, "scroll.png"));
                break;
                case 8: vehicles.add(new Scroll(1, 7, 5, 4, "scroll.png"));
                break;
                case 9: vehicles.add(new Scroll(13, 7, 9, 4, "scroll.png"));
                break;
                case 10: vehicles.add(new Scroll(1, 13, 5, 10, "scroll.png"));
                break;
                case 11: vehicles.add(new Scroll(13, 13, 9, 10, "scroll.png"));
                break;
            }
        }
    }

    private void drawVehicles(Graphics2D g2D, Canvas canvas, int rect_w,
                            int rect_h){
        moveScrolls();
        for (Vehicle v : vehicles){
            if(v.isActive()) v.draw(g2D, canvas, rect_w, rect_h);
        }
    }

    private void moveScrolls(){
        if (started && tick_val){
            for (Vehicle v : vehicles){
                if (v instanceof Scroll && v.isActive()){
                    v.tick(this.main.getCanvas().getFrameNum());
                }
            }
            tick_val = false;
        }
        checkScrollCollision();
    }

    private boolean defaultCollision(int x, int y){
        if (maze.getGrid()[y][x] == '#' || checkInsectCoords(x, y)){
            return true;
        }
        return false;
    }

    private boolean checkInsectCoords(int x, int y){
        int count = 0;
        for (Vehicle v : vehicles){
            if (v.isActive() && (v instanceof Insect)){
                if (v.getX() == x && v.getY() == y){
                    return true;
                }
            }
        }
        return false;
    }

    private void checkScrollCollision(){
        for (Vehicle v1 : vehicles){
            if (v1.isActive() && v1 instanceof Insect){
                for (Vehicle v2 : vehicles){
                    if (v2.isActive() && v2 instanceof Scroll){
                        if (v1.getX() == v2.getX() && v1.getY() == v2.getY()){
                            v2.setActivity(false);
                            caught_scrolls += 1;
                            updateProgress();
                        }
                    }
                }
            }
        }
        unlockFunFact();
    }

    private void unlockFunFact(){
        int count = 0;
        for (Vehicle v : vehicles){
            if (v.isActive() && v instanceof Scroll){
                count += 1;
            }
        }
        if (count == 0) this.main.getControls().getButton(2).setEnabled(true);
    }

    private void updateProgress(){
        int curr_prog = this.main.getControls().getProgress().getValue();
        if (caught_scrolls < 6){
            this.main.getControls().getProgress().setValue(curr_prog + 16);
        } else if (caught_scrolls == 6){
            this.main.getControls().getProgress().setValue(curr_prog + 20);
        }
    }

    //setters
    public void setTick(){
        tick_val = true;
    }

}
