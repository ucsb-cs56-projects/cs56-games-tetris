package edu.ucsb.cs56.projects.games.tetris;

/** 

    Block Type2 Mountain Shape

    Extends Block abstract class.

    @author Jinouk Lee
    @version cs56, Tetris, Spring 2011
*/

public class Type2 extends Block{

	private int [][] type2= {{0,0,0,0},
				 {0,1,0,0},
				 {1,1,1,0},
				 {0,0,0,0}};
	int rotCounter = 1;

    /**

       Default Constructor 
          

    */

    public Type2() {
    }
    
    /**

       Returns the block
       @return String [2][2] array

    */
    public int[][] getBlock(){
	return type2;
    }
    
    /**

       Return the value 0 or 1 that is located block demension (4x4)

    */

    public int getRowCol(int r, int c){
	return type2[r][c];
    }

    /** 

	Rotates the block

    */
    
    public void rotate(){
	if(rotCounter == 1){
	    int[][] temp = {{0,0,0,0},{0,1,0,0},{0,1,1,0},{0,1,0,0}};
	    type2 = temp;
    		rotCounter++;
    	}
    	else if(rotCounter ==2){
	    int[][] temp = {{0,0,0,0},{0,0,0,0},{1,1,1,0},{0,1,0,0}};
	    type2 = temp;
	    rotCounter++;
    	}
    	else if(rotCounter ==3){
	    
	    int[][] temp = {{0,0,0,0},{0,1,0,0},{1,1,0,0},{0,1,0,0}};
	    type2 = temp;
	    rotCounter++;
    	}
    	else {
	  
	    int[][] temp = {{0,0,0,0},{0,1,0,0},{1,1,1,0},{0,0,0,0}};
	    type2 = temp;
	    rotCounter=1;
    	}
	
    }
    
}