package world;

public class Merchant {
	private Forge f;
	public Merchant(){
		
	}
	
	public void buyMagic(int i, Character c){
		Magic m=f.constructMagic(i, c);
		c.addWeapon(m);
		c.addMoney(-20);
		System.out.println("You just bought a:" + m.toString());
	}
	
	public void buyMeleeWeapons(int i, Character c){
		Weapon w=f.constructMeleeWeapons(i, c);
		c.addWeapon(w);
		c.addMoney(-20);
		System.out.println("You just bought a:" + w.toString());
	}
	
	public void buyRangedWeapons(int i, Character c){
		RangedWeapon r=f.constructRangedWeapons(i, c);
		c.addWeapon(r);
		c.addMoney(-20);
		System.out.println("You just bought a:" + r.toString());
	}
}
