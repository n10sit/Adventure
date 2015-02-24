package player;

public class Player {
	
	//public int id = 0;

	public String name, pass = "";
	
	public int money, playerLevel = 0;
	
	public int[] items, itemsAmt = new int[28];
	
	Player() {}
	public Player(String name, String pass, int money, int playerLevel, int[] items, int[] itemsAmt) {
		//this.id = id;
		this.name = name;
		this.pass = pass;
		this.money = money;
		this.playerLevel = playerLevel;
		this.items = items;
		this.itemsAmt = itemsAmt;
	}
	
}
