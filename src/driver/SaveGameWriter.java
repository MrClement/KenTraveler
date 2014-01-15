package driver;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
		// String name = c.getName();

		File f = new File("save.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			out.write("" + gold);
			out.newLine();
			out.write("" + level);
			out.newLine();
			out.write("" + exp);
			out.newLine();
			out.write("" + hp);
			out.newLine();
			out.write("" + ammo);
			out.newLine();
			out.write("" + mana);
			out.newLine();
			out.write("" + maxHP);
			out.newLine();
			out.write("" + str);
			out.newLine();
			out.write("" + intelligence);
			out.newLine();
			out.write("" + dex);
			out.newLine();
			out.write("" + Speed);
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Character loadSaveGame() {
		try {
			Scanner s = new Scanner(new File("save.txt"));
			int gold = s.nextInt();
			int level = s.nextInt();
			int exp = s.nextInt();
			int hp = s.nextInt();
			int ammo = s.nextInt();
			int mana = s.nextInt();
			int maxHP = s.nextInt();
			int str = s.nextInt();
			int intelligence = s.nextInt();
			int dex = s.nextInt();
			int speed = s.nextInt();
			Character c = new Character(gold, level, exp, hp, ammo, mana, maxHP, str, intelligence, dex, speed,
					"TROGDOR");
			return c;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Character(true, Color.BLUE);
	}
}
