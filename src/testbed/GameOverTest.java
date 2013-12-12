package testbed;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import world.Grid;
import world.GridSpace;
import world.Terrain;
import world.Thing;

public class GameOverTest {

	public static void main(String[] args) {
		Grid g = new Grid(0);
		g.makeDefaultGrid();

		HashMap<Point, GridSpace> grid2 = g.getGrid();
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 25; j++) {
				GridSpace d = new GridSpace(new ArrayList<Thing>());
				d.add(new Terrain(true, Color.BLACK));
				d.sortArrayOfThings();
				grid2.put(new Point(i, j), d);
			}
		}

		// height top:9 bottom:15
		// width left:14 right:20

		// O - left
		int y = 15;
		for (int x = 53; x < 60; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 9;
		for (int x = 53; x < 60; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 53;
		for (int x = 9; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 59;
		for (int x = 9; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		// V
		y = 61;
		for (int x = 9; x < 13; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 67;
		for (int x = 9; x < 13; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 61;
		for (int x = 13; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y + x - 12, x), d);
		}
		y = 67;
		for (int x = 13; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y - x + 12, x), d);
		}
		// E
		y = 69;
		for (int x = 9; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 9;
		for (int x = 69; x < 76; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 12;
		for (int x = 69; x < 76; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 15;
		for (int x = 69; x < 76; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		// R
		y = 12;
		for (int x = 77; x < 84; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 9;
		for (int x = 77; x < 84; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(x, y), d);
		}
		y = 77;
		for (int x = 9; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 83;
		for (int x = 9; x < 13; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y, x), d);
		}
		y = 80;
		for (int x = 13; x < 16; x++) {
			GridSpace d = new GridSpace(new ArrayList<Thing>());
			d.add(new Terrain(true, Color.WHITE));
			d.sortArrayOfThings();
			grid2.put(new Point(y + x - 12, x), d);
		}

		// Create game window...

		JFrame app = new JFrame();
		app.setIgnoreRepaint(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create canvas for painting...

		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(1200, 480);

		// Add canvas to game window...

		app.add(canvas);
		app.pack();
		app.setVisible(true);

		// Create BackBuffer...

		canvas.createBufferStrategy(2);
		BufferStrategy buffer = canvas.getBufferStrategy();

		// Get graphics configuration...

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();

		// Create off-screen drawing surface

		BufferedImage bi = gc.createCompatibleImage(1200, 480);

		// Objects needed for rendering...

		Graphics graphics = null;
		Graphics2D g2d = null;
		Color background = Color.BLACK;

		while (true) {
			try {

				g2d = bi.createGraphics();
				g2d.setColor(background);
				g2d.fillRect(0, 0, 639, 479);

				HashMap<Point, GridSpace> grid = g.getGrid();
				for (int i = 0; i < 100; i++) {

					for (int j = 0; j < 25; j++) {
						g2d.setColor(grid.get(new Point(i, j)).getColor());
						g2d.fillRect(i * 10, j * 10, 10, 10);

					}

				}

				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi, 0, 0, null);
				if (!buffer.contentsLost()) {

					buffer.show();
				}
				// Let the OS have a little time...
				Thread.yield();

			} finally {

				// release resources
				if (graphics != null)
					graphics.dispose();
				if (g2d != null)
					g2d.dispose();

			}
		}

	}

}
