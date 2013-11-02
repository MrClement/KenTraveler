package world;

import gui.Background;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author King
 * 
 */
public class World {

	private ArrayList<Background> BackGrounds;

	/**
	 * Constructor of world
	 */
	public World() {
	}

	/**
	 * @param i
	 *            . drawWorld has a seed where it will call a specific array of
	 *            Backgrounds, it then checks if the the character is at the end
	 *            of the map and if it is it moves to the next background
	 */
	public Grid drawWorld(int i) {
		ArrayList<Background> BackGrounds = new ArrayList<Background>();
		if (i == 1) {
			BackGrounds = this.world1();
		}
		// Need to add check to see if the character is at the end of the map,
		// if it is it calls the next background in the loop
		Background a = BackGrounds.get(0);

		Grid g = new Grid();
		HashMap<Point, GridSpace> grid = g.getGrid();
		for (int d = 0; i < 100; d++) {
			for (int j = 0; j < 25; j++) {
				GridSpace f = new GridSpace(new ArrayList<Thing>());
				if (j >= 22) {
					f.add(new Terrain(true, a.getGroundColor()));
				} else if (j > 2) {

				} else {
					f.add(new Terrain(true, a.getTopColor()));
				}
				// needs to check if there is a hill in the background then call
				// the draw hill method

			}
		}

		return g;

	}

	/**
	 * Will draw a hill at a random place on the map
	 */
	public void drawHill() {
		// needs to call a random point in between and add a hhill
	}

	/**
	 * @return World 1 traits will be stored here
	 */
	public ArrayList<Background> world1() {
		Color ground = new Color(0);

		ArrayList<Background> BackGrounds = new ArrayList<Background>();

		Background a = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, true);
		BackGrounds.add(a);
		Background b = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, false);
		BackGrounds.add(b);
		Background c = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, true);
		BackGrounds.add(c);
		return BackGrounds;
	}

	/**
	 * @return World 2 traits will be stored here
	 */
	public ArrayList<Background> world2() {
		Color ground = new Color(0);

		ArrayList<Background> BackGrounds = new ArrayList<Background>();

		Background a = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, true);
		BackGrounds.add(a);
		Background b = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, false);
		BackGrounds.add(b);
		Background c = new Background(ground.GREEN, ground.CYAN, ground.darkGray, 2, 22, true);
		BackGrounds.add(c);
		return BackGrounds;
	}

}
