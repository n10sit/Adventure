package main;

import player.PlayerHandler;
import player.Player;
import player.PlayerLogin;
import monster.MonsterHandler;

public class Main {
	
	public static PlayerHandler playerHandler = new PlayerHandler();
	public static MonsterHandler monsterHandler = new MonsterHandler();
	
	public static long lastMassSave = System.currentTimeMillis();
	private static boolean shutdown = false;
	
	public static void main(String[] args) {
		PlayerLogin.start();
	     try {
				while (!shutdown) {
					Thread.sleep(600);
					playerHandler.process();	
		            monsterHandler.process();
					if (System.currentTimeMillis() - lastMassSave > 300000) {
						for(Player p : PlayerHandler.players) {
							if(p == null)
								continue;						
							PlayerLogin.save(p);
							System.out.println("Saved game for " + p.name + ".");
							lastMassSave = System.currentTimeMillis();
						}
					
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("A fatal exception has been thrown!");
				for(Player p : PlayerHandler.players) {
					if(p == null)
						continue;						
					PlayerLogin.save(p);
					System.out.println("Saved game for " + p.name + ".");
				}
			}
			System.exit(0);
	}

}
