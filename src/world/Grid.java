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
		Thing t = gs.remove(gs.returnThings().get(0));
		GridSpace gs2 = grid.get(newLocation);
		gs2.add(t);
		gs.sortArrayOfThings();
		gs2.sortArrayOfThings();
		grid.put(getCharacterLocation(), gs);
		grid.put(newLocation, gs2);
		setCharacterLocation(newLocation);
	}
}
