package world;

/**
 * @author King
 *
 */
public abstract class Thing {

	private boolean solid;
	
	/**
	 * @param b and array of grid spaces
	 */
	public Thing(boolean b)
	{
		solid = b;
	}
	
	/**
	 * returns array of gridspaces
	 */
	public getPosition()
	{
		
	}
	
	/**
	 * @return whether the object is able to be walked through
	 */
	public boolean getSolid()
	{
		return solid;
		
	}
	
}
