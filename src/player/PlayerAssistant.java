package player;

import javax.swing.JLabel;

public class PlayerAssistant {
	
	private Player p;
	public PlayerAssistant(Player player) {
		this.p = player;
	}

	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public int getId() {
		return p.id;
	}
	
}
