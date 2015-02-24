package player;

public class Player {

	public String name, pass;
	
	public int money, playerLevel;
	
	public int[] items;
	
	public Player() {
		for (int i = 0; i < items.length; i++) {
			items[i] = 0;
		}
		playerLevel = 0;
		money = 50;
	}
	
}
