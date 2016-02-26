package edu.ucsb.cs56.projects.games.tetris;

/**
 * @(#)Block.java
 *
 *
 * @author Jinouk Lee
 * @version  2011/5/5
 */

abstract class Block {

    protected int[][] block;

    abstract void rotate();

    public int[][] getBlock() { return this.block; }

    public int getRowCol(int r,int c) {
        if(r>=10 || r<0 || c<0 || c>=24) //prevents index out of bounds
            return 0;
        return block[r][c];
    }

    public void display(Block type){

        int [][] shape = new int [4][4];
        shape = type.getBlock();

        for(int row = 0; row<4;row++){
            for(int col = 0; col<4;col++){
                if(shape[row][col] == 0)
                    System.out.print(" ");
                else if(shape[row][col] == 1)
                    System.out.print("*");
            }
            System.out.println();
        }
    }


    void setRowCol(int r, int c, int i) {
        if(i!=0 && i!=1 && i!=2)
            return;
        block[r][c] = i;
    }
}
