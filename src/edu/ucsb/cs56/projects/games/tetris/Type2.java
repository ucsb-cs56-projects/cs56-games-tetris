package edu.ucsb.cs56.projects.games.tetris;

/**
 * Block Type2: T Shaped Block
 * Extends Block abstract class.
 * @author Jinouk Lee
 * @author Davina Zamanzadeh
 * @author Skyler Bistarkey-Rez
 * @version cs56, Tetris, Winter 2016
 */

public class Type2 extends Block {
    //0 = empty space
    //1 = block is there
    //2 = block used to be there before rotation
    //This is so we can check for blocks that used to be present but no longer are
    //so we can remove them!

    int rotCounter = 1;

    /**
     * Default Constructor 
     */

    public Type2() {
        int[][] temp = {{0,0,0,0},
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,0,0,0}};
        block = temp;
        temp = null;
    }

    /** 
     * Rotates the block
     */

    public void rotate() {
        if(rotCounter == 1){
            int[][] temp = {{0,0,0,0},
			    {0,1,0,0},
			    {2,1,1,0},
			    {0,1,0,0}};
            block = temp;
            rotCounter++;
        }
        else if(rotCounter == 2){
            int[][] temp = {{0,0,0,0},
			    {0,2,0,0},
			    {1,1,1,0},
			    {0,1,0,0}};
            block = temp;
            rotCounter++;
        }
        else if(rotCounter == 3){
            int[][] temp = {{0,0,0,0},
			    {0,1,0,0},
			    {1,1,2,0},
			    {0,1,0,0}};
            block = temp;
            rotCounter++;
        }
        else {
            int[][] temp = {{0,0,0,0},
			    {0,1,0,0},
			    {1,1,1,0},
			    {0,2,0,0}};
            block = temp;
            rotCounter = 1;
        }
    }
}
