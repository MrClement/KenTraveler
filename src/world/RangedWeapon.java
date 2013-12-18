package world;

import java.awt.Color;

public class RangedWeapon extends Weapon {
	private int range;
	private int speed;
	private int currentSpeed;

	// ticks per cell

	public RangedWeapon(boolean b, Color c, LivingThing l, int r, int s, String name) {
		super(b, c, l, name);
		range = r;
		speed = s;
		currentSpeed=0;
		// TODO Auto-generated constructor stub
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
