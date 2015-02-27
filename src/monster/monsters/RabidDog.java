package monster.monsters;

import monster.*;

public class RabidDog {
	
	private Monster m;

	public RabidDog(Monster monster) {
		this.m = monster;
		m.id = 2;
		m.level = 1;
		m.attack = 10;
		m.defence = 5;
		m.hp = 15;
		m.name = "Rabid Dog";
	}
	
	public void create() {
		new RabidDog(m);
	}
	
}
