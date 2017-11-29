package edu.ucsb.cs56.projects.games.tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel{
    protected JButton startButton;
    protected JTextArea rulesText;
    protected String rules =
	"\tRULES\n\n" +
	"This game is very similar\n" +
	"to the classic game of tetris.\n\n" +
	"The Controls are as Follows:\n\n" +
	"Left Arrow: Move Block Left\n" +
	"Right Arrow: Move Block Right\n" +
	"Up Arrow: Rotate Block\n" +
	"Down Arrow: Soft Drop\n" +
	"Space Bar: Hard Drop\n" +
	"s: Swap with next block\n" +
	"p: Pause Game\n" +
	"\n\nHave Fun !";

    public MainMenu() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(2,1,0,10));
	
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension (80, 20));
        startButton.setText("Play Tetris");

	rulesText = new JTextArea(rules);
	rulesText.setEditable(false);
	
        add(startButton);
        add(rulesText);
    }
}

