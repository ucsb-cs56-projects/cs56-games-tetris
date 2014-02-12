package edu.ucsb.cs56.S11.j_lee03.Jinouk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



/**
 *  Board Test Class
 *
 *  @author Jinouk Lee
 *  @version project1 for cs56, Spring 2011
 *
 */
public class BoardTest{

    /**

       Test if boolean functions that checks if block can move

    */

    @Test public void testBoolFunc(){

	TetrisBoard tb = new TetrisBoard();
	
	Type2 t2 = new Type2();
	
	tb.putBlock(t2, 4, 4);
	assertEquals(true,tb.canMoveDown());
	tb.moveRight();
	tb.moveRight();
	tb.moveRight();
	tb.moveRight();
	tb.moveRight();
	tb.moveRight();
	tb.moveRight();

	assertEquals(false, tb.canMoveRight());
	
	tb.drop();
	assertEquals(false,tb.canMoveDown());


	for(int i = 0; i<10; i++)
	    tb.moveLeft();

	assertEquals(false,tb.canMoveLeft());
    }

    /**

       Test if block moves properly
       
       Test with their position
    */

    @Test public void testBlockMove(){

	TetrisBoard tb = new TetrisBoard();
	Type3 t3 =  new Type3();

	tb.putBlock(t3,4,9);
	assertEquals(4,tb.getBlockPosX());
	assertEquals(9,tb.getBlockPosY());

	tb.moveRight();
	assertEquals(5,tb.getBlockPosX());

	tb.moveLeft();
	tb.moveLeft();
	assertEquals(3,tb.getBlockPosX());

	tb.moveDown();
	tb.moveDown();
	assertEquals(11,tb.getBlockPosY());

	tb.drop();
	assertEquals(26,tb.getBlockPosY());

    }

}




