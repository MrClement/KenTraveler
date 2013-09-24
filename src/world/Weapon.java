package world;

/**
 * @author cwilson14 defines all weapons, including melee and ranged weapons
 * 
 */
public class Weapon extends Thing {

	private LivingThing l;
	private Damage damage;
	private int length;
	private double strengthMultiplier;
	private double dexterityMultiplier;
	private double speedMultiplier;
	private double intelligenceMultiplier;
	private double manaMultiplier;

	
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

	public void doDamage(LivingThing oo) {
		double hpDamage;
		double	strengthDamage;
		double	intelligenceDamage;
		double	dexterityDamage;
		double	speedDamage;
		double manaDamage;
		double baseXpDamage;
		double remainingHp;
		double remainingStrength;
		double remainingIntelligence;
		double remainingDexterity;
		double remainingSpeed;
		double remainingMana;
		
		//calculates Total HP Damage
		hpDamage = this.getDamage().getBaseHpDamage();
		if(strengthMultiplier > 1)
			hpDamage = hpDamage * (l.getStrength() * strengthMultiplier);
		if(manaMultiplier > 1)
			hpDamage = hpDamage * (l.getMana() * manaMultiplier);
		if(speedMultiplier > 1)
			hpDamage = hpDamage * (l.getSpeed() * speedMultiplier);
		if(dexterityMultiplier > 1)
			hpDamage = hpDamage * (l.getDexterity() * dexterityMultiplier);
		if(intelligenceMultiplier > 1)
			hpDamage = hpDamage * (l.getIntelligence() * intelligenceMultiplier);
		
		strengthDamage = this.getDamage().getBaseStrengthDamage();
		intelligenceDamage = this.getDamage().getBaseIntelligenceDamage();
		dexterityDamage = this.getDamage().getBaseDexterityDamage();
		speedDamage = this.getDamage().getBaseSpeedDamage();
		manaDamage = this.getDamage().getBaseManaDamage();
		
		//Needs Work on Past here Dont evaluate this yet
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
