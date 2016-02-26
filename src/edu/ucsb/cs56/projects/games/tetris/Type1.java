package edu.ucsb.cs56.projects.games.tetris;

/** 

  BLock Type1: generates Rectangular Shape

  Extends Block abstract class.

  @author Jinouk Lee
  @version cs56, Tetris, Spring 2011
  */

public class Type1 extends Block {


    /** 

      Default Constructor


*/
    public Type1() {
        int[][] temp = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        block = temp;
        temp = null;
   }

    /**
      Rotate Function: does not do anything since rotated shape is identical every time
      */
    public void rotate(){}
}
