package player;

import gui.LoginGui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class PlayerLogin {
	
	public static void start() {
		 JFrame frame = new JFrame ("Login");
	     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	     frame.getContentPane().add (LoginGui.createLoginGui());
	     frame.pack();
	     frame.setResizable(false);
	     frame.setVisible (true);
	}
	
	public static boolean load(Player p2, String name2, String pass2) {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean fileFound = true;
		BufferedReader playerFile = null;
		boolean endOfFile = false;
		try {
			playerFile = new BufferedReader(new FileReader("./data/"+name2+".txt"));
		} catch (FileNotFoundException fnfe) {
			fileFound = false;
		}
		if (!fileFound) {
	
			return false;
		} else {
			try {
				line = playerFile.readLine();
			} catch(IOException ioexception) {
				System.out.println(name2+": error loading file.");
			}
		}
		while (!endOfFile && line != null) {
			line = line.trim();
			int spot = line.indexOf("=");
			if (spot > -1) {
				token = line.substring(0, spot);
				token = token.trim();
				token2 = line.substring(spot + 1);
				token2 = token2.trim();
				token3 = token2.split("\t");
				if (token.equals("pass")) {
					if (pass2.equalsIgnoreCase(token2)) {
						pass2.equals(token2);
					} else {
						System.out.println("Incorrect password.");
						return false;
					}
				}
				
				if (token.equals("money")) {
					p2.money = Integer.parseInt(token2);
				}
				if (token.equals("level")) {
					p2.playerLevel = Integer.parseInt(token2);
				}
				if (token.equals("items")) {
					p2.items[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
					p2.itemsAmt[Integer.parseInt(token3[0])] = Integer.parseInt(token3[2]);
				}
				if (token.equals("x")) {
					p2.x = Integer.parseInt(token2);
				}
				if (token.equals("y")) {
					p2.y = Integer.parseInt(token2);
				}
			}
			try {
				line = playerFile.readLine();
			} catch(IOException ioexception1) { 
				endOfFile = true;
			}
		}
		try {
			playerFile.close();
			System.out.println("loaded for "+name2+" with password "+pass2+"");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean save(Player p) {
		if(p.name == null) {
			System.out.println("name is null");
			return false;
		}
		BufferedWriter playerFile = null;
		try {
			playerFile = new BufferedWriter(new FileWriter("./data/"+p.name+".txt"));
			
			playerFile.write("name = ", 0, 7);
			playerFile.write(p.name, 0, p.name.length());
			playerFile.newLine();
			playerFile.write("pass = ", 0, 7);
			playerFile.write(p.pass, 0, p.pass.length());
			playerFile.newLine();
			playerFile.write("money = ", 0, 8);
			playerFile.write(Integer.toString(p.money), 0, Integer.toString(p.money).length());
			playerFile.newLine();
			playerFile.write("level = ", 0, 8);
			playerFile.write(Integer.toString(p.playerLevel), 0, Integer.toString(p.playerLevel).length());
			playerFile.newLine();
			for (int i = 0; i < p.items.length; i++) {
				if (p.items[i] > 0) {
					playerFile.write("character-item = ", 0, 17);
					playerFile.write(Integer.toString(i), 0, Integer.toString(i).length());
					playerFile.write("	", 0, 1);
					playerFile.write(Integer.toString(p.items[i]), 0, Integer.toString(p.items[i]).length());
					playerFile.write("	", 0, 1);
					playerFile.write(Integer.toString(p.itemsAmt[i]), 0, Integer.toString(p.itemsAmt[i]).length());
					playerFile.newLine();
				}
			}
			playerFile.write("x = ", 0, 4);
			playerFile.write(Integer.toString(p.x), 0, Integer.toString(p.x).length());
			playerFile.newLine();
			playerFile.write("y = ", 0, 4);
			playerFile.write(Integer.toString(p.y), 0, Integer.toString(p.y).length());
			playerFile.newLine();
			playerFile.write("[EOF]", 0, 5);
			playerFile.newLine();
			playerFile.newLine();
			playerFile.close();
			System.out.println("saved for "+p.name);
			return true;
		} catch (IOException oops) {
			oops.printStackTrace();
			return false;
		}
	}
	
}
