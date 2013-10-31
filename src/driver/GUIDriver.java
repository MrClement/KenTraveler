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
import java.util.HashMap;

import javax.swing.JFrame;

import world.Grid;
import world.GridSpace;

public class GUIDriver {

	private static Grid g;

	public static void main(String[] args) {

		// Create game window...

		JFrame app = new JFrame();
		app.setIgnoreRepaint(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create canvas for painting...

		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(640, 480);

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

		BufferedImage bi = gc.createCompatibleImage(640, 480);

		// Objects needed for rendering...

		Graphics graphics = null;
		Graphics2D g2d = null;
		Color background = Color.BLACK;

		// Variables for counting frames per seconds

		int fps = 0;
		int frames = 0;
		long totalTime = 0;
		long curTime = System.currentTimeMillis();
		long lastTime = curTime;

		g = new Grid();
		g.makeDefaultGrid();

		app.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int lastKeyPressed = KeyEvent.VK_D;
				if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
					if (g.getGrid()
							.get(new Point((int) g.getCharacterLocation().getX(),
									(int) g.getCharacterLocation().getY() + 1)).hasSolid()) {
						g.moveCharacter(0, -1);
						g.moveCharacter(0, -1);
						g.moveCharacter(0, -1);
						g.moveCharacter(0, -1);
					}
				} else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
					lastKeyPressed=KeyEvent.VK_A;
					g.moveCharacter(-1, 0);
				} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
					g.moveCharacter(0, 1);
				} else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
					lastKeyPressed=KeyEvent.VK_D;
					g.moveCharacter(1, 0);
				} else if (keyCode == KeyEvent.VK_SPACE) {
					g.useWeapon(lastKeyPressed);

				}

				System.out.println(e.getKeyCode());
			}
		});

		while (true) {
			try {
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				if (totalTime > 1000) {

					g.moveCharacter(0, 1);
					g.moveCharacter(0, 1);

					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}
				++frames;

				// clear back buffer...

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
