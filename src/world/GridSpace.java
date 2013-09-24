package world;
import java.util.ArrayList;
/**
 * 
 * @author WesleyDencker
 *
 */
public class GridSpace {
	
	private ArrayList<Thing> thingsInSpace;	
	
	public GridSpace(ArrayList<Thing> initialInGridSpace){
		thingsInSpace = initialInGridSpace;
	}
	
	public ArrayList<Thing> returnThings(){
		return thingsInSpace;
	}
	public ArrayList<LivingThing> returnLivingThings(){
		ArrayList<LivingThing> toReturn = new ArrayList<LivingThing>();
		for (int i=0; i< thingsInSpace.size(); i++){
			if (thingsInSpace.get(i) instanceof LivingThing){
				toReturn.add((LivingThing) thingsInSpace.get(i));
			}
		}
		return toReturn;
	}
	
	public void add(Thing toAdd){
		thingsInSpace.add(toAdd);
	}
	
	public Thing remove(Thing toRemove){
		if (thingsInSpace.remove(toRemove)==true){
			return toRemove;
		}
		else return null;
	}
	
	
	public void onTick(ArrayList<Thing> toMove, ArrayList<GridSpace> destinations){
		//checks if there is a weapon modifier in the grid space, if so, applies damage
		//to all living things within the space
		for (int i = 0; i < thingsInSpace.size(); i++){
			if (thingsInSpace.get(i) instanceof Weapon){
				for (int j = 0; j < thingsInSpace.size(); j++){
					if (thingsInSpace.get(j) instanceof LivingThing){
						((Weapon) thingsInSpace.get(i)).doDamage(this);
					}
				}
			}
		}
		
		//removes livingThings that have died
		ArrayList<LivingThing> livingThings = returnLivingThings();
		for (int k = 0; k < livingThings.size(); k++){
			if (livingThings.get(k).getHp() <= 0){
				while (remove(livingThings.get(k)) != null){
					remove(livingThings.get(k));
				}
			}
		}
		
		//anything that needs to move is moved
		for (int l = 0; l < toMove.size(); l++){
			destinations.get(l).add(remove(toMove.get(l)));
		}
	}
	
	
	

}
