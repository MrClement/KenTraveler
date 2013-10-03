package driver;

import gui.GameDisplay;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;

import world.Grid;
import world.GridSpace;

public class Driver {

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
