package player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public  class PlayerLogin {
	
	public static void load(Player p, String name2, String pass2) {
		String line = "";
		String token = "";
		String token2 = "";
		String[] token3 = new String[3];
		boolean fileFound = true;
		BufferedReader playerFile = null;
		boolean endOfFile = false;
		try {
			playerFile = new BufferedReader(new FileReader("./players/"+name2+".txt"));
		} catch (FileNotFoundException fnfe) {
			fileFound = false;
		}
		if (!fileFound) {
			p = new Player();
			return;
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
						return;
					}
				}
				if (token.equals("money")) {
					p.money = Integer.parseInt(token2);
				}
				if (token.equals("level")) {
					p.playerLevel = Integer.parseInt(token2);
				}
				if (token.equals("items")) {
					p.items[Integer.parseInt(token3[0])] = Integer.parseInt(token3[1]);
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void save(Player p) {
		if(p.name == null) {
			return;
		}
		BufferedWriter playerFile = null;
		try {
			playerFile = new BufferedWriter(new FileWriter("./players/"+p.name+".txt"));
			
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
			playerFile.write("[EOF]", 0, 5);
			playerFile.newLine();
			playerFile.newLine();
			playerFile.close();
		} catch (IOException oops) {
			return;
		}
	}
	
}
