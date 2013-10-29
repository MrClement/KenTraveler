package world;

import java.awt.Point;
import java.util.HashMap;

/**
 * @author aclement
 * 
 */
public class Grid {

	private HashMap<Point, GridSpace> grid;
	private Point characterLocation;

	/**
	 * 
	 */
	public Grid() {
		setGrid(new HashMap<Point, GridSpace>());
	}

	public HashMap<Point, GridSpace> getGrid() {
		return grid;
	}

	public void setGrid(HashMap<Point, GridSpace> grid) {
		this.grid = grid;
	}

	public Point getCharacterLocation() {
		return characterLocation;
	}

	public void setCharacterLocation(Point characterLocation) {
		this.characterLocation = characterLocation;
	}

	public void moveCharacter(int x, int y) {
		Point newLocation = new Point((int) getCharacterLocation().getX() + x, (int) getCharacterLocation().getY() + y);
		GridSpace gs = grid.get(getCharacterLocation());
		GridSpace gs2 = grid.get(newLocation);

		// Can move
		// gs2.returnThings().size == 0
		// !gs2.hasSolid()
		// gs2.returnWeapons.size() !=0 && gs2.getLivingThings() == 0
		// gs2.getLivingThings() //iterate over array list checking that
		// !isSolid

		if (gs2.returnThings().size() > 0) {
			if (gs2.hasSolid()) {
				if (gs2.returnWeapons().size() == 0) {
					return;
				} else {
					for (LivingThing e : gs2.returnLivingThings()) {
						if (e.getSolid()) {
							return;
						}
					}
					for (Terrain t : gs2.returnTerrain()) {
						if (t.getSolid()) {
							return;
						}
					}
				}
			}
		}
		Thing t = gs.remove(gs.returnThings().get(0));
		gs2.add(t);
		gs.sortArrayOfThings();
		gs2.sortArrayOfThings();
		grid.put(getCharacterLocation(), gs);
		grid.put(newLocation, gs2);
		setCharacterLocation(newLocation);

	}
	public void useWeapon(){
		Point charLoc=new Point(this.getCharacterLocation());
		if(!(grid.get(charLoc).returnCharacter().getWeapon() instanceof RangedWeapon)){
			GridSpace target;
		}
		
	}
}
