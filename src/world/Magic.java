package world;

public class Magic extends RangedWeapon {

	private int manaCost;
	
	public Magic(boolean b, LivingThing l, int r, int m, int s){
		super(b,l,r,s);
		manaCost=m;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	
}
