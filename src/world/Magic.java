package world;

import java.awt.Color;

public class Magic extends RangedWeapon {

	private int manaCost;

	public Magic(boolean b, Color c, LivingThing l, int r, int m, int s, String name) {
		super(b, c, l, r, s, name);
		manaCost = m;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

}
