/*
 * COMP 86 - Assignment 7
 *
 * Canvas class
 * Written by: Mijael Maratuech
 * October, 2020
 */

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("deprecation")
public class Canvas extends JPanel implements ActionListener, MouseListener{
    private final int start_w = 605;
    private final int start_h = 605;
    private final Color CANV_BG = new Color(137, 148, 78);
    private final Color BG_DOTS = new Color(164, 175, 103);
    private final Color WALLS = new Color(62, 29, 22);
    private Model model;
    private Timer timer;
    private int frame_num = 1;
    //constructor
    public Canvas(Model model){
        setBackground(CANV_BG);
        //set border once, rest in Model
        setBorder(new LineBorder(new Color(74, 38, 8), 5));
        setOpaque(true);
        timer = new Timer(3000, this);
        addMouseListener(this);
        this.model = model;
    }

    //paint
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        drawDots(g2D, height, width);

        g2D.setColor(WALLS);
        this.model.drawSim(g2D, this, width, start_w, height, start_h);
    }

    //utility
    private void drawDots(Graphics g2D, int height, int width){
        g2D.setColor(BG_DOTS); //dot green
        //bg dots
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if ((i % 30 == 0) && (j % 30 == 0)){
                    g2D.drawOval(j, i, 10, 10);
                    g2D.fillOval(j, i, 10, 10);
                }
            }
        }
    }
    public int getFrameNum(){
        return frame_num;
    }
    public Timer getTimer(){
        return timer;
    }

    //listen
    public void actionPerformed(ActionEvent e){
        frame_num++;
        this.model.setTick();
        repaint();
    }

    public void mouseClicked(MouseEvent e){
        this.model.correlate(e.getX(), e.getY());
    }

    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};
    public void mousePressed(MouseEvent e){};
    public void mouseReleased(MouseEvent e){};
}
