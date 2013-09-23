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

	private Damage damage;
	private int length;

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void doDamage(GridSpace c, Character d) {
		int remainingHp;
		int hpDamage;
		hpDamage = this.getDamage().
		for(int i = 0; i <=c.returnLivingThings().size(); i++)
		
		{
		remainingHp = c.returnLivingThings().get(i).getHp();
		if(this.getDamage() >= remainingHp){
		
		c.returnLivingThings().get(i).getPosition.remove;
		
		}
		
		else{
				
		c.returnThings().get(i).setHP(remainingHp - this.getDamage());
		}
		
		}
		

}
