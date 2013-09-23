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
	
	private ArrayList<Thing> returnThings(){
		return thingsInSpace;
	}
	
	private Thing remove(Thing toRemove){
		if (thingsInSpace.remove(toRemove)==true){
			return toRemove;
		}
		else return null;
	}
	
	private void onTick(){
		
	}
	
	
	

}
