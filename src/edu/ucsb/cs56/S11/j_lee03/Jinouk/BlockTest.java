package edu.ucsb.cs56.S11.j_lee03.Jinouk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



/**
 *  The test class for Blocks of Tetris
 *
 *  @author Jinouk Lee
 *  @version project1 for cs56, Spring 2011
 *
 */
public class BlockTest{

    /**

	Test Rectangle block1 rotation
    */
    @Test public void testType1(){

   	//Test line
	Type1 s = new Type1();
	int [][] expected = {{0,0,0,0},
			  {0,1,1,0},
			  {0,1,1,0},
			  {0,0,0,0}};
	s.rotate();
	assertEquals(s.getBlock(),expected);
    }

    /**

        Test Mountain-Shaped block2 rotation



    */


    @Test public void testType2(){

	Type2 s2 = new Type2();
        int [][] expected = {{0,0,0,0},
				{0,0,0,0},
				{1,1,1,0},
				{0,1,0,0}};


        s2.rotate();
	s2.rotate();
	assertEquals(s2.getBlock(),expected);
    }

    /**

        Test Right-Hooked block3 rotation

    */


    @Test public void testType3(){
	Type3 s3 = new Type3();
	int [][] expected =  {{0,0,0,0},{1,0,0,0},{1,1,1,0},{0,0,0,0}};
        s3.rotate();
        s3.rotate();
        s3.rotate();

	assertEquals(s3.getBlock(),expected);
    }

    /**

        Test Left-Hooked  block4 rotation

    */

    @Test public void testType4(){

	Type4 s4 = new Type4();
	int [][] expected = {{0,1,0,0},{0,1,0,0},{0,1,1,0},{0,0,0,0}};


        s4.rotate();
        s4.rotate();
	assertEquals(s4.getBlock(),expected);
    }

    /**

	Test left zigzag. Type5 rotation


    */

    @Test public void testType5(){


	Type5 s5 = new Type5();
	int [][] expected =  {{0,0,0,0},
				 {0,1,0,0},
				 {0,1,1,0},
				 {0,0,1,0}};


        s5.rotate();
        s5.rotate();
	s5.rotate();
        s5.rotate();
	s5.rotate();
	assertEquals(s5.getBlock(),expected);
    }

    /**

        Test right-zigzag block6 rotation



	*/


    @Test public void testType6(){
	Type6 s6 = new Type6();
	int [][] expected = {{0,0,0,0},{0,1,1,0},{0,0,1,1},{0,0,0,0}};


        s6.rotate();
        s6.rotate();
        s6.rotate();
        s6.rotate();
	assertEquals(s6.getBlock(),expected);
    }

    @Test public void testType7(){
	Type7 s7 = new Type7();
	int [][] expected = {{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}};


        s7.rotate();
        s7.rotate();
        s7.rotate();
        s7.rotate();
	assertEquals(s7.getBlock(),expected);
    }
}
