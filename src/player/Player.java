package player;

import gui.*;

public class Player {
	
	private PlayerAssistant pa = new PlayerAssistant(this);
	private MapGui mapg = new MapGui(this);
	private MainGui maing = new MainGui(this);
	private LoginGui lg = new LoginGui(this);
	
	public int id = -1;
	public PlayerHandler handler = null;
	public boolean disconnected;
	public boolean initialized;
	
	public static final int maxPlayerListSize = 100;
	public Player playerList[] = new Player[maxPlayerListSize];
	public int playerListSize = 0;
	
	public byte playerInListBitmap[] = new byte[(100+7) >> 3];

	public String name, pass = null;
	public int money, playerLevel = 0;
	public int[] items, itemsAmt;
	public int x, y = 0;
	
	public Player(int _id) {
		id = _id;
		items = itemsAmt = new int[20];
		money = 50;
		playerLevel = 1;
		x = 0;
		y = 0;
	}
	
	void destruct() {
		playerListSize = 0;
		for(int i = 0; i < maxPlayerListSize; i++) 
			playerList[i] = null;
		x = y = -1;
	}
	
	public void logout() {
		PlayerLogin.save(this);
		disconnected = true;
		destruct();
		System.exit(0);
	}
	
	public void initialize() {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (j == id)
				continue;
			if (PlayerHandler.players[j] != null) {
				if (PlayerHandler.players[j].name.equalsIgnoreCase(name))
					disconnected = true;
			}
		}
	}
	
	public void process() {
		
	}
	
	public void update() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean samePlayer() {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (j == id)
				continue;
			if (PlayerHandler.players[j] != null) {
				if (PlayerHandler.players[j].name.equalsIgnoreCase(name)) {
					disconnected = true;
					return true;
				}	
			}
		}
		return false;	
	}
	
	public PlayerAssistant getPA() {
		return pa;
	}
	
	public MapGui getMap() {
		return mapg;
	}
	
	public MainGui getMain() {
		return maing;
	}
	
	public LoginGui getLogin() {
		return lg;
	}
	
}
