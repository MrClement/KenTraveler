package world;

import java.awt.Point;
import java.util.HashMap;

/**
 * @author aclement
 * 
 */
public class Grid {

	private HashMap<Point, GridSpace> grid;

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

}
