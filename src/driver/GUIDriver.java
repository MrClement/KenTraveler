package driver;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;

import world.Character;
import world.Enemy;
import world.Grid;
import world.GridSpace;
import world.LivingThing;
import world.Terrain;
import world.Thing;
import world.World;

public class GUIDriver {

	private static Grid g;
	private static long gravityRate;
	private static int lastKey;
	private static long hangTime;
	private static long value;
	private static boolean spaceDown = false;
	private static int stage = 1;

	public static void main(String[] args) {

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

		// Variables for counting frames per seconds

		int fps = 0;
		int frames = 0;
		long totalTime = 0;
		long gravityTime = 0;
		long enemyDamageTime = 0;
		hangTime = 500;
		gravityRate = 300;
		value = gravityRate + hangTime;
		long curTime = System.currentTimeMillis();
		long lastTime = curTime;

		g = new Grid(0);

		g.makeDefaultGrid();
		stage = 1;

		app.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
					g.retractWeapon(lastKey);
					if (g.getGrid()
							.get(new Point((int) g.getCharacterLocation().getX(),
									(int) g.getCharacterLocation().getY() + 1)).hasSolid()) {
						g.moveCharacter(0, -1, lastKey);
						g.moveCharacter(0, -1, lastKey);
						g.moveCharacter(0, -1, lastKey);
						g.moveCharacter(0, -1, lastKey);
						value = gravityRate + hangTime;

					}
				} else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
					g.moveCharacter(-1, 0, lastKey);
					lastKey = KeyEvent.VK_A;
				} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
					g.moveCharacter(0, 1, lastKey);
				} else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
					g.moveCharacter(1, 0, lastKey);
					lastKey = KeyEvent.VK_D;
				} else if (keyCode == KeyEvent.VK_SPACE) {
					if (!spaceDown) {
						spaceDown = true;
						g.useWeapon(lastKey);
					}

				} else if (keyCode == KeyEvent.VK_P) {
					Random r = new Random();
					String name = "Yo Mama";
					Color c = Color.ORANGE;
					Point p = g.findValidEnemyLocation();
					if (p != null) {
						g.spawnNewEnemy(p, new Enemy(true, c, name, 10, 10, 10));
					} else {
						System.out.println("Could not spawn a new enemy.");
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_SPACE) {
					g.retractWeapon(lastKey);
					spaceDown = false;
				}
			}
		});

		while (true) {
			try {
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				gravityTime += curTime - lastTime;
				enemyDamageTime += curTime-lastTime;
				if (gravityTime > value) {
					value += gravityRate;
					g.moveCharacter(0, 1, lastKey);
					g.moveRangedWeapon();
					if (g.getEnemyLocation() != null) {

						Point p = g.getEnemyLocation();
						Point q = new Point((int) g.getEnemyLocation().getX(), (int) g.getEnemyLocation().getY() + 1);
						GridSpace gs = g.getGrid().get(q);
						
						if (g.getEnemyLocation().getX() - g.getCharacterLocation().getX() > 0) {
							g.moveEnemy(-1, 0);
						} else {
							g.moveEnemy(1, 0);
						}
						
						if(p.equals(g.getEnemyLocation())){
							
							if (gs.returnThings().size() > 0) {
								if (gs.hasSolid()) {
									if (gs.returnWeapons().size() == 0) {
										g.moveEnemy(0, -1);
										g.moveEnemy(0, -1);
										g.moveEnemy(0, -1);
										g.moveEnemy(0, -1);
									} else {
										for (LivingThing e : gs.returnLivingThings()) {
											if (e.getSolid()) {
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
											}
										}
										for (Terrain t : gs.returnTerrain()) {
											if (t.getSolid()) {
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
												g.moveEnemy(0, -1);
											}
										}
									}
								}
							}
							
						}

						g.moveEnemy(0, 1);
					}
					if (gravityTime > 4 * gravityRate + hangTime) {
						gravityTime = 0;
						value = gravityRate + hangTime;
					}
				}
				if (enemyDamageTime > 500){
					
				}
				if (totalTime > 1000) {

					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}
				++frames;

				// clear back buffer...
				if (g.getCharacterLocation().getX() >= 100) {
					HashMap<Point, GridSpace> grid = g.getGrid();
					Point oldLocation = g.getCharacterLocation();
					Character c = grid.get(oldLocation).returnCharacter();
					World w = new World();
					int killed = g.getNumKilled();
					g = w.drawWorld(1, killed);
					stage++;
					grid = g.getGrid();
					g.setNumKilled(killed);
					ArrayList<Thing> t = new ArrayList<Thing>();
					t.add(c);
					GridSpace gs = new GridSpace(t);
					gs.sortArrayOfThings();
					grid.put(new Point(0, (int) oldLocation.getY()), gs);
					g.setCharacterLocation(new Point(0, (int) oldLocation.getY()));
				}
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

				// display frames per second...

				g2d.setFont(new Font("Courier New", Font.PLAIN, 12));
				g2d.setColor(Color.GREEN);
				g2d.drawString(String.format("FPS: %s", fps), 20, 20);
				g2d.drawString(String.format("Stage: %s", stage), 100, 20);
				g2d.drawString(String.format("Enemies killed: %s", g.getNumKilled()), 180, 20);
				switch(g.getGrid().get(g.getCharacterLocation()).returnCharacter().getHp()){
				case 20: g2d.drawString("Health: * * * *", 320, 20); break;
				case 15: g2d.drawString("Health: * * * _", 320, 20); break;
				case 10: g2d.drawString("Health: * * _ _", 320, 20); break;
				case 5: g2d.drawString("Health: * _ _ _", 320, 20); break;
				default: g2d.drawString("Health: _ _ _ _", 320, 20); break;
				}

				// Blit image and flip...

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
