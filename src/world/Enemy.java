package world;

import java.awt.Color;

public class Enemy extends LivingThing {
	private int damage;
	
	public Enemy(boolean b, Color c, int damage) {
		super(b, c);
		this.damage = damage;
	}

	public Enemy(boolean b, Color c, String name, int strength, int intelligence, int dexterity) {
		super(name, strength, intelligence, dexterity, b, c);
	}

}
