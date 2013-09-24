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
		
		//calculates damages
		hpDamage = this.getDamage().getBaseHpDamage();
		if(strengthMultiplier > 1)
			hpDamage = hpDamage + (l.getStrength() * strengthMultiplier);
		if(manaMultiplier > 1)
			hpDamage = hpDamage + (l.getMana() * manaMultiplier);
		if(speedMultiplier > 1)
			hpDamage = hpDamage + (l.getSpeed() * speedMultiplier);
		if(dexterityMultiplier > 1)
			hpDamage = hpDamage + (l.getDexterity() * dexterityMultiplier);
		if(intelligenceMultiplier > 1)
			hpDamage = hpDamage + (l.getIntelligence() * intelligenceMultiplier);
		strengthDamage = this.getDamage().getBaseStrengthDamage();
		intelligenceDamage = this.getDamage().getBaseIntelligenceDamage();
		dexterityDamage = this.getDamage().getBaseDexterityDamage();
		speedDamage = this.getDamage().getBaseSpeedDamage();
		manaDamage = this.getDamage().getBaseManaDamage();
		
		//Calculates remaining stats
		remainingHp = oo.getHp() - hpDamage;
		remainingStrength = oo.getStrength() - strengthDamage;
		remainingIntelligence = oo.getIntelligence() - intelligenceDamage;
		remainingDexterity = oo.getDexterity() - dexterityDamage;
		remainingSpeed = oo.getSpeed() - speedDamage;
		remainingMana = oo.getMana() - manaDamage;
		
		//updates all stats of Character
		oo.updateHp((int)remainingHp);
		oo.updateStrength((int)remainingStrength);
		oo.updateIntelligence((int)remainingIntelligence);
		oo.updateDexterity((int)remainingIntelligence);
		oo.updateSpeed((int)remainingSpeed);
		oo.updateMana((int)remainingMana);
		}
		

}
