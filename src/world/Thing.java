package world;

import java.awt.Point;

/**
 * @author King
 * 
 */
public abstract class Thing {

	private boolean solid;

	/**
	 * @param b
	 *            and array of grid spaces
	 */
	public Thing(boolean b) {
		solid = b;
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

}
