package edu.ucsb.cs56.projects.games.tetris;

import java.awt.Color;

/**
 * @(#)BlockCreator.java
 *
 * Creates a tetris block given the type and color.
 *
 * @Author Matthew Mitchell
 *
 * @version cs56, Tetris, Fall 2017
 */

public class BlockCreator{

	public Block createBlock(int type)
    {
        Block block;
        switch(type){
            case 1: block = new Type1();
                break;
            case 2: block = new Type2();
                break;
            case 3: block = new Type3();
                break;
            case 4: block = new Type4();
                break;
            case 5: block = new Type5();
                break;
            case 6: block = new Type6();
                break;
            case 7: block = new Type7();
                break;
        }
        return block;
    }
}
c
