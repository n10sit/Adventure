package player;

public class PlayerHandler {

	public static Player players[] = new Player[100];
	public static int playerCount = 0;
	private boolean kickAllPlayers = false;
	
	static {
		for(int i = 0; i < 100; i++)
			players[i] = null;
	}
	
	public boolean newPlayer(Player p1) {
    	int slot = -1;
    	for(int i = 1; i < 100; i++) {
    		if((players[i] == null)) {
    			slot = i;
    			break;
    		}
    	}
    	if(slot == -1)
            return false;
        p1.handler = this;
        players[slot] = p1;
        return true;
    }
	
	public void destruct() {
		for(int i = 0; i < 100; i++) {
			if(players[i] == null) 
				continue;
			players[i] = null;
		}
	}

	public static int getPlayerCount() {
		return playerCount;
	}
	
	public void process() {
		synchronized(PlayerHandler.players) {
			
			if(kickAllPlayers) {
				for(int i = 1; i < 100; i++) {
					if(players[i] != null) {
						players[i].disconnected = true;
					}
				}
			}
			
			for (int i = 0; i < 100; i++) {
				if (players[i] == null) continue;
				try {
					if (players[i].disconnected || kickAllPlayers) {
						Player o = PlayerHandler.players[i];
						if(PlayerLogin.save(o)) { 
							System.out.println("Game saved for player "+players[i].name); 
						} else { 
							System.out.println("Could not save for "+players[i].name); 
						}
						removePlayer(players[i]);
						players[i] = null;
						continue;
					}
					players[i].process();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 100; i++) {
				if (players[i] == null) continue;
				try {
					if (players[i].disconnected || kickAllPlayers) {
						Player o1 = PlayerHandler.players[i];
						if(PlayerLogin.save(o1)){ 
							System.out.println("Game saved for player "+players[i].name); 
						} else { 
							System.out.println("Could not save for "+players[i].name); 
						}
						removePlayer(players[i]);
						players[i] = null;
					} else {
						if(!players[i].initialized) {
							players[i].initialize();
							players[i].initialized = true;
						} else {
							players[i].update();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void removePlayer(Player plr) {
		plr.destruct();
	}
	
}
