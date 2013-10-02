/**
 * 
 */
package world;

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
	public Magic constructMagic(int i, LivingThing l){
		if(i==0){
			Magic fire1=new Magic(true, l, 5, 3, 1);
			Damage fire1Dam=new Damage(10, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire1.setDamage(fire1Dam);
			return fire1;
			
		}
		else if(i==1){
			Magic fire2=new Magic(true, l, 10, 8, 1);
			Damage fire2Dam=new Damage(20, 0, 0, 0, 0, 0, 0, 0, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		}
		else if(i==2){
			Magic fire2=new Magic(true, l, 20, 15, 1);
			Damage fire2Dam=new Damage(20, 0, 0, 0, 0, 0, 0, 7, false, false, false);
			fire2.setDamage(fire2Dam);
			return fire2;
		}
		else if(i==3){
			Magic ice1=new Magic(true, l, 5, 3, 1);
			Damage ice1Dam=new Damage(7, 0, 0, 0, 5, 0, 0, 0, false, false, false);
			ice1.setDamage(ice1Dam);
			return ice1;
		}
		else if(i==4){
			Magic ice2=new Magic(true, l, 10, 8, 1);
			Damage ice2Dam=new Damage(15, 0, 0, 0, 10, 0, 0, 0, false, false, false);
			ice2.setDamage(ice2Dam);
			return ice2;
		}
		else if(i==5){
			Magic ice3=new Magic(true, l, 20, 15, 1);
			Damage ice3Dam=new Damage(15, 0, 0, 0, 10, 0, 0, 0, false, false, true);
			ice3.setDamage(ice3Dam);
			return ice3;
		}
		else if(i==6){
			Magic solidify=new Magic(true, l, 8, 11, 1);
			Damage solidifyDamage=new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			solidify.setDamage(solidifyDamage);
			return solidify;
		}
		else if(i==7){
			Magic gassify=new Magic(true, l, 8, 11, 1);
			Damage gassifyDamage=new Damage(0, 0, 0, 0, 0, 0, 0, 0, true, false, false);
			gassify.setDamage(gassifyDamage);
			return gassify;
		}
		return 
	}
	
}
