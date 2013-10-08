package driver;

import gui.GameDisplay;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import world.Character;
import world.Grid;
import world.GridSpace;
import world.LivingThing;
import world.Thing;
import world.Weapon;

public class TestDriver {

	public static void main(String[] args) {

		Grid g = new Grid();
		HashMap<Point, GridSpace> grid = g.getGrid();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 25; j++) {
				GridSpace d = new GridSpace(null);
				if (j >= 22) {
					d.setColor(Color.GREEN);
				} else if (j > 2) {
					d.setColor(Color.CYAN);
				} else {
					d.setColor(Color.DARK_GRAY);
				}
				grid.put(new Point(i, j), d);
			}
		}
		ArrayList<Thing> things = new ArrayList<Thing>();
		Character c = new Character(true, Color.BLUE);
		things.add(new Weapon(true, Color.RED, c));
		things.add(c);
		things.add(new LivingThing(true, Color.YELLOW));
		GridSpace test = new GridSpace(things);
		System.out.println(test.returnThings());
		test.sortArrayOfThings();
		System.out.println(test.returnThings());
		grid.put(new Point(5, 5), test);
		GameDisplay display = new GameDisplay(g);
		display.getFrame().setVisible(true);
		long s = System.currentTimeMillis();
		while (true) {
			if ((System.currentTimeMillis() - s) >= 1000) {
				display.redraw(g);
				s = System.currentTimeMillis();
			}

		}

	}
}
