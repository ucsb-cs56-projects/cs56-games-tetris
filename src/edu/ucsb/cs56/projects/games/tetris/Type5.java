package edu.ucsb.cs56.projects.games.tetris;

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
     * set the current row and column to the value i
     *
     * @param r the row to be replaced
     * @param c the col to be replaced
     * @param i the value to replace r,c with
     */

    public void setRowCol(int r, int c, int i) {
        if (i != 0 && i!=1 && i!=2)
            return;
        type5[r][c] = i;
    }

    /** 

      Rotates the block

*/

    public void rotate(){
        rotated = true;
        if(rotCounter == 1){
            int [][] temp = {{0,0,0,0},
                {0,1,2,0},
                {2,1,1,0},
                {0,0,1,0}};
            type5 = temp;
            rotCounter++;
        }
        else{
            int [][] temp = {{0,0,0,0},
                {0,1,1,0},
                {1,1,2,0},
                {0,0,2,0}};
            type5 = temp;
            rotCounter = 1;
        }
    }
}
