package world;

public class LivingThing extends Thing {

	private int hp;
	private String name;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int speed;
	private int mana;

	public LivingThing(boolean b) {
		super(b);
	}
	
	public LivingThing(String name, int strength, int intelligence, int dexterity, boolean solid){
		super(solid);
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		hp = strength * 5;
		mana = intelligence * 5;
		speed = dexterity * 5;
		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	public void updateStrength(int Strength){
		strength += Strength;
		updateHp(0);
	}

	public void updateIntelligence(int Intelligence){
		intelligence += Intelligence;
		updateMana(0);
	}
	

	public void updateDexterity(int Dexterity){
		dexterity += Dexterity;
		updateSpeed(0);
	}
	

	public void updateSpeed(int Speed){
		speed = (dexterity * 5) + Speed;
	}
	

	public void updateMana(int Intelligence){
		mana = (intelligence * 5) + Intelligence;
	}
	
	public void updateHp(int HP){
		hp = (strength * 5) + HP;
	}

}
