package edu.ucsb.cs56.projects.games.tetris;

/**
 * @(#)Block.java
 *
 *
 * @author Jinouk Lee
 * @version  2011/5/5
 */

abstract class Block {

    abstract void rotate();
    abstract int[][] getBlock();
    abstract int getRowCol(int r,int c);
    public boolean rotated = false;
    
    public void display(Block type){
	
	int [][] shape = new int [4][4];
	shape = type.getBlock();
	
	for(int row = 0; row<4;row++){
	    for(int col = 0; col<4;col++){
		if(shape[row][col] == 0)
		    System.out.print(" ");
		else if(shape[row][col] == 1)
		    System.out.print("*");
	    }
	    System.out.println();
    	}
    }
}
