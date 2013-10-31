package gui;

import java.awt.Color;


/**
 * @author aclement and peeps
 * 
 */
public abstract class Landscape {

	private Color groundColor;
	private Color airColor;
	private Color topColor;
	private int groundHeight;
	private int topHeight;
	private boolean hasHill;

	/**
	 * @return the groundColor
	 */
	public Color getGroundColor() {
		return groundColor;
	}

	/**
	 * @return the airColor
	 */
	public Color getAirColor() {
		return airColor;
	}

	/**
	 * @return the topColor
	 */
	public Color getTopColor() {
		return topColor;
	}

	/**
	 * @param groundColor
	 *            the groundColor to set
	 */
	public void setGroundColor(Color groundColor) {
		this.groundColor = groundColor;
	}

	/**
	 * @param airColor
	 *            the airColor to set
	 */
	public void setAirColor(Color airColor) {
		this.airColor = airColor;
	}

	/**
	 * @param topColor
	 *            the topColor to set
	 */
	public void setTopColor(Color topColor) {
		this.topColor = topColor;
	}

	public int getGroundHeight() {
		return groundHeight;
	}

	public void setGroundHeight(int groundHeight) {
		this.groundHeight = groundHeight;
	}

	public int getTopHeight() {
		return topHeight;
	}

	public void setTopHeight(int topHeight) {
		this.topHeight = topHeight;
	}

	public boolean getHasHill() {
		return hasHill;
	}

	public void setHasHill(boolean hasHill) {
		this.hasHill = hasHill;
	}

}
