package driver;

import gui.GameDisplay;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import world.Character;
import world.Grid;
import world.GridSpace;
import world.LivingThing;
import world.Terrain;
import world.Thing;
import world.Weapon;

public class TestDriver {

	public static void main(String[] args) {

		Grid g = new Grid();
		HashMap<Point, GridSpace> grid = g.getGrid();
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
		System.out.println(test.returnThings());
		test.sortArrayOfThings();
		System.out.println(test.returnThings());
		grid.put(new Point(15, 15), test);
		g.setCharacterLocation(new Point(15, 15));
		things = new ArrayList<Thing>();
		things.add(new Weapon(true, Color.RED, c));
		test = new GridSpace(things);
		test.sortArrayOfThings();
		grid.put(new Point(20, 21), test);
		
		for(int i = 0; i < 4; i++){
		
		things = new ArrayList<Thing>();
		things.add(new Terrain(true, Color.BLACK));
		test = new GridSpace(things);
		test.sortArrayOfThings();
		grid.put(new Point(50, 21-i), test);
		
		}
		
		for(int i = 0; i < 8; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(51, 21-i), test);
			
		}
		
		for(int i = 0; i < 12; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(52, 21-i), test);
			
		}
		
		for(int i = 0; i < 16; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(53, 21-i), test);
			
		}
		
		for(int i = 0; i < 12; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(54, 21-i), test);
			
		}
		
		for(int i = 0; i < 8; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(55, 21-i), test);
			
		}
		
		for(int i = 0; i < 4; i++){
			
			things = new ArrayList<Thing>();
			things.add(new Terrain(true, Color.BLACK));
			test = new GridSpace(things);
			test.sortArrayOfThings();
			grid.put(new Point(56, 21-i), test);
			
		}
		
		GameDisplay display = new GameDisplay(g);
		display.getFrame().setVisible(true);
		long s = System.currentTimeMillis();
		while (true) {
			if ((System.currentTimeMillis() - s) >= 1000) {
				g.moveCharacter(0, 1);
				g.moveCharacter(0, 1);
				display.redraw(g);
				s = System.currentTimeMillis();
			}

		}

	}
}
