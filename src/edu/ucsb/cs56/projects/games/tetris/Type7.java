
package edu.ucsb.cs56.projects.games.tetris;


/** 

    Block Type 7: Generate line

    Extends Block abstract class.

    @author Jinouk Lee
    @version cs56, Tetris, Spring 2011
*/
public class Type7 extends Block{


	private int [][] type7= {{0,1,0,0},
				 {0,1,0,0},
				 {0,1,0,0},
				 {0,1,0,0}};
	int rotCounter = 1;

    /**
       Default Constructor
    */

    public Type7() {
    }

     /**

       Returns the block
       @return String [2][2] array

    */

    public int[][] getBlock(){
    	return type7;
    }

    /**

       Return the value 0 or 1 that is located block demension (4x4)

    */

    public int getRowCol(int r, int c){
    	return type7[r][c];
    }

    /** 

	Rotates the block

    */

    public void rotate(){
	rotated = true;
    	if(rotCounter == 1){
    		int [][] temp = {{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
    		type7 = temp;
    		rotCounter++;
    	}
    	else if(rotCounter ==2){
    		int [][] temp = {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}};
    		type7 = temp;
    		rotCounter--;
    	}
    }
}
