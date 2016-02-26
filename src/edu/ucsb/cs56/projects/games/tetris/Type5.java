package edu.ucsb.cs56.projects.games.tetris;

/** 

  Block Type5: Generates left zig-zag 

  Extends Block abstract class.

  @author Jinouk Lee
  @version cs56, Tetris, Spring 2011
  */
public class Type5 extends Block{

    int rotCounter = 1;

    /**
      Default Constructor
      */

    public Type5() {
        int[][] temp= {{0,0,0,0},
                {0,1,1,0},
                {1,1,0,0},
                {0,0,0,0}};
        block = temp;
        temp = null;
    }

    /** 

      Rotates the block

*/

    public void rotate(){
        if(rotCounter == 1){
            int [][] temp = {{0,0,0,0},
                {0,1,2,0},
                {2,1,1,0},
                {0,0,1,0}};
            block = temp;
            rotCounter++;
        }
        else{
            int [][] temp = {{0,0,0,0},
                {0,1,1,0},
                {1,1,2,0},
                {0,0,2,0}};
            block = temp;
            rotCounter = 1;
        }
    }
}
