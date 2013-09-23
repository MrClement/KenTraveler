package world;

public class Damage {
	
	private int baseHpDamage;
	private int baseStrengthDamage;
	private int baseIntelligenceDamage;
	private int baseDexterityDamage;
	private int baseSpeedDamage;
	private int baseManaDamage;
	private int baseXpDamage;
	private int dot; //damage over time
	private boolean solid;
	private boolean gassify;
	private boolean freeze;
	
	public Damage(int hp, int strength, int intelligence, int dexterity, int speed, int mana, int xp, int dot, boolean solid, boolean gassify, boolean freeze){
		baseHpDamage=hp;
		baseStrengthDamage=strength;
		baseIntelligenceDamage=intelligence;
		baseDexterityDamage=dexterity;
		baseSpeedDamage=speed;
		baseManaDamage=mana;
		baseXpDamage=xp;
		this.dot=dot;
		this.solid=solid;
		this.gassify=gassify;
		this.freeze=freeze;
	}

	public int getDot() {
		return dot;
	}

	public void setDot(int dot) {
		this.dot = dot;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public boolean isGassify() {
		return gassify;
	}

	public void setGassify(boolean gassify) {
		this.gassify = gassify;
	}

	public boolean isFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	public int getBaseHpDamage() {
		return baseHpDamage;
	}

	public void setBaseHpDamage(int baseHpDamage) {
		this.baseHpDamage = baseHpDamage;
	}

	public int getBaseStrengthDamage() {
		return baseStrengthDamage;
	}

	public void setBaseStrengthDamage(int baseStrengthDamage) {
		this.baseStrengthDamage = baseStrengthDamage;
	}

	public int getBaseIntelligenceDamage() {
		return baseIntelligenceDamage;
	}

	public void setBaseIntelligenceDamage(int baseIntelligenceDamage) {
		this.baseIntelligenceDamage = baseIntelligenceDamage;
	}

	public int getBaseDexterityDamage() {
		return baseDexterityDamage;
	}

	public void setBaseDexterityDamage(int baseDexterityDamage) {
		this.baseDexterityDamage = baseDexterityDamage;
	}

	public int getBaseSpeedDamage() {
		return baseSpeedDamage;
	}

	public void setBaseSpeedDamage(int baseSpeedDamage) {
		this.baseSpeedDamage = baseSpeedDamage;
	}

	public int getBaseManaDamage() {
		return baseManaDamage;
	}

	public void setBaseManaDamage(int baseManaDamage) {
		this.baseManaDamage = baseManaDamage;
	}

	public int getBaseXpDamage() {
		return baseXpDamage;
	}

	public void setBaseXpDamage(int baseXpDamage) {
		this.baseXpDamage = baseXpDamage;
	}
	
}
