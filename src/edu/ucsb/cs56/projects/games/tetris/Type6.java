package edu.ucsb.cs56.projects.games.tetris;

/** 

  Block Type 6: Generates Right zigzag

  Extends Block abstract class.

  @author Jinouk Lee
  @version cs56, Tetris, Spring 2011
  */
public class Type6 extends Block{

    private int [][] type6= {{0,0,0,0},
        {0,1,1,0},
        {0,0,1,1},
        {0,0,0,0}};
    int rotCounter = 1;


    /**

      Default Constructor 


*/
    public Type6() {
    }

    /**

      Returns the block
      @return String [2][2] array

*/

    public int[][] getBlock(){
        return type6;
    }

    /**

      Return the value 0 or 1 that is located block demension (4x4)

*/



    public int getRowCol(int r, int c){
        return type6[r][c];
    }

    /** 

      Rotates the block

*/

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
        type6[r][c] = i;
    }

    public void rotate(){
        rotated = true;
        if(rotCounter == 1){
            int [][] temp = {{0,0,0,0},
                {0,2,1,0},
                {0,1,1,2},
                {0,1,0,0}};
            type6 = temp;
            rotCounter++;
        }
        else if(rotCounter ==2){
            int [][] temp = {{0,0,0,0},
                {0,1,1,0},
                {0,2,1,1},
                {0,2,0,0}};
            type6 = temp;
            rotCounter--;
        }
    }
}
