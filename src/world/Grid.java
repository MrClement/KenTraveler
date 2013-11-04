package world;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author aclement
 * 
 */
public class Grid {

	private HashMap<Point, GridSpace> grid;
	private Point characterLocation;

	/**
	 * 
	 */
	public Grid() {
		setGrid(new HashMap<Point, GridSpace>());
	}

	public HashMap<Point, GridSpace> getGrid() {
		return grid;
	}

	public void setGrid(HashMap<Point, GridSpace> grid) {
		this.grid = grid;
	}

	public Point getCharacterLocation() {
		return characterLocation;
	}

	public void setCharacterLocation(Point characterLocation) {
		this.characterLocation = characterLocation;
	}

	public void moveCharacter(int x, int y) {
		Point newLocation = new Point((int) getCharacterLocation().getX() + x, (int) getCharacterLocation().getY() + y);
		GridSpace gs = grid.get(getCharacterLocation());
		GridSpace gs2 = grid.get(newLocation);

		// Can move
		// gs2.returnThings().size == 0
		// !gs2.hasSolid()
		// gs2.returnWeapons.size() !=0 && gs2.getLivingThings() == 0
		// gs2.getLivingThings() //iterate over array list checking that
		// !isSolid

		if (gs2.returnThings().size() > 0) {
			if (gs2.hasSolid()) {
				if (gs2.returnWeapons().size() == 0) {
					return;
				} else {
					for (LivingThing e : gs2.returnLivingThings()) {
						if (e.getSolid()) {
							return;
						}
					}
					for (Terrain t : gs2.returnTerrain()) {
						if (t.getSolid()) {
							return;
						}
					}
				}
			}
		}
		Thing t = gs.remove(gs.returnThings().get(0));
		gs2.add(t);
		gs.sortArrayOfThings();
		gs2.sortArrayOfThings();
		grid.put(getCharacterLocation(), gs);
		grid.put(newLocation, gs2);
		setCharacterLocation(newLocation);

	}

	public void makeDefaultGrid() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 25; j++) {
				GridSpace d = new GridSpace(new ArrayList<Thing>());
				if (j >= 22) {
					d.add(new Terrain(true, Color.GREEN));
				} else if (j > 2) {

				} else {
					d.add(new Terrain(true, Color.DARK_GRAY));
				}
				d.sortArrayOfThings();
				grid.put(new Point(i, j), d);
			}
		}
		ArrayList<Thing> things = new ArrayList<Thing>();
		Character c = new Character(true, Color.BLUE);
		things.add(new Weapon(true, Color.RED, c));
		things.add(c);
		things.add(new LivingThing(false, Color.YELLOW));
		GridSpace test = new GridSpace(things);
		test.sortArrayOfThings();
		grid.put(new Point(15, 15), test);
		setCharacterLocation(new Point(15, 15));
		things = new ArrayList<Thing>();
		things.add(new Weapon(true, Color.RED, c));
		test = new GridSpace(things);
		test.sortArrayOfThings();
		grid.put(new Point(20, 21), test);
	}

	public void useWeapon(int lastKeyPressed) {
		int dir=1;
		Point charLoc = new Point(this.getCharacterLocation());
		if (!(grid.get(charLoc).returnCharacter().getWeapon() instanceof RangedWeapon)) {
			if(lastKeyPressed == KeyEvent.VK_A){
				dir=-1;
			}
			else if(lastKeyPressed == KeyEvent.VK_D){
				dir=1;
			}
			Point side=new Point((int)(getCharacterLocation().getX()+dir), (int)getCharacterLocation().getY());
			GridSpace target=grid.get(side);
			
			target.add(grid.get(charLoc).returnCharacter().getWeapon());
			target.sortArrayOfThings();
			
		}
		else{
			if(lastKeyPressed == KeyEvent.VK_A){
				dir=-1;
			}
			else if(lastKeyPressed == KeyEvent.VK_D){
				dir=1;
			}
			Point side=new Point((int)(getCharacterLocation().getX()+dir), (int)getCharacterLocation().getY());
			GridSpace target=grid.get(side);
			RangedWeapon newWeapon=(RangedWeapon)grid.get(charLoc).returnCharacter().getWeapon();
			newWeapon.setCurrentSpeed(newWeapon.getSpeed()*dir);
			target.add(newWeapon);
			target.sortArrayOfThings();
		}
		
	}
	public void retractWeapon(int lastKeyPressed){
		int dir=1;
		Point charLoc = new Point(this.getCharacterLocation());
		if (!(grid.get(charLoc).returnCharacter().getWeapon() instanceof RangedWeapon)) {
			if(lastKeyPressed == KeyEvent.VK_A){
				dir=-1;
			}
			else if(lastKeyPressed == KeyEvent.VK_D){
				dir=1;
			}
			Point side=new Point((int)(getCharacterLocation().getX()+dir), (int)getCharacterLocation().getY());
			GridSpace target=grid.get(side);
			target.remove(grid.get(charLoc).returnCharacter().getWeapon());
			target.sortArrayOfThings();
		}
	}
}
