package driver;

import world.Character;

public class SaveGameWriter {
	
	
	public SaveGameWriter(){
		
	}
	
	public void writeSaveGame(Character c){
		int gold=c.getMoney();
		int level=c.getLevel();
		int exp=c.getXp();
		int hp=c.getHp();
		int ammo=c.getAmmo();
		int mana=c.getMana();
		int maxHP=c.getMaxHp();
		int str=c.getStrength();
		int intelligence=c.getIntelligence();
		int dex=c.getDexterity();
		int Speed=c.getDexterity();
		String name=c.getName();
		
		
	}
	
	public void loadSaveGame(){
	
	}
}
