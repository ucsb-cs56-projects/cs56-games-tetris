package edu.ucsb.cs56.projects.games.tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class HoldPanel extends JPanel {
    private Block heldBlock;
    Color blockColor;
    private static final int MAX_COL = 4;
    private static final int MAX_ROW = 4;

    public HoldPanel() {
        heldBlock = new Type1();
        blockColor = Color.BLACK;
    }

    public void setBlock(Block holdBlock) {
        blockColor = Color.BLACK;
        heldBlock = holdBlock;
    }
         
    public Block getHeldBlock() {
        return heldBlock;
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int row = 0; row<MAX_ROW; row++){
            for(int col = 0; col <MAX_COL; col++){
                if(heldBlock.getRowCol(row,col)== 1){
                    g2d.setColor(blockColor);
                    g2d.fillRect(20*col,20*row,20,20);
                }
                else{
                    g2d.setColor(Color.LIGHT_GRAY);
                    g2d.fillRect(20*col,20*row,20,20);
                }

            }
        }

    }

}

