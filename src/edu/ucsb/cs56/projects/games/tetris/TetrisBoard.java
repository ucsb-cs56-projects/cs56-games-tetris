package edu.ucsb.cs56.projects.games.tetris;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import sun.audio.*;
import java.io.*;
import java.net.URL;
//import java.applet;

import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Point;

/**
 * @(#)TetrisBoard.java
 *
 *
 * @author
 * @version 1.00 2011/5/8
 */


public class TetrisBoard extends JPanel implements ActionListener {
    
    private JButton RestartButton;
    private JButton EasyButton;
    private JButton MediumButton;
    private JButton HardButton;
    
    private JButton RulesButton;
    private JButton PauseButton;
    private JButton MusicButton;
    private JButton StartButton;
    private HoldPanel HoldSpace;
    private JPanel SpacingPanel;
    private JTextField NextBlockText;
    private int TIMER_DELAY = 400;
    private JTextArea rulesText;
    private boolean rulesOn = false;
    
    static JFrame window;
    static JPanel RulePanel;
    static JPanel startPanel;
    static JPanel tetrisPanel;
    
    Block BlockInControl;
    Color BlockColor;
    int whichColor;
    static JLabel statusBar;
    int score = 0;
    
    //music stuff
    private boolean musicPlaying = false;
    private InputStream is;
    private AudioStream as;
    private InputStream s;
    private AudioStream se;
    
    private final int MAX_COL = 10;
    private final int MAX_ROW = 24;
    private int[][] board = new int[MAX_ROW][MAX_COL];
    private int[][] color = new int[MAX_ROW][MAX_COL];
    
    Timer timer;
    int timerdelay;
    boolean isFallingFinished = false;
    boolean isStarted = false;
    boolean isPaused = false;
    
    int BlockPosX,BlockPosY;
    
    private static int WINDOW_X = 320;
    private static int WINDOW_Y = 585;
    
    public TetrisBoard() {
        for(int row = 0; row < MAX_ROW; row++){
            for(int col = 0; col<MAX_COL; col++){
                board[row][col] = 0;
                color[row][col] = 0;
            }
        }
        this.setFocusable(true);
	
        String text;
        text = "	RULES\n\n\nThis game is very similar\nto the classic game of tetris.\n\n" +
            "The Controls are as Follows:\n\n" +
            "Left Arrow: Move Block Left\n" +
            "Right Arrow: Move Block Right\n" +
            "Up Arrow: Rotate Block\n" + 
            "Down Arrow: Soft Drop\n" +
            "Space Bar: Hard Drop\n" + 
            "s: Swap with next block\n" +
            "p: Pause Game\n" + 
            "\n\nHave Fun !";
	
        rulesText = new JTextArea(text);
        rulesText.setEditable(false);
	
        MainMenu();
	
        InGameButtons();
    }
    
    public void restartGame() {
	if(isPaused) pause();
	timer.stop();
        statusBar.setText(" Restarting Game ...     ");
	score = 0;
	RestartButton.setText("Restarting...");
	for(int row = 0; row < MAX_ROW; row++){
	    for(int col = 0; col<MAX_COL; col++){
		board[row][col] = 0;
		color[row][col] = 0;
	    }
	}
	timerdelay = TIMER_DELAY;
	timer = new Timer(timerdelay,this);
	timer.start();	    
    }

    public void MainMenu() {
        startPanel = new JPanel();
	
        startPanel.setBackground(Color.LIGHT_GRAY);
        startPanel.setLayout(new GridLayout(2,1,0,10));
	
        //declare start button
        StartButton = new JButton();
        StartButton.setPreferredSize(new Dimension (80, 20));
        StartButton.setText("Play Tetris");
        StartButton.addActionListener(new MainMenuButtons());
        startPanel.add(StartButton);
        
        rulesText.setVisible(true);
        startPanel.add(rulesText);
	
        EasyButton = new JButton();
        EasyButton.setPreferredSize(new Dimension(80,20));
        EasyButton.setText("Easy");
        EasyButton.addActionListener(new MainMenuButtons());
	
        MediumButton = new JButton();
        MediumButton.setPreferredSize(new Dimension(80,20));
        MediumButton.setText("Medium");
        MediumButton.addActionListener(new MainMenuButtons());
	
        HardButton = new JButton();
        HardButton.setPreferredSize(new Dimension(80,20));
        HardButton.setText("Hard");
        HardButton.addActionListener(new MainMenuButtons()); 
    }
    
    private class MainMenuButtons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == StartButton) {
                startPanel.setLayout(new GridLayout(4,1,0,10));
                StartButton.setVisible(false);
                rulesText.setVisible(false);
                startPanel.remove(rulesText);
                startPanel.add(EasyButton);
                startPanel.add(MediumButton);
                startPanel.add(HardButton);
            }
            else if(e.getSource() == EasyButton){
                TIMER_DELAY = 1000;

                startPanel.setVisible(false);
                window.setVisible(true);
                window.setSize(WINDOW_X, WINDOW_Y);
                beginGame();
            } 
            else if(e.getSource() == MediumButton){
                TIMER_DELAY = 400;
                startPanel.setVisible(false);
                window.setVisible(true);
                window.setSize(WINDOW_X, WINDOW_Y);
                beginGame();
            }
            else if(e.getSource() == HardButton){
                TIMER_DELAY = 80;
                startPanel.setVisible(false);
                window.setVisible(true);
                window.setSize(WINDOW_X, WINDOW_Y);
                beginGame();
            }  
        }
    }

    public void InGameButtons() {

        RulePanel =  new JPanel();

        RulePanel.setBackground(Color.LIGHT_GRAY);
        RulePanel.setLayout(new GridLayout(6,1,0,10));

        RestartButton = new JButton();
        RestartButton.setFocusable(false);
        //RestartButton.setSize(1,1);
        RestartButton.setPreferredSize(new Dimension(20,20));
        RestartButton.setText("Restart");
        RestartButton.addActionListener(new SideButtons());
        RulePanel.add(RestartButton);

        PauseButton = new JButton();
        PauseButton.setFocusable(false);
        PauseButton.setPreferredSize(new Dimension(20,20));
        PauseButton.setText("Pause");
        PauseButton.addActionListener(new SideButtons());
        RulePanel.add(PauseButton);

        RulesButton = new JButton();
        RulesButton.setFocusable(false);
        RulesButton.setPreferredSize(new Dimension(20,20));
        RulesButton.setText("Rules");
        RulesButton.addActionListener(new SideButtons());
        RulePanel.add(RulesButton);

        MusicButton = new JButton();
        MusicButton.setFocusable(false);
        RulesButton.setPreferredSize(new Dimension(20,20));
        MusicButton.setText("Music on/off");
        MusicButton.addActionListener(new SideButtons());
        RulePanel.add(MusicButton);

        SpacingPanel = new JPanel(); //This is for creating proper spacing for the icon that shows the block
        SpacingPanel.setBackground(Color.LIGHT_GRAY);
        SpacingPanel.setLayout(new GridBagLayout());
        SpacingPanel.setFocusable(false);
        RulePanel.add(SpacingPanel);

        HoldSpace = new HoldPanel();
        HoldSpace.setPreferredSize(new Dimension(80,80));
        HoldSpace.setFocusable(false);
        SpacingPanel.add(HoldSpace);
        HoldSpace.setVisible(false); //set this to true at the appropriate time (along with other buttons)
        //watch out for overlapping with resume game button when you click on rules

        NextBlockText = new JTextField();
        NextBlockText.setFocusable(false);
        NextBlockText.setText("Next Block");
        NextBlockText.setEditable(false);
        NextBlockText.setBackground(Color.LIGHT_GRAY);
        NextBlockText.setHorizontalAlignment(JTextField.CENTER);
        RulePanel.add(NextBlockText);
    }

    private class SideButtons implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == RulesButton){
                rulesOn = true;

                if(!isPaused) pause();
                window.add(rulesText);
                window.revalidate();
                tetrisPanel.setVisible(false);
                rulesText.setVisible(true);
                //rulesText.toFront();

                RestartButton.setVisible(false);
                PauseButton.setVisible(true);
                HoldSpace.setVisible(false);
                RulesButton.setVisible(false);
            }
            else if(e.getSource() == PauseButton && rulesOn){
                pause();
                rulesOn = false;
                RestartButton.setVisible(true);
                PauseButton.setVisible(true);
                RulesButton.setVisible(true);
                HoldSpace.setVisible(true);
                window.remove(rulesText);
                tetrisPanel.setVisible(true);
                tetrisPanel.requestFocus();
            } 
            else if(e.getSource() == PauseButton){
                pause();
	    }
            else if (e.getSource() == MusicButton){
                playMusic();
            }
            else if (e.getSource() == RestartButton) {
                restartGame();
	    }
        }
    }

    /* Function to play the tetris theme
     * NOTE: Must download and run the repo locally for this to work
     * Because X11 doesn't forward audio
     */

    public void playMusic() {

	if (!musicPlaying) {
	    try{
		File currentDir = new File(System.getProperty("user.dir"));
		//Note this is the relative path of the wav file to whever the repo is located
		//So if you move the wav file you need to change this
		File songFile = new File(currentDir, "src/edu/ucsb/cs56/projects/games/tetris/tetrisSong.wav");
		is = new FileInputStream(songFile);
		as = new AudioStream(is);
		AudioPlayer.player.start(as);
		musicPlaying = true;
	    } catch (Exception ex) {
		System.out.println("sorry couldn't open audio");
	    }
	}
	else {
	    AudioPlayer.player.stop(as);
	    musicPlaying = false;
	}
    }

    public void playSoundEffect(String event) {
	try{
	    String sound = null;
	    File currentDir = new File(System.getProperty("user.dir"));
	    if (event == "go"){
		sound = "src/edu/ucsb/cs56/projects/games/tetris/gameover.wav";
	    }
	    else if (event == "bd"){
	       sound = "src/edu/ucsb/cs56/projects/games/tetris/block_drop.wav";
	    }
	    else if(event == "dl"){
	       sound = "src/edu/ucsb/cs56/projects/games/tetris/clear_line.wav";
	    }
	    File soundFile = new File(currentDir, sound);
	    s = new FileInputStream(soundFile);
	    se = new AudioStream(s);
	    AudioPlayer.player.start(se);
	} catch (Exception ex) {
	    System.out.println("sorry couldn't open audio");
	}
    }


    public void beginGame() {
	for(int row = 0; row < MAX_ROW; row++){
	    for(int col = 0; col<MAX_COL; col++){
		board[row][col] = 0;
		color[row][col] = 0;
	    }
	}
	this.setFocusable(true);
	RulePanel.setVisible(true);
	HoldSpace.setVisible(true);
	window.add(this);
	window.revalidate();
	window.repaint();
	
	BlockColor = Color.BLACK;
	Type1 y = new Type1();
	whichColor = 1;
	this.putBlock(y);
	timerdelay = TIMER_DELAY;
	timer = new Timer(timerdelay,this);
	timer.start();
	
	//this.setPreferredSize(new Dimension(205,460));
	this.setBackground(Color.WHITE);
	this.playMusic();
	
	//if(this.canMoveDown() == true) 
	addKeyListener(new TAdapter());
    }
    
    public void actionPerformed(ActionEvent e) {	
	if (isFallingFinished) {
	    isFallingFinished = false;
	    int randomNumber = (int)(Math.random() * 7) + 1;
	    switch(randomNumber){
	    case 1: Type1 a = new Type1();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(a);
		HoldSpace.setColor(1);
		break;
	    case 2: Type2 b = new Type2();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(b);
		HoldSpace.setColor(2);
		break;
	    case 3: Type3 c = new Type3();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(c);
		HoldSpace.setColor(3);
		break;
	    case 4: Type4 d = new Type4();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(d);
		HoldSpace.setColor(4);
		break;
	    case 5: Type5 h = new Type5();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(h);
		HoldSpace.setColor(5);
		break;
	    case 6: Type6 f = new Type6();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(f);
		HoldSpace.setColor(6);
		break;
	    case 7: Type7 g = new Type7();
		whichColor = HoldSpace.getColor();
		this.putBlock(HoldSpace.getHeldBlock());
		HoldSpace.setBlock(g);
		HoldSpace.setColor(7);
		break;
	    }
	    if(timerdelay > 200){
		double x = .1*timerdelay;
		timerdelay = timerdelay - (int)x;
	    }
	    timer.setDelay(timerdelay);
	}
	else {
                this.moveDown();
		if(isFallingFinished){
		    this.deleteRows();
		    this.deleteRows();
		    this.deleteRows();
		    this.deleteRows();
		}
            }
	this.repaint();
	HoldSpace.repaint();
    }
    
    public int getBlockPosX(){
	return this.BlockPosX;
    }
    
    public int getBlockPosY(){
	return this.BlockPosY;
    }
    
    public int getRowCol(int r, int c){
	return board[r][c];
    }
    
    public void gameOver(){
	timer.stop();	
	statusBar.setText("GAME OVER");
	RestartButton.setText("Play Again");     
	playSoundEffect("go");	
    }
    
    public void putBlock(Block block){
	score++;
	statusBar.setText("SCORE = " + String.valueOf(score));
	RestartButton.setText("Restart");
	//int [][] theBlock = block.getBlock();
	//int k = (int)(Math.random() * MAX_COL);
	BlockPosX = 5;
	BlockPosY = 0;
	int posX = 5;
	int posY = 0;
	BlockInControl = block;
	
	int x = 0;
	for(int i=0;i<MAX_COL;i++){
	    if(board[posY+1][i] == 1) {
		this.gameOver();
		score = 0;
		break;
	    }
	}
	
	for(int r=0;r<4;r++){
	    for(int c=0;c<4;c++){
		if(block.getRowCol(r,c) == 1) {
		    board[posY][posX]=1;		    
		    color[posY][posX] = whichColor;
		}
		posX++;
	    }
	    posY++;
	    posX-=4;
	}
    }    
    
    public boolean canMoveRight(){	
	int [][] temp = BlockInControl.getBlock();
	int tempPosX = BlockPosX;
	int tempPosY = BlockPosY;
	
	for(int r = 0; r <4; r++){
	    for(int c = 0; c < 4;c++){
		if(temp[r][c] == 1){
		    if(c ==3){
			if(tempPosX+1 > MAX_COL-1)
			    return false;
			if(board[tempPosY][tempPosX+1]==1)
			    return false;
		    }
		    else{
			if(tempPosX+1 > MAX_COL-1)
			    return false;
			if(temp[r][c+1] == 0){
			    if(board[tempPosY][tempPosX+1]==1)
				return false;
			}
		    }
		}
		tempPosX++;
	    }
	    tempPosX = BlockPosX;
	    tempPosY++;
	}
	return true;
    }
    
    public boolean canMoveLeft(){	
	int [][] temp = BlockInControl.getBlock();
	int tempPosX = BlockPosX;
	int tempPosY = BlockPosY;
	
	for(int r = 0; r <4; r++){
	    for(int c = 0; c < 4;c++){
		if(temp[r][c] == 1){
		    if(c ==0){
			if(tempPosX-1 < 0)
			    return false;
			if(board[tempPosY][tempPosX-1]==1)
			    return false;
		    }
		    else{
			if(tempPosX-1 < 0)
			    return false;
			if(temp[r][c-1] == 0){
			    if(board[tempPosY][tempPosX-1]==1)
				return false;
			}
		    }
		}
		tempPosX++;
	    }
	    tempPosX = BlockPosX;
	    tempPosY++;
	}
	return true;
    }
    public boolean canMoveDown(){
	int [][] temp = BlockInControl.getBlock();
	int tempPosX = BlockPosX;
	int	tempPosY = BlockPosY;	
	for(int r = 0; r <4; r++){
	    for(int c = 0; c < 4;c++){
		if(temp[r][c] == 1){
		    if(r ==3){
			if(tempPosY+1 > MAX_ROW-1)
			    return false;
			if(board[tempPosY+1][tempPosX]==1)
			    return false;
		    }
		    else{
			if(tempPosY+1 > MAX_ROW-1)
			    return false;
			try {
			    if(temp[r+1][c] == 0){
				if(board[tempPosY+1][tempPosX]==1)
				    return false;
			    }
			} catch (RuntimeException rex) {
			    System.err.println("Out of bounds: " + String.valueOf(tempPosY + 1) + " vs the max " + MAX_COL + " and " + tempPosX + "vs max " + MAX_ROW);
			}
		    }
		}
		tempPosX++;
	    }
	    tempPosX = BlockPosX;
	    tempPosY++;
	}	
	return true;
    }
    
    public void moveRight(){
	if(canMoveRight()){
	    int[][] temp = BlockInControl.getBlock();
	    int tempPosX = BlockPosX;
	    int tempPosY = BlockPosY;
	    ArrayList <Point> CoordinatesToRight = new ArrayList <Point>();	    
	    for(int r=0; r<4; r++){
		for(int c=0;c<4;c++){
		    if(temp[r][c] == 1 && getRowCol(tempPosY,tempPosX)==1){
			CoordinatesToRight.add(new Point(tempPosX,tempPosY));
			board[tempPosY][tempPosX]=0;
			color[tempPosY][tempPosX]=0;
		    }
		    tempPosX++;
		}
		tempPosY++;
		tempPosX-=4;
	    }	    
	    for(Point p : CoordinatesToRight){
		board[(int)p.getY()][(int)p.getX()+1]=1;
		color[(int)p.getY()][(int)p.getX()+1]= whichColor;
	    }	    
	    CoordinatesToRight.clear();
	    CoordinatesToRight = null;
	    BlockPosX++;
	}
    }
    
    public void moveLeft(){
	if(canMoveLeft()){
	    int[][] temp = BlockInControl.getBlock();
	    int tempPosX = BlockPosX;
	    int tempPosY = BlockPosY;
	    ArrayList <Point> CoordinatesToLeft = new ArrayList <Point>();	    
	    for(int r=0; r<4; r++){
		for(int c=0;c<4;c++){
		    if(temp[r][c] == 1 && getRowCol(tempPosY,tempPosX)==1){
			CoordinatesToLeft.add(new Point(tempPosX,tempPosY));
			board[tempPosY][tempPosX]=0;
			color[tempPosY][tempPosX]=0;
		    }
		    tempPosX++;
		}
		tempPosY++;
		tempPosX-=4;
	    }	    
	    for(Point p : CoordinatesToLeft){
		board[(int)p.getY()][(int)p.getX()-1]=1;
		color[(int)p.getY()][(int)p.getX()-1]=whichColor;
	    }	    
	    CoordinatesToLeft.clear();
	    CoordinatesToLeft = null;
	    BlockPosX--;
	}
	
    }
    
    public void moveDown(){
	if(canMoveDown()){
	    int[][] temp = BlockInControl.getBlock();
	    int tempPosX = BlockPosX;
	    int tempPosY = BlockPosY;
	    ArrayList <Point> CoordinatesToDown = new ArrayList <Point>();	    
	    for(int r=0; r<4; r++){
		for(int c=0;c<4;c++){
		    if(temp[r][c] == 1 && tempPosX >= 0 && tempPosX < MAX_COL) { // && getRowCol(tempPosY,tempPosX)==1){  <-- doesn't add any fucntionality and breaks the rotate
			CoordinatesToDown.add(new Point(tempPosX,tempPosY));
			board[tempPosY][tempPosX]=0;	
			color[tempPosY][tempPosX]=0;
		    }
		    else if(temp[r][c] == 2 && board[tempPosY][tempPosX] == 1 && tempPosX >= 0 && tempPosX < MAX_COL) {
			board[tempPosY][tempPosX] = color[tempPosY][tempPosX] = 0;
			BlockInControl.setRowCol(r,c,0);
		    }
		    tempPosX++;
		}   
		//Moves to next row, and first column (which is why there's a -4 for posX)
		tempPosY++;
		tempPosX-=4;
	    }
	    for(Point p : CoordinatesToDown){
		board[(int)p.getY()+1][(int)p.getX()]=1;
		color[(int)p.getY()+1][(int)p.getX()]=whichColor;
	    }	    
	    CoordinatesToDown.clear();
	    CoordinatesToDown = null;
	    BlockPosY++;
	}
	else {
	    isFallingFinished=true;
	    playSoundEffect("bd");
	}
    }
    
    public void drop(){
	while(canMoveDown())
	    moveDown();
    }
    
    public void deleteRows(){
	int nodelete;
	int rowtobedeleted = 0;	
	for(int row = 0; row<MAX_ROW; row++){
	    nodelete = 0;
	    for(int col = 0; col <MAX_COL; col++){
		if(board[row][col] == 0)
		    nodelete = 1;
	    }
	    if(nodelete == 0){
		rowtobedeleted = row;
	    }
	}
	if(rowtobedeleted != 0){
	    for(int row = rowtobedeleted; row > 1; row--)
		for (int col = 0; col < MAX_COL; col++){
		    board[row][col] = board[row-1][col];
		}
	}
	for (int col = 0; col < MAX_COL; col++)
	    board[0][col] = 0;
	if(rowtobedeleted != 0){
	    score = score + 10;
	    statusBar.setText("SCORE = " + String.valueOf(score));
	    playSoundEffect("dl");
	}
    }
    
    public Color getColor(int x){
	switch(x){
	case 1: BlockColor = Color.BLACK;
	    break;
	case 2: BlockColor = Color.GREEN;
	    break;
	case 3: BlockColor =  Color.BLUE;
	    break;
	case 4: BlockColor =  Color.ORANGE;
	    break;
	case 5: BlockColor =  Color.MAGENTA;
	    break;
	case 6: BlockColor =  Color.BLUE;
	    break;
	case 7: BlockColor =  Color.RED;
	    break;
	    
	}
	return BlockColor;
    }    
    
    public void paint(Graphics gr){
	super.paint(gr);
	for(int row = 0; row<MAX_ROW; row++){
	    for(int col = 0; col <MAX_COL; col++){
		if(board[row][col] == 1){
		    gr.setColor(getColor(color[row][col]));
		    gr.fillRect(20*col,20*row,20,20);
		}
		else{ // Add hollow square
		    gr.setColor(Color.WHITE);
		    gr.fillRect(20*col,20*row,20,20);
		    gr.setColor(Color.BLACK);
		    gr.drawRect(20*col,20*row,20,20);
 		    gr.drawRect(20*col,20*row,20,20);
		}		
	    }
	}
    }
    
    private void pause(){	
	isPaused = !isPaused;
	if (isPaused) {
	    timer.stop();
	    PauseButton.setText("Resume");
	    statusBar.setText("GAME PAUSED");
	} else {
	    timer.start();
	    PauseButton.setText("Pause");
	    statusBar.setText("SCORE = " + String.valueOf(score));
	}
	repaint();
    }    
    
    class TAdapter extends KeyAdapter {
	public void keyPressed(KeyEvent e) {	    
	    int keycode = e.getKeyCode();	    
	    if (keycode == 'p' || keycode == 'P') {
		pause();
		return;
	    }	    
	    if (isPaused)
		return;	    
	    switch (keycode) {
	    case KeyEvent.VK_UP:
		{ 
		    //Check if block will still be in bounds
		    if(BlockPosX >= 0 && BlockPosX < MAX_COL - 3) {
			BlockInControl.rotate();
		    }
		    break;
		}
	    case KeyEvent.VK_DOWN:
		{
		    timer.setDelay(TIMER_DELAY/6); break;
		}
	    case KeyEvent.VK_LEFT:
		{
		    moveLeft();
		    break;
		}
	    case KeyEvent.VK_RIGHT:
		{
		    moveRight();
		    break;
		}
	    case KeyEvent.VK_SPACE:
		{ 
		    drop();
		    break;
		}
	    case KeyEvent.VK_S:
		{
		    if(BlockPosX >= 0 && BlockPosX < MAX_COL - 3) 
			swap();
		    break;
		}
	    }	    
	}
    }
    
    private void swap() {
	int tempColor = whichColor;
	whichColor = HoldSpace.getColor();
	HoldSpace.setColor(tempColor);
	Block temp = BlockInControl;
	BlockInControl = HoldSpace.getHeldBlock();
	HoldSpace.setBlock(temp);
	
	//this double for loop checks to see which blocks are no longer present
	//after the swap, then sets those to 2 so they can be deleted on the board.
	for (int r=0; r<4; r++) {
	    for (int c=0; c<4; c++) {
		if(HoldSpace.getHeldBlock().getRowCol(r,c) == 1 && BlockInControl.getRowCol(r,c) == 0)
		    BlockInControl.setRowCol(r,c,2);
	    }
	}
    }
    
    
    public static void main(String [] args){	
       	window = new JFrame("TETRIS");
	
	window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	statusBar = new JLabel("A Fun Game of Classic Tetris");
	window.add(BorderLayout.SOUTH, statusBar);
	TetrisBoard b = new TetrisBoard();
	tetrisPanel = b;
	window.add(tetrisPanel);
	window.add(BorderLayout.EAST, RulePanel);
	RulePanel.setVisible(false);
	
	window.add(startPanel);
	
	window.setSize(WINDOW_X, WINDOW_Y);
	window.setVisible(true);	
    }    
}
