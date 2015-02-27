package player;


public class Player {
	
	//public int id = 0;
	public PlayerHandler handler = null;

	public static String name, pass = "";
	
	public static int money, playerLevel = 0;
	
	public static int[] items, itemsAmt = new int[28];
	
	public static int x, y = 0;
	
	Player() {}
	public Player(String name, String pass, int money, int playerLevel, int[] items, int[] itemsAmt, int x, int y) {
		//this.id = id;
		Player.name = name;
		Player.pass = pass;
		Player.money = money;
		Player.playerLevel = playerLevel;
		Player.items = items;
		Player.itemsAmt = itemsAmt;
		Player.x = x;
		Player.y = y;
	}
	
	
	
}
