package gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import player.Player;

@SuppressWarnings("serial")
public class WalkingGui extends JPanel implements ActionListener {
    private JButton west;
    private JButton south;
    private JButton north;
    private JButton east;
    private JLabel label;

    public WalkingGui() {
 
        west = new JButton ("W");
        south = new JButton ("S");
        north = new JButton ("N");
        east = new JButton ("E");
        label = new JLabel("Walking");

        setPreferredSize (new Dimension (170, 170));
        setLayout (null);

        add (west);
        add (south);
        add (north);
        add (east);
        add (label);

        //set component bounds (only needed by Absolute Positioning)
        west.setBounds (0, 60, 60, 60);
        south.setBounds (60, 120, 60, 60);
        north.setBounds (60, 0, 60, 60);
        east.setBounds (120, 60, 60, 60);
        label.setBounds(67, 80, 60, 20);
        
        west.addActionListener(this);
        south.addActionListener(this);
        north.addActionListener(this);
        east.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(north)) {
			//Player.y++;
		}
	}
    

/*
    public static void main (String[] args) {
        JFrame frame = new JFrame ("GuiWalk");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiWalk());
        frame.pack();
        frame.setVisible (true);
    } */
}

