package edu.ucsb.cs56.projects.games.tetris;

/** 

  BLock Type3: generates Left-Hooked shaped block.

  Extends Block abstract class.

  @author Jinouk Lee
  @author Davina Zamanzadeh
  @author Skyler Bistarkey-Rez
  @version cs56, Tetris, Winter 2016
  */



public class Type4 extends Block{

    int rotCounter = 1;

    /**
      Default Constructor
      */

    public Type4() {
        int[][] temp= {{0,0,0,0},
		       {0,1,1,0},
		       {0,0,1,0},
		       {0,0,1,0}};
        block = temp;
        temp = null;
    }
    /** 

      Rotates the block

*/
    public void rotate(){
        if(rotCounter == 1){
            int [][] temp = {{0,0,0,0},
			     {0,2,1,0},
			     {1,1,1,0},
			     {0,0,2,0}};
            block = temp;
            rotCounter++;
        }
        else if(rotCounter ==2){
            int [][] temp = {{0,1,0,0},
			     {0,1,2,0},
			     {2,1,1,0},
			     {0,0,0,0}} ;
            block = temp;
            rotCounter++;
        }
        else if(rotCounter == 3){
            int [][] temp ={{0,2,0,0},
			    {0,1,1,1},
			    {0,1,2,0},
			    {0,0,0,0}};
            block= temp;
            rotCounter++;
        }
        else{
            int [][] temp = {{0,0,0,0},
			     {0,1,1,2},
			     {0,2,1,0},
			     {0,0,1,0}};
            block = temp;
            rotCounter = 1;
        }
    }
}
