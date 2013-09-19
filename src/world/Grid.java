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
		grid = new HashMap<Point, GridSpace>();
	}

}
