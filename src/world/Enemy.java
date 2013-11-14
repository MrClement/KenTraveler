package world;

import java.awt.Color;

public class Enemy extends LivingThing {

	public Enemy(boolean b, Color c) {
		super(b, c);
	}

	public Enemy(boolean b, Color c, String name, int strength, int intelligence, int dexterity) {
		super(name, strength, intelligence, dexterity, b, c);
	}

}
