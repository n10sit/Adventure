package gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class WalkingGui extends JPanel implements ActionListener {
    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;
    private JButton jcomp5;
    private JLabel label;

    public WalkingGui() {
 
        jcomp1 = new JButton ("W");
        jcomp2 = new JButton ("S");
        jcomp3 = new JButton ("N");
        jcomp5 = new JButton ("E");
        label = new JLabel("Walking");

        setPreferredSize (new Dimension (170, 170));
        setLayout (null);

        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp5);
        add (label);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (0, 60, 60, 60);
        jcomp2.setBounds (60, 120, 60, 60);
        jcomp3.setBounds (60, 0, 60, 60);
        jcomp5.setBounds (120, 60, 60, 60);
        label.setBounds(67, 80, 60, 20);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

