package world;

public class Character extends LivingThing {

	private String name;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int hp;
	private int speed;
	private int mana;
	private int xp;
	
	// Constructs a default character with name "name" and stats all set to 10 //
	
	public Character(boolean solid){
		
		super(solid);
		name = "name";
		strength = 10;
		intelligence = 10;
		dexterity = 10;
		
	}
	
	// Constructs a character with user specified name and stats //
	
	public Character(String name, int strength, int intelligence, int dexterity, boolean solid){
		
		super(solid);
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		
		hp = strength * 5;
		speed = dexterity * 5;
		mana = intelligence * 5;
		xp = 0;
		
	}
	
}
