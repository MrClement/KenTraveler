package driver;

import gui.GameDisplay;
import world.Grid;

public class Driver {

	public static void main(String[] args) {
		Grid g = new Grid();
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
