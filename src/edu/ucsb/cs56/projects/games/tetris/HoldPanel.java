package edu.ucsb.cs56.projects.games.tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HoldPanel extends JPanel {
    private int[][] heldBlock;
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //get current block
        //set heldblock = currentblock block[][] variable
        //display block

    }
}



//make actionalistener in tetrisboard, on hold get current block and display it (call repaint)
