package gui;

import java.awt.Color;


/**
 * @author WesleyDencker
 *
 */
public class Background extends Landscape {


	public Background(Color groundColor, Color airColor, Color topColor, int topHeight, int groundHeight, boolean hasHill) {
		super.setGroundColor(groundColor);
		super.setAirColor(airColor);
		super.setTopColor(topColor);
		super.setTopHeight(topHeight);
		super.setGroundHeight(groundHeight);
		super.setHasHill(hasHill);
	}
	
	public Hill getHill(){
		if (super.getHasHill()){
			return (new Hill(0, 0, 0, true));
		}
		else return null;
	}
		

}
