package driver;

import world.Grid;
import gui.GameDisplay;

public class Driver {

	public static void main(String[] args) {
		Grid g = new Grid();
		GameDisplay display = new GameDisplay(g);
	}

}
