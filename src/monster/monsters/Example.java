package monster.monsters;

import monster.*;

public class Example {
	
	private Monster m;

	public Example(Monster monster) {
		this.m = monster;
		m.id = 1;
		m.level = 1;
		m.attack = 5;
		m.defence = 5;
		m.hp = 5;
		m.name = "Example";
	}
	
	public void create() {
		new Example(m);
	}
	
}
