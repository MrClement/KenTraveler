package world;
import java.util.ArrayList;
/**
 * 
 * @author WesleyDencker
 *
 */
public class GridSpace {
	//tick method to continue checking if things are in space
	
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
	
	public Thing remove(Thing toRemove){
		if (thingsInSpace.remove(toRemove)==true){
			return toRemove;
		}
		else return null;
	}
	
	public void onTick(){
		
	}
	
	
	

}
