package edu.ucsb.cs56.S11.j_lee03.Jinouk;

/** 

    Block Type5: Generates left zig-zag 

    Extends Block abstract class.

    @author Jinouk Lee
    @version cs56, Tetris, Spring 2011
*/
public class Type5 extends Block{

	private int [][] type5= {{0,0,0,0},
				 {0,1,1,0},
				 {1,1,0,0},
				 {0,0,0,0}};
	int rotCounter = 1;

    /**
       Default Constructor
    */

    public Type5() {
    }

    /**

       Returns the block
       @return String [2][2] array

    */
       

    public int[][] getBlock(){
    	return type5;
    }

    /**

       Return the value 0 or 1 that is located block demension (4x4)

    */

    public int getRowCol(int r, int c){
    	return type5[r][c];
    }

       /** 

	Rotates the block

    */
    
    public void rotate(){
	if(rotCounter == 1){
	    int [][] temp = {{0,0,0,0},
			     {0,1,0,0},
			     {0,1,1,0},
			     {0,0,1,0}};
	    type5 = temp;
	    rotCounter++;
    	}
    	else{
	    int [][] temp = {{0,0,0,0},{0,1,1,0},{1,1,0,0},{0,0,0,0}};
	    type5 = temp;
	    rotCounter = 1;
    	}
    }

}