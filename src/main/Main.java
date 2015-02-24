package main;

import gui.*;

import javax.swing.JFrame;

import monster.MonsterHandler;

public class Main {
	
	public static MonsterHandler monsterHandler = new MonsterHandler();

	public static void main(String[] args) {
		 JFrame frame = new JFrame ("Login");
	     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	     frame.getContentPane().add (new LoginGui());
	     frame.pack();
	     frame.setResizable(false);
	     frame.setVisible (true);
	}

}
