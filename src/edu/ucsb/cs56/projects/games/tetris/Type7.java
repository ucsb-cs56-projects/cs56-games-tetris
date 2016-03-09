
package edu.ucsb.cs56.projects.games.tetris;


/** 

  Block Type 7: Generate line

  Extends Block abstract class.

  @author Jinouk Lee
  @author Davina Zamanzadeh
  @author Skyler Bistarkey-Rez
  @version cs56, Tetris, Winter 2016
  */
public class Type7 extends Block{


    int rotCounter = 1;

    /**
      Default Constructor
      */

    public Type7() {
        int[][] temp= {{0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0}};
        block = temp;
        temp = null;
    }
    /** 

      Rotates the block

    */

    public void rotate(){
        if(rotCounter == 1){
            int [][] temp = {{0,2,0,0},
                {1,1,1,1},
                {0,2,0,0},
                {0,2,0,0}};
            block = temp;
            rotCounter++;
        }
        else if(rotCounter ==2){
            int [][] temp = {{0,1,0,0},
                {2,1,2,2},
                {0,1,0,0},
                {0,1,0,0}};
            block = temp;
            rotCounter--;
        }
    }
}
