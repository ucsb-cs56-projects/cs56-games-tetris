package edu.ucsb.cs56.projects.games.tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiffMenu extends JPanel{
    
    protected JButton EasyButton;
    protected JButton MediumButton;
    protected JButton HardButton;
    
    public DiffMenu() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(3,1,0,10));

        EasyButton = new JButton();
        EasyButton.setPreferredSize(new Dimension(80,20));
        EasyButton.setText("Easy");
	
        MediumButton = new JButton();
        MediumButton.setPreferredSize(new Dimension(80,20));
        MediumButton.setText("Medium");
	
        HardButton = new JButton();
        HardButton.setPreferredSize(new Dimension(80,20));
        HardButton.setText("Hard");

        add(EasyButton);
        add(MediumButton);
        add(HardButton);
    }
}

