package edu.ucsb.cs56.projects.games.tetris;

/** 

  Block Type 6: Generates Right zigzag

  Extends Block abstract class.

  @author Jinouk Lee
  @author Davina Zamanzadeh
  @author Skyler Bistarkey-Rez
  @version cs56, Tetris, Winter 2016
  */
public class Type6 extends Block{

    int rotCounter = 1;


    /**
      Default Constructor 
      */
    public Type6() {
        int[][] temp= {{0,0,0,0},
                {0,1,1,0},
                {0,0,1,1},
                {0,0,0,0}};
        block = temp;
        temp = null;
    }

    public void rotate(){
        if(rotCounter == 1){
            int [][] temp = {{0,0,0,0},
                {0,2,1,0},
                {0,1,1,2},
                {0,1,0,0}};
            block = temp;
            rotCounter++;
        }
        else if(rotCounter ==2){
            int [][] temp = {{0,0,0,0},
                {0,1,1,0},
                {0,2,1,1},
                {0,2,0,0}};
            block = temp;
            rotCounter--;
        }
    }
}
