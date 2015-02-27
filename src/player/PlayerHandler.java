package player;

public class PlayerHandler {

	public static Player players[] = new Player[100];
	
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
	
}
