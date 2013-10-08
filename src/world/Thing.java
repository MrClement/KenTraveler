package world;

import java.awt.Color;
import java.awt.Point;

/**
 * @author King
 * 
 */
public abstract class Thing {

	private boolean solid;
	private Color color;

	/**
	 * @param b
	 *            and array of grid spaces
	 * @param c
	 *            the color of the Thing object
	 */
	public Thing(boolean b, Color c) {
		solid = b;
		color = c;
	}

	/**
	 * returns array of gridspaces
	 */
	public Point getPosition() {
		return null;
	}

	public Point[] getSize() {
		return null;
	}

	/**
	 * @return whether the object is able to be walked through
	 */
	public boolean getSolid() {
		return solid;

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
