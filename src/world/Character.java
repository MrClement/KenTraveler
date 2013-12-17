package world;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author jpoley15 Creates a new character, allows for stat implementation
 * 
 */
public class Character extends LivingThing {

	private int xp;
	private int level;
	private Weapon weapon;
	private ArrayList<RangedWeapon> rangedStore = new ArrayList<RangedWeapon>();
	private ArrayList<Magic> magicStore = new ArrayList<Magic>();
	private ArrayList<Weapon> closeStore = new ArrayList<Weapon>();

	public Character(boolean solid, Color c) {
		super(solid, c);
	}

	public Character(String name, int strength, int intelligence, int dexterity, boolean solid, Color c) {
		super(name, strength, intelligence, dexterity, solid, c);
		xp = 0;
		level = 1;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public void addXp(int xp) {
		this.xp = this.xp + xp;
	}

	public int getLevel() {
		return level;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon wep) {
		this.weapon = wep;
	}

	public ArrayList<RangedWeapon> getRangedStore() {
		return rangedStore;
	}

	public ArrayList<Magic> getMagicStore() {
		return magicStore;
	}

	public ArrayList<Weapon> getCloseStore() {
		return closeStore;
	}

	public void addWeapon(Weapon weapon) {
		this.weapon = weapon;
		if (weapon instanceof RangedWeapon && !(weapon instanceof Magic)) {
			if (!rangedStore.contains(weapon)) {
				this.rangedStore.add((RangedWeapon) weapon);
				return;
			}
		} else if (weapon instanceof Magic) {
			if (!magicStore.contains(weapon)) {
				this.magicStore.add((Magic) weapon);
				return;
			}
		} else {
			if (closeStore.contains(weapon)) {
				this.closeStore.add(weapon);
				return;
			}
		}
		closeStore.add(weapon);
	}

	public void levelUp() {
		if (xp >= 1000 * level) {
			setXp(0);
			level++;
			int points = getIntelligence();
			updateMaxDexterity(points);
			updateMaxIntelligence(points);
			updateMaxStrength(points);
			updateMaxSpeed(0);
			updateMaxMana(0);
			updateMaxHp(10);
			setHp(getMaxHp());
		}
	}

}
