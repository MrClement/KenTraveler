package world;

public class Character extends LivingThing {

	private String name;
	private int strength;
	private int intelligence;
	private int dexterity;
	
	// Constructs a default character with name "name" and stats all set to 10 //
	
	public Character(){
		
		name = "name";
		strength = 10;
		intelligence = 10;
		dexterity = 10;
		
	}
	
	// Constructs a character with user specified name and stats //
	
	public Character(String name, int strength, int intelligence, int dexterity){
		
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		
	}
	
}
