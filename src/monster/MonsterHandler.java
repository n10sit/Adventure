package monster;

public class MonsterHandler {
	
	public static Monster monsters[] = new Monster[100];
	
	public MonsterHandler() {
		for (int x = 0; x < 100; x++) {
			monsters[x] = null;
		}
	}
	
}
