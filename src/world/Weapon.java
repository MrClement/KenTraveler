package world;

/**
 * @author cwilson14 defines all weapons, including melee and ranged weapons
 * 
 */
public class Weapon extends Thing {

	public Weapon(boolean b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	private int damage;
	private int length;

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
