package edu.ucsb.cs56.projects.games.tetris;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;


import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Point;

/**
 * @(#)TetrisBoard.java
 *
 *
 * @author
 * @version 1.00 2011/5/8
 */


public class TetrisBoard extends JPanel implements ActionListener {


    Block BlockInControl;
    Color BlockColor;
    int whichType;
    static JLabel statusBar;
    int score = 0;

    private final int MAX_COL = 10;
    private final int MAX_ROW = 20;
    private int[][] board = new int[MAX_ROW][MAX_COL];
    private int[][] color = new int[MAX_ROW][MAX_COL];
    
    Timer timer;
    int timerdelay;
    boolean isFallingFinished = false;
    boolean isStarted = false;
    boolean isPaused = false;
    
    int BlockPosX,BlockPosY;
    
    public TetrisBoard() {
    	for(int row = 0; row < MAX_ROW; row++){
	    for(int col = 0; col<MAX_COL; col++){
		board[row][col] = 0;
		color[row][col] = 0;
	    }
    	}
	this.setFocusable(true);
	BlockColor = Color.BLACK;
	Type1 y = new Type1();
	this.putBlock(y);
	timerdelay = 400;
	timer = new Timer(timerdelay,this);
	timer.start();

	this.setPreferredSize(new Dimension(205,460));
	this.setBackground(Color.WHITE);

	//if(this.canMoveDown() == true) 
	addKeyListener(new TAdapter());
    }
    
    public void actionPerformed(ActionEvent e) {
	if (isFallingFinished) {
	    isFallingFinished = false;
	    int randomNumber = (int)(Math.random() * 7) + 1;
	    switch(randomNumber){
	    case 1: Type1 a = new Type1();
		whichType = 1;
		this.putBlock(a);
		break;
	    case 2: Type2 b = new Type2();
		whichType = 2;
		this.putBlock(b);
		break;
	    case 3: Type3 c = new Type3();
		whichType = 3;
		this.putBlock(c);
		break;
	    case 4: Type4 d = new Type4();
		whichType = 4;
		this.putBlock(d);
		break;
	    case 5: Type5 h = new Type5();
		whichType = 5;
		this.putBlock(h);
		break;
	    case 6: Type6 f = new Type6();
		whichType = 6;
		this.putBlock(f);
		break;
	    case 7: Type7 g = new Type7();
		whichType = 7;
		this.putBlock(g);
		break;
	    }
	    if(timerdelay > 200){
		double x = .1*timerdelay;
		timerdelay = timerdelay - (int)x;
	    }
	    timer.setDelay(timerdelay);
	}
	else 
	    {
		this.moveDown();
		this.deleteRows();
		this.deleteRows();
		this.deleteRows();
		this.deleteRows();
	    }
	this.repaint();

    }
    
    public int getBlockPosX(){
    	return this.BlockPosX;
    }

    public int getBlockPosY(){
    	return this.BlockPosY;
    }

    public int getRowCol(int r, int c){
    	return board[r][c];
    }

    public void clearBoard(){
    	for(int row = 0; row < MAX_ROW; row++){
    		for(int col = 0; col<MAX_COL; col++){
    			board[row][col] = 0;
			color[row][col] = 0;
    		}
    	}
    }

    public void putBlock(Block block){
	score++;
	statusBar.setText("SCORE = " + String.valueOf(score));
	//int [][] theBlock = block.getBlock();
	//int k = (int)(Math.random() * MAX_COL);

	BlockPosX = 5;
	BlockPosY = 0;
	int posX = 5;
	int posY = 0;
	BlockInControl = block;

	int x = 0;
	for(int i=0;i<MAX_COL;i++){
	    if(board[posY+1][i] == 1)
	        x = 1;
	}
	if(x==1){
	    this.clearBoard();
	    score = 0;
	}


	for(int r=0;r<4;r++){
	    for(int c=0;c<4;c++){
		if(block.getRowCol(r,c) == 1)
		    {
			board[posY][posX]=1;

			switch(whichType){
			case 1: color[posY][posX] = 1;
			    break;
			case 2: color[posY][posX] = 2;
			    break;
			case 3: color[posY][posX] = 3;
			    break;
			case 4: color[posY][posX] = 4;
			    break;
			case 5: color[posY][posX] = 5;
			    break;
			case 6: color[posY][posX] = 6;
			    break;
			case 7: color[posY][posX] = 7;
			    break;
			}
		    }

		posX++;
	    }
	    posY++;
	    posX-=4;
	}
    }


    public boolean canMoveRight(){

    	int [][] temp = BlockInControl.getBlock();
    	int tempPosX = BlockPosX;
    	int	tempPosY = BlockPosY;

    	for(int r = 0; r <4; r++){
    		for(int c = 0; c < 4;c++){
    			if(temp[r][c] == 1){
    				if(c ==3){
    					if(tempPosX+1 > MAX_COL-1)
    						return false;
    					if(board[tempPosY][tempPosX+1]==1)
    						return false;
    				}
    				else{
    					if(tempPosX+1 > MAX_COL-1)
    						return false;
    					if(temp[r][c+1] == 0){
    						if(board[tempPosY][tempPosX+1]==1)
    						return false;
    					}
    				}
    			}
    			tempPosX++;
    		}
    		tempPosX = BlockPosX;
    		tempPosY++;
    	}
		return true;
    }

	public boolean canMoveLeft(){

		int [][] temp = BlockInControl.getBlock();
    	int tempPosX = BlockPosX;
    	int	tempPosY = BlockPosY;

    	for(int r = 0; r <4; r++){
    		for(int c = 0; c < 4;c++){
    			if(temp[r][c] == 1){
    				if(c ==0){
    					if(tempPosX-1 < 0)
    						return false;
    					if(board[tempPosY][tempPosX-1]==1)
    						return false;
    				}
    				else{
    					if(tempPosX-1 < 0)
    						return false;
    					if(temp[r][c-1] == 0){
    						if(board[tempPosY][tempPosX-1]==1)
    							return false;
    					}
    				}
    			}
    			tempPosX++;
    		}
    		tempPosX = BlockPosX;
    		tempPosY++;
    	}
		return true;
	}
	public boolean canMoveDown(){
	    int [][] temp = BlockInControl.getBlock();
    	int tempPosX = BlockPosX;
    	int	tempPosY = BlockPosY;

    	for(int r = 0; r <4; r++){
    		for(int c = 0; c < 4;c++){
    			if(temp[r][c] == 1){
    				if(r ==3){
    					if(tempPosY+1 > MAX_ROW-1)
    						return false;
    					if(board[tempPosY+1][tempPosX]==1)
    						return false;
    				}
    				else{
    					if(tempPosY+1 > MAX_ROW-1)
    						return false;
    					if(temp[r+1][c] == 0){
    						if(board[tempPosY+1][tempPosX]==1)
    							return false;
    					}
    				}
    			}
    			tempPosX++;
    		}
    		tempPosX = BlockPosX;
    		tempPosY++;
    	}

		return true;
	}

	public void moveRight(){
		if(canMoveRight()){
			int[][] temp = BlockInControl.getBlock();
			int tempPosX = BlockPosX;
			int tempPosY = BlockPosY;
			ArrayList <Point> CoordinatesToRight = new ArrayList <Point>();

			for(int r=0; r<4; r++){
				for(int c=0;c<4;c++){
					if(temp[r][c] == 1 && getRowCol(tempPosY,tempPosX)==1){
						CoordinatesToRight.add(new Point(tempPosX,tempPosY));
						board[tempPosY][tempPosX]=0;
						color[tempPosY][tempPosX]=0;
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToRight){
				board[(int)p.getY()][(int)p.getX()+1]=1;
				color[(int)p.getY()][(int)p.getX()+1]= whichType;
			}

			CoordinatesToRight.clear();
			CoordinatesToRight = null;
			BlockPosX++;
		}
	}

	public void moveLeft(){
		if(canMoveLeft()){
			int[][] temp = BlockInControl.getBlock();
			int tempPosX = BlockPosX;
			int tempPosY = BlockPosY;
			ArrayList <Point> CoordinatesToLeft = new ArrayList <Point>();

			for(int r=0; r<4; r++){
				for(int c=0;c<4;c++){
					if(temp[r][c] == 1 && getRowCol(tempPosY,tempPosX)==1){
						CoordinatesToLeft.add(new Point(tempPosX,tempPosY));
						board[tempPosY][tempPosX]=0;
						color[tempPosY][tempPosX]=0;
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToLeft){
				board[(int)p.getY()][(int)p.getX()-1]=1;
				color[(int)p.getY()][(int)p.getX()-1]=whichType;
			}

			CoordinatesToLeft.clear();
			CoordinatesToLeft = null;
			BlockPosX--;

		}

	}

	public void moveDown(){

		if(canMoveDown()){
			int[][] temp = BlockInControl.getBlock();
			int tempPosX = BlockPosX;
			int tempPosY = BlockPosY;
			ArrayList <Point> CoordinatesToDown = new ArrayList <Point>();

			for(int r=0; r<4; r++){
				for(int c=0;c<4;c++){
					if(temp[r][c] == 1 && getRowCol(tempPosY,tempPosX)==1){
						CoordinatesToDown.add(new Point(tempPosX,tempPosY));
						board[tempPosY][tempPosX]=0;
						color[tempPosY][tempPosX]=0;
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToDown){
				board[(int)p.getY()+1][(int)p.getX()]=1;
				color[(int)p.getY()+1][(int)p.getX()]=whichType;
			}

			CoordinatesToDown.clear();
			CoordinatesToDown = null;
			BlockPosY++;
		}
		else
		    isFallingFinished=true;;

	}

	public void drop(){
		while(canMoveDown())
			moveDown();
	}

    public void deleteRows(){
	int nodelete;
	int rowtobedeleted = 0;
    
	for(int row = 0; row<MAX_ROW; row++){
	    nodelete = 0;
	    for(int col = 0; col <MAX_COL; col++){
		if(board[row][col] == 0)
		    nodelete = 1;
	    }
	    if(nodelete == 0){
		rowtobedeleted = row;
	    }
	}
	if(rowtobedeleted != 0){
	    for(int row = rowtobedeleted; row > 1; row--)
		for (int col = 0; col < MAX_COL; col++){
			board[row][col] = board[row-1][col];
		    }
	}
	for (int col = 0; col < MAX_COL; col++)
	    board[0][col] = 0;
	if(rowtobedeleted != 0){
	    score = score + 10;
	    statusBar.setText("SCORE = " + String.valueOf(score));
	}
    }

    public Color getColor(int x){
	switch(x){
	case 1: BlockColor = Color.BLACK;
	    break;
	case 2: BlockColor = Color.GREEN;
	    break;
	case 3: BlockColor =  Color.BLUE;
	    break;
	case 4: BlockColor =  Color.ORANGE;
	    break;
	case 5: BlockColor =  Color.MAGENTA;
	    break;
	case 6: BlockColor =  Color.BLUE;
	    break;
	case 7: BlockColor =  Color.RED;
	    break;

	}
	return BlockColor;
    }




    public void paint(Graphics gr)
    {
	super.paint(gr);
	for(int row = 0; row<MAX_ROW; row++){
	    for(int col = 0; col <MAX_COL; col++){
		if(board[row][col] == 1){
		    gr.setColor(getColor(color[row][col]));
		    gr.fillRect(20*col,20*row,20,20);
		}
		else{
		    gr.setColor(Color.WHITE);
		    gr.fillRect(20*col,20*row,20,20);
		}

	    }
	}
    }

    private void pause()
    {	
	isPaused = !isPaused;
	if (isPaused) {
	    timer.stop();
            statusBar.setText("GAME PAUSED");
	} else {
	    timer.start();
	    statusBar.setText("SCORE = " + String.valueOf(score));
	}
	repaint();
    }
    
    
    class TAdapter extends KeyAdapter {
         public void keyPressed(KeyEvent e) {

             int keycode = e.getKeyCode();
	     
             if (keycode == 'p' || keycode == 'P') {
                 pause();
                 return;
             }
	     
             if (isPaused)
                 return;
	     
             switch (keycode) {
             case KeyEvent.VK_LEFT:
                 moveLeft();
                 break;
             case KeyEvent.VK_RIGHT:
                 moveRight();
                 break;
             case KeyEvent.VK_SPACE:
                 drop();
                 break;
             }

         }
    }

	public static void main(String [] args){

	    JFrame window = new JFrame("TETRIS");

	    window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	    statusBar = new JLabel("SCORE = 0");
	    window.getContentPane().add(BorderLayout.SOUTH, statusBar);

	    TetrisBoard b = new TetrisBoard();
	    window.add(b);
	    window.setSize(205,460);
	    window.setVisible(true);
	    
	}

    }
