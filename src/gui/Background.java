package gui;

import java.awt.Color;

public class Background extends Landscape {

	public Background(Color groundColor, Color airColor, Color topColor, int topHeight, int groundHeight, boolean hasHill) {
		super.setGroundColor(groundColor);
		super.setAirColor(airColor);
		super.setTopColor(topColor);
		super.setTopHeight(topHeight);
		super.setGroundHeight(groundHeight);
		super.setHasHill(hasHill);
	}

}
