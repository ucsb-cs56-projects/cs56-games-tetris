package edu.ucsb.cs56.S11.j_lee03.Jinouk;

/** 

    BLock Type1: generates Rectangular Shape

    Extends Block abstract class.

    @author Jinouk Lee
    @version cs56, Tetris, Spring 2011
*/

public class Type1 extends Block {

	private int [][] type1 = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};

    /** 

	Default Constructor
	   

    */
    public Type1() {
    }

    /**

       Return the block
       @return String[2][2] array
    */

   

    public int [][] getBlock(){
    	return type1;
    }

    /**
       Rotate Function: does not do anything since rotated shape is identical every time
    */
    public void rotate(){
    }
    /**

       Return the value 0 or 1 that is located block demension (4x4)

    */
    public int getRowCol(int r,int c){
    	return type1[r][c];
    }


}