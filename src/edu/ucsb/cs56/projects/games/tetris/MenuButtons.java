package edu.ucsb.cs56.projects.games.tetris;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.GridLayout;


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
public class MenuButtons extends JPanel{

    JFrame frame;
    TetrisBoard b;

    public MenuButtons() {
	this.setBackground(Color.BLUE);
	this.setPreferredSize(new Dimension(150,440));
	
	JButton Start = new JButton();
	Start.setText("START GAME");
	//Start.addActionListener(new StartGame());
	this.add(Start);
    }

}

/*

 public class MainMenu extends JPanel  implements ActionListener{
	MainMenu(){

	    JButton Start = new JButton();
	    Start.setText("START GAME");
	    Start.addActionListener(this);
	    this.add(Start);

	}

	public void actionPerformed(ActionEvent e) {
	    
		
	}




    }*/
