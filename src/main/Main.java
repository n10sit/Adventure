package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		 JFrame frame = new JFrame ("Login");
	     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	     frame.getContentPane().add (new Gui());
	     frame.pack();
	     frame.setResizable(false);
	     frame.setVisible (true);
	}

}
