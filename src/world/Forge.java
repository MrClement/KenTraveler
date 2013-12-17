/**
 * 
 */
package world;

import java.awt.Color;

/**
 * @author cwilson14
 *	Constructs weapons
 */
public class Forge {
	
	//0=fire magic lvl 1
	//1=fire magic lvl 2
	//2=fire magic lvl 3
	//3=ice magic lvl 1
	//4=ice magic lvl 2
	//5=ice magic lvl 3
	//6=solidify
	//7=gassify
	
	public Forge(){
	}
	
	public Magic constructMagic(int i, LivingThing l){
		if(i==0){
			Magic fire1=new Magic(true, Color.ORANGE, l, 5, 3, 1);
			Damage fire1Dam=new Damage(10, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire1.setDamage(fire1Dam);
			return fire1;
			
		}
		else if(i==1){
			Magic fire2=new Magic(true, Color.ORANGE, l, 10, 8, 1);
			Damage fire2Dam=new Damage(20, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		}
		else if(i==2){
			Magic fire2=new Magic(true, Color.ORANGE, l, 20, 15, 1);
			Damage fire2Dam=new Damage(5, 0, 0, 0, 0, 0, 0, 5, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		}
		else if(i==3){
			Magic ice1=new Magic(true, new Color(200, 249, 250), l, 5, 3, 1);
			Damage ice1Dam=new Damage(7, 0, 0, 0, 5, 0, 0, 0, false, false, false);
			ice1.setDamage(ice1Dam);
			return ice1;
		}
		else if(i==4){
			Magic ice2=new Magic(true, new Color(200, 249, 250), l, 10, 8, 1);
			Damage ice2Dam=new Damage(15, 0, 0, 0, 10, 0, 0, 0, false, false, false);
			ice2.setDamage(ice2Dam);
			return ice2;
		}
		else if(i==5){
			Magic ice3=new Magic(true, new Color(200, 249, 250), l, 20, 15, 1);
			Damage ice3Dam=new Damage(15, 0, 0, 0, 10, 0, 0, 0, false, false, true);
			ice3.setDamage(ice3Dam);
			return ice3;
		}
		else if(i==6){
			Magic solidify=new Magic(true, Color.DARK_GRAY, l, 8, 11, 1);
			Damage solidifyDamage=new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			solidify.setDamage(solidifyDamage);
			return solidify;
		}
		else if(i==7){
			Magic gassify=new Magic(true, Color.LIGHT_GRAY, l, 8, 11, 1);
			Damage gassifyDamage=new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			gassify.setDamage(gassifyDamage);
			return gassify;
		}
		return null;
	}
	//0=basic bow + arrows
	//1=longbow + arrows
	//2=basic crossbow + bolts
	//3=finely crafted crossbow + bolts
	//4=javelins
	//5=throwing knives
	public RangedWeapon constructRangedWeapons(int i, LivingThing l){
		if(i==0){
			RangedWeapon baseBow=new RangedWeapon(true, Color.BLUE, l, 15, 1);
			Damage baseBowDamage=new Damage(7, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			baseBow.setDamage(baseBowDamage);
			return baseBow;
		}
		else if(i==1){
			RangedWeapon longBow=new RangedWeapon(true, Color.BLUE, l, 30, 1);
			Damage longBowDamage=new Damage(15, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			longBow.setDamage(longBowDamage);
			return longBow;
		}
		else if(i==2){
			RangedWeapon crossBow=new RangedWeapon(true, Color.BLUE, l, 20, 1);
			Damage crossBowDamage=new Damage(15, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			crossBow.setDamage(crossBowDamage);
			return crossBow;
		}
		else if(i==3){
			RangedWeapon crossBowPlus=new RangedWeapon(true, Color.BLUE, l, 30, 1);
			Damage crossBowPlusDamage=new Damage(25, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			crossBowPlus.setDamage(crossBowPlusDamage);
			return crossBowPlus;
		}
		else if(i==4){
			RangedWeapon javelin=new RangedWeapon(true, Color.BLUE, l, 10, 1);
			Damage javelinDamage=new Damage(20, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			javelin.setDamage(javelinDamage);
			return javelin;
		}
		else if(i==5){
			RangedWeapon throwingKnives=new RangedWeapon(true, Color.BLUE, l, 15, 1);
			Damage throwingKnivesDamage=new Damage(10, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			throwingKnives.setDamage(throwingKnivesDamage);
			return throwingKnives;
		}
		return null;
	}
	public Weapon constructMeleeWeapons(int i, int damage, LivingThing l){
		if(i==0){
			Weapon sword=new Weapon(true, Color.RED, l);
			Damage swordDamage=new Damage(damage, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			sword.setDamage(swordDamage);
			return sword;
		}
		return null;
	}
		
	
	
}
