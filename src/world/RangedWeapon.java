package world;

public class RangedWeapon extends Weapon {
	private int range;
	private int speed;
	//ticks per cell
	
	public RangedWeapon(boolean b, LivingThing l, int r, int s) {
		super(b,l);
		range=r;
		speed=s;
		// TODO Auto-generated constructor stub
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
