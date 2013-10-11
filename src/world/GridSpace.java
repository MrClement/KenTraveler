package world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author WesleyDencker
 * 
 */
public class GridSpace {

	private ArrayList<Thing> thingsInSpace;
	private Color color;

	/**
	 * This is the GridSpace constructor, which constructs a GridSpace object
	 * with an initial set of Thing objects.
	 * 
	 * @param initialInGridSpace
	 *            is an ArrayList of Things that will initially be placed in the
	 *            Grid.
	 */
	public GridSpace(ArrayList<Thing> initialInGridSpace) {
		thingsInSpace = initialInGridSpace;
		Random r = new Random();
		if (initialInGridSpace.size() > 0) {
			color = thingsInSpace.get(0).getColor();
		} else {
			color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		}
	}

	/**
	 * This method returns all the Thing objects in the GridSpace.
	 * 
	 * @return an ArrayList of all the Thing objects in the GridSpace.
	 */
	public ArrayList<Thing> returnThings() {
		return thingsInSpace;
	}

	/**
	 * This method returns all the LivingThing objects in the GridSpace.
	 * 
	 * @return an ArrayList of all the LivingThing objects in the GridSpace.
	 */
	public ArrayList<LivingThing> returnLivingThings() {
		ArrayList<LivingThing> toReturn = new ArrayList<LivingThing>();
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof LivingThing) {
				toReturn.add((LivingThing) thingsInSpace.get(i));
			}
		}
		return toReturn;
	}

	public boolean hasSolid() {
		for (Thing t : thingsInSpace) {
			if (t.getSolid()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns all the Weapon objects in the GridSpace.
	 * 
	 * @return an ArrayList of all the Weapon objects in the GridSpace.
	 */
	public ArrayList<Weapon> returnWeapons() {
		ArrayList<Weapon> toReturn = new ArrayList<Weapon>();
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof Weapon) {
				toReturn.add((Weapon) thingsInSpace.get(i));
			}
		}
		return toReturn;
	}

	/**
	 * This method adds a Thing object to the GridSpace.
	 * 
	 * @param toAdd
	 *            is the Thing object to be added to the GridSpace
	 */
	public void add(Thing toAdd) {
		System.out.println("toAdd " + toAdd);
		System.out.println(thingsInSpace);
		thingsInSpace.add(toAdd);
		sortArrayOfThings();
	}

	/**
	 * This method removes the first instance of a Thing object from a
	 * GridSpace.
	 * 
	 * @param toRemove
	 *            is a Thing object that needs to be removed.
	 * @return the object that was removed.
	 */
	public Thing remove(Thing toRemove) {
		if (thingsInSpace.remove(toRemove) == true) {
			return toRemove;
		} else
			return null;
	}

	/**
	 * This method applies damage to all LivingThing objects that are in the
	 * GridSpace with a Weapon object, removes all LivingThings that have died,
	 * and moves anything that needs to be moved into a different GridSpace.
	 * 
	 * @param toMove
	 *            is an ArrayList of Thing objects that are to moved to a
	 *            different GridSpace, whose indices correspond with the
	 *            destinations parameter.
	 * @param destinations
	 *            is an ArrayList of GridSpaces to which the Thing objects in
	 *            the toMove parameter will move.
	 */
	public void onTick(ArrayList<Thing> toMove, ArrayList<GridSpace> destinations) {
		// checks if there is a weapon modifier in the grid space, if so,
		// applies damage
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof Weapon) {
				for (int j = 0; j < thingsInSpace.size(); j++) {
					if (thingsInSpace.get(j) instanceof LivingThing) {
						((Weapon) thingsInSpace.get(i)).doDamage((LivingThing) thingsInSpace.get(j));
					}
				}
			}
		}

		// removes livingThings that have died
		ArrayList<LivingThing> livingThings = returnLivingThings();
		for (int k = 0; k < livingThings.size(); k++) {
			if (livingThings.get(k).getHp() <= 0) {
				while (remove(livingThings.get(k)) != null) {
					remove(livingThings.get(k));
				}
			}
		}

		// anything that needs to move is moved
		for (int l = 0; l < toMove.size(); l++) {
			destinations.get(l).add(remove(toMove.get(l)));
		}
	}

	public void sortArrayOfThings() {
		ArrayList<Thing> sorted = new ArrayList<Thing>(thingsInSpace.size());
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof Character) {
				sorted.add(thingsInSpace.remove(i));
			}
		}
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof LivingThing) {
				sorted.add(thingsInSpace.remove(i));
			}
		}
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof Weapon) {
				sorted.add(thingsInSpace.remove(i));
			}
		}
		for (int i = 0; i < thingsInSpace.size(); i++) {
			if (thingsInSpace.get(i) instanceof Thing) {
				sorted.add(thingsInSpace.remove(i));
			}
		}
		thingsInSpace = sorted;
		if (thingsInSpace.size() > 0) {
			color = thingsInSpace.get(0).getColor();
		} else {
			color = Color.WHITE;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
