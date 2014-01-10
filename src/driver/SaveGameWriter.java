package driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import world.Character;

public class SaveGameWriter {

	public SaveGameWriter() {

	}

	public void writeSaveGame(Character c) {
		int gold = c.getMoney();
		int level = c.getLevel();
		int exp = c.getXp();
		int hp = c.getHp();
		int ammo = c.getAmmo(); 
		int mana = c.getMana(); 
		int maxHP = c.getMaxHp();
		int str = c.getStrength(); 
		int intelligence = c.getIntelligence();
		int dex = c.getDexterity(); 
		int Speed = c.getDexterity(); 
		String name = c.getName(); 

		
		File f = new File("save.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
				out.write("Gold:" + gold);
				out.newLine();
				out.write("Level" + level);
				out.newLine();
				out.write("Exp:" + exp);
				out.newLine();
				out.write("Hp:" + hp);
				out.newLine();
				out.write("Ammo:" + ammo);
				out.newLine();
				out.write("Mana:" + mana);
				out.newLine();
				out.write("Max Hp:" + maxHP);
				out.newLine();
				out.write("Strength:" + str);
				out.newLine();
				out.write("Intelligence:" + intelligence);
				out.newLine();
				out.write("Dexterity:" + dex);
				out.newLine();
				out.write("Speed:" + Speed);
				out.newLine();
				out.write("Name:" + name);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			

	}

	public void loadSaveGame() {

	}
}
