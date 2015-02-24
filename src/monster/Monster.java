package monster;

import monster.monsters.*;

public class Monster {
	
	public int id, level, attack, defence, hp;
	
	public String name;
	
	public boolean alive;
	
	public Example example = new Example(this);
	
	public Monster(int id, int level, int attack, int defence, int hp, String name) {
		this.id = id;
		this.level = level;
		this.attack = attack;
		this.defence = defence;
		this.hp = hp;
		this.name = name;
		this.alive = true;
	}
	
	public Example getExample() {
		return example;
	}

}
