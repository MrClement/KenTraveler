package world;

/**
 * @author cwilson14 defines all weapons, including melee and ranged weapons
 * 
 */
public class Weapon extends Thing {

	private LivingThing l;
	private Damage damage;
	private int length;

	
	public Weapon(boolean b, LivingThing x) {
		super(b);
		l = x;
		// TODO Auto-generated constructor stub
	}

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

	public void doDamage(GridSpace c) {
		int hpDamage;
		int	strengthDamage;
		int	intelligenceDamage;
		int	dexterityDamage;
		int	speedDamage;
		int	manaDamage;
		int baseXpDamage;
		int remainingHp;
		int remainingStrength;
		int remainingIntelligence;
		int remainingDexterity;
		int remainingSpeed;
		int remainingMana;
		
		hpDamage = this.getDamage().getBaseHpDamage();
		strengthDamage = this.getDamage().getBaseStrengthDamage();
		intelligenceDamage = this.getDamage().getBaseIntelligenceDamage();
		dexterityDamage = this.getDamage().getBaseDexterityDamage();
		speedDamage = this.getDamage().getBaseSpeedDamage();
		manaDamage = this.getDamage().getBaseManaDamage();
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
