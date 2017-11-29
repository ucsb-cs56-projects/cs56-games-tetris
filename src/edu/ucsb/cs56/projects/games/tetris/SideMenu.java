package edu.ucsb.cs56.projects.games.tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SideMenu extends JPanel{

    protected JButton mainMenuButton;
    protected JButton restartButton;
    protected JButton pauseButton;
    protected JButton rulesButton;
    protected JButton musicButton;
    protected JPanel spacingPanel;
    protected HoldPanel holdSpace;
    protected JTextField nextBlockText;
    
    public SideMenu(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(7,1,0,0));

        mainMenuButton = new JButton();
	mainMenuButton.setFocusable(false);
        mainMenuButton.setPreferredSize(new Dimension(20,20));
        mainMenuButton.setText("Main Menu");
        add(mainMenuButton);

        restartButton = new JButton();
        restartButton.setFocusable(false);
        restartButton.setPreferredSize(new Dimension(20,20));
        restartButton.setText("Restart");
        add(restartButton);

        pauseButton = new JButton();
	pauseButton.setFocusable(false);
        pauseButton.setPreferredSize(new Dimension(20,20));
        pauseButton.setText("Pause");
        add(pauseButton);

        rulesButton = new JButton();
	rulesButton.setFocusable(false);
        rulesButton.setPreferredSize(new Dimension(20,20));
        rulesButton.setText("Rules");
        add(rulesButton);

        musicButton = new JButton();
	musicButton.setFocusable(false);
        musicButton.setPreferredSize(new Dimension(20,20));
        musicButton.setText("Music on/off");
        add(musicButton);

        spacingPanel = new JPanel(); //For proper spacing of the icon that shows the block
        spacingPanel.setBackground(Color.LIGHT_GRAY);
        spacingPanel.setLayout(new GridBagLayout());
        spacingPanel.setFocusable(false);
        add(spacingPanel);

	holdSpace = new HoldPanel();
        holdSpace.setPreferredSize(new Dimension(80,80));
        holdSpace.setFocusable(false);
        spacingPanel.add(holdSpace);

        nextBlockText = new JTextField();
        nextBlockText.setFocusable(false);
        nextBlockText.setText("Next Block");
        nextBlockText.setEditable(false);
        nextBlockText.setBackground(Color.LIGHT_GRAY);
        nextBlockText.setHorizontalAlignment(JTextField.CENTER);
        add(nextBlockText);
    }
}

