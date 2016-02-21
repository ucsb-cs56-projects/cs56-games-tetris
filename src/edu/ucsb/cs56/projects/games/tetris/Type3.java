package edu.ucsb.cs56.projects.games.tetris;

/** 

    BLock Type3: generates Righthooked-shaped block.

    Extends Block abstract class.

    @author Jinouk Lee
    @version cs56, Tetris, Spring 2011
*/

public class Type3 extends Block{

	private int [][] type3= {{0,0,0,0},
				 {0,1,1,0},
				 {0,1,0,0},
				 {0,1,0,0}};
	int rotCounter = 1;


    /** 

	Default Constructor
	   

    */
    public Type3() {
    }

    /**

       Return the block
       @return String[2][2] array
    */
    public int[][] getBlock(){
    	return type3;
    }
    /**

       Return the value 0 or 1 that is located block demension (4x4)

    */
    
    public int getRowCol(int r, int c){
    	return type3[r][c];
    }
    
     /**
       
       Rotates the block

    */
    public void rotate(){
	rotated = true;
    	if(rotCounter == 1){
    		int [][] temp = {{0,0,0,0},{1,1,1,0},{0,0,1,0},{0,0,0,0}};
    		type3 = temp;
    		rotCounter++;
    	}
    	else if(rotCounter ==2){
    		int [][] temp = {{0,0,1,0},{0,0,1,0},{0,1,1,0},{0,0,0,0}};
    		type3 = temp;
    		rotCounter++;
    	}
    	else if(rotCounter ==3){
    		int [][] temp = {{0,0,0,0},{1,0,0,0},{1,1,1,0},{0,0,0,0}};
    		type3= temp;
    		rotCounter++;
    	}
    	else{
    		int [][] temp = {{0,0,0,0},{0,1,1,0},{0,1,0,0},{0,1,0,0}};
    		type3 = temp;
		    rotCounter =1;
    	}
    }    
}
