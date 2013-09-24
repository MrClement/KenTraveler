package world;

public class RangedWeapon extends Weapon {
	private int range;
	private int speed;
	//ticks per cell
	
	public RangedWeapon(boolean b, LivingThing l, int r) {
		super(b,l);
		range=r;
		// TODO Auto-generated constructor stub
	}

	public int getRange() {
		return range;
	 }

	public void setRange(int range) {
		this.range = range;
	}

}
