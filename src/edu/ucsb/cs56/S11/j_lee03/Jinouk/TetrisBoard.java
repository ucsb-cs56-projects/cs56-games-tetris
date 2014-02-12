package edu.ucsb.cs56.S11.j_lee03.Jinouk;

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


public class TetrisBoard {


	Block BlockInControl;

	private final int MAX_COL = 10;
	private final int MAX_ROW = 30;
	private int[][] board = new int[30][10];

	int BlockPosX,BlockPosY;

    public TetrisBoard() {
    	for(int row = 0; row < 30; row++){
    		for(int col = 0; col<10; col++){
    			board[row][col] = 0;
    		}
    	}
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
    	for(int row = 0; row < 30; row++){
    		for(int col = 0; col<10; col++){
    			board[row][col] = 0;
    		}
    	}
    }

	public void putBlock(Block block, int posX, int posY){

		//int [][] theBlock = block.getBlock();
		BlockPosX = posX;
		BlockPosY = posY;
		BlockInControl = block;

		for(int r=0;r<4;r++){
			for(int c=0;c<4;c++){
				if(block.getRowCol(r,c)==1)
					board[posY][posX] = 1;
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
		System.out.println(canMoveRight());
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
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToRight)
				board[(int)p.getY()][(int)p.getX()+1]=1;

			CoordinatesToRight.clear();
			CoordinatesToRight = null;
			BlockPosX++;
		}



	}

	public void moveLeft(){
		System.out.println(canMoveLeft());
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
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToLeft)
				board[(int)p.getY()][(int)p.getX()-1]=1;

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
					}
					tempPosX++;
				}
				tempPosY++;
				tempPosX-=4;
			}

			for(Point p : CoordinatesToDown)
				board[(int)p.getY()+1][(int)p.getX()]=1;

			CoordinatesToDown.clear();
			CoordinatesToDown = null;
			BlockPosY++;
		}

	}

	public void drop(){
		while(canMoveDown())
			moveDown();
	}

	public void display(){

		System.out.println("	1234567890");
		for(int row = 0; row<30; row++){
			System.out.print(row + "	");
			for(int col = 0; col <10; col++){
				if(board[row][col] == 1)
					System.out.print("*");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}

	public static void main(String [] args){

		TetrisBoard b = new TetrisBoard();
		Type2 t2 = new Type2();
		Type3 t3 = new Type3();



		b.putBlock(t3,4,9);
		//b.drop();
		b.display();
		b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveDown();
    /*b.moveDown();
    b.moveDown();
    b.moveDown();
		b.moveDown();
		b.moveDown();b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveDown();b.moveDown();
		b.moveDown();
		b.moveDown();
		b.moveDown();
		b.display();
		b.moveRight();
		b.moveRight();
		b.moveRight();
		b.moveRight();
		b.moveRight();

		b.display();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.moveLeft();
		b.display();
		*/
	}

}

