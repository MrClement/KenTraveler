/**
 * 
 */
package world;

import java.awt.Color;

/**
 * @author cwilson14 Constructs weapons
 */
public class Forge {

	// 0=fire magic lvl 1
	// 1=fire magic lvl 2
	// 2=fire magic lvl 3
	// 3=ice magic lvl 1
	// 4=ice magic lvl 2
	// 5=ice magic lvl 3
	// 6=solidify
	// 7=gassify

	public Forge() {
	}

	public Magic constructMagic(int i, LivingThing l) {
		if (i == 0) {
			String name = "Fire Magic 1";
			Magic fire1 = new Magic(true, Color.ORANGE, l, 5, 3, 1, name);
			Damage fire1Dam = new Damage(5, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire1.setDamage(fire1Dam);
			return fire1;

		} else if (i == 1) {
			String name = "Fire Magic 2";
			Magic fire2 = new Magic(true, Color.ORANGE, l, 10, 8, 1, name);
			Damage fire2Dam = new Damage(10, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		} else if (i == 2) {
			String name = "Fire Magic 3";
			Magic fire2 = new Magic(true, Color.ORANGE, l, 20, 15, 1, name);
			Damage fire2Dam = new Damage(5, 0, 0, 0, 0, 0, 0, 5, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		} else if (i == 3) {
			String name = "Ice Magic 1";
			Magic ice1 = new Magic(true, new Color(200, 249, 250), l, 5, 3, 1, name);
			Damage ice1Dam = new Damage(5, 0, 0, 0, 5, 0, 0, 0, false, false, false);
			ice1.setDamage(ice1Dam);
			return ice1;
		} else if (i == 4) {
			String name = "Ice Magic 2";
			Magic ice2 = new Magic(true, new Color(200, 249, 250), l, 10, 8, 1, name);
			Damage ice2Dam = new Damage(10, 0, 0, 0, 10, 0, 0, 0, false, false, false);
			ice2.setDamage(ice2Dam);
			return ice2;
		} else if (i == 5) {
			String name = "Ice Magic 3";
			Magic ice3 = new Magic(true, new Color(200, 249, 250), l, 20, 15, 1, name);
			Damage ice3Dam = new Damage(15, 0, 0, 0, 10, 0, 0, 0, false, false, true);
			ice3.setDamage(ice3Dam);
			return ice3;
		} else if (i == 6) {
			String name = "Solidify";
			Magic solidify = new Magic(true, Color.DARK_GRAY, l, 8, 11, 1, name);
			Damage solidifyDamage = new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			solidify.setDamage(solidifyDamage);
			return solidify;
		} else if (i == 7) {
			String name = "Gassify";
			Magic gassify = new Magic(true, Color.LIGHT_GRAY, l, 8, 11, 1, name);
			Damage gassifyDamage = new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			gassify.setDamage(gassifyDamage);
			return gassify;
		}
		if (i == 8) {
			String name = "Basic Fire Magic";
			Magic basicFire = new Magic(true, Color.ORANGE, l, 5, 3, 1, name);
			Damage basicFireDam = new Damage(3, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			basicFire.setDamage(basicFireDam);
			return basicFire;
		}
		return null;
	}

	// 0=basic bow + arrows
	// 1=longbow + arrows
	// 2=basic crossbow + bolts
	// 3=finely crafted crossbow + bolts
	// 4=javelins
	// 5=throwing knives
	public RangedWeapon constructRangedWeapons(int i, LivingThing l) {
		if (i == 0) {
			String name = "Basic Bow";
			RangedWeapon baseBow = new RangedWeapon(true, Color.YELLOW, l, 15, 1, name);
			Damage baseBowDamage = new Damage(3, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			baseBow.setDamage(baseBowDamage);
			return baseBow;
		} else if (i == 1) {
			String name = "Long Bow";
			RangedWeapon longBow = new RangedWeapon(true, Color.YELLOW, l, 30, 1, name);
			Damage longBowDamage = new Damage(5, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			longBow.setDamage(longBowDamage);
			return longBow;
		} else if (i == 2) {
			String name = "Cross Bow";
			RangedWeapon crossBow = new RangedWeapon(true, Color.YELLOW, l, 20, 1, name);
			Damage crossBowDamage = new Damage(7, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			crossBow.setDamage(crossBowDamage);
			return crossBow;
		} else if (i == 3) {
			String name = "Cross Bow Plus";
			RangedWeapon crossBowPlus = new RangedWeapon(true, Color.YELLOW, l, 30, 1, name);
			Damage crossBowPlusDamage = new Damage(25, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			crossBowPlus.setDamage(crossBowPlusDamage);
			return crossBowPlus;
		} else if (i == 4) {
			String name = "Javelin";
			RangedWeapon javelin = new RangedWeapon(true, Color.YELLOW, l, 10, 1, name);
			Damage javelinDamage = new Damage(10, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			javelin.setDamage(javelinDamage);
			return javelin;
		} else if (i == 5) {
			String name = "Throwing Knives";
			RangedWeapon throwingKnives = new RangedWeapon(true, Color.YELLOW, l, 15, 1, name);
			Damage throwingKnivesDamage = new Damage(4, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			throwingKnives.setDamage(throwingKnivesDamage);
			return throwingKnives;
		}
		return null;
	}

	public Weapon constructMeleeWeapons(int i, LivingThing l) {
		if (i == 0) {
			String name = "Sword";
			Weapon sword = new Weapon(true, Color.RED, l, name);
			Damage swordDamage = new Damage(5, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			sword.setDamage(swordDamage);
			return sword;
		}
		return null;
	}

}
