package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import world.Grid;
import world.GridSpace;

public class GameDisplay implements KeyListener {

	private JFrame frame;
	private Grid grid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDisplay window = new GameDisplay(new Grid());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameDisplay(Grid g) {
		grid = g;
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
					if (grid.getGrid()
							.get(new Point((int) grid.getCharacterLocation().getX(), (int) grid.getCharacterLocation()
									.getY() + 1)).hasSolid()) {
						grid.moveCharacter(0, -4);
					}
				} else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
					grid.moveCharacter(-1, 0);
				} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
					grid.moveCharacter(0, 1);
				} else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
					grid.moveCharacter(1, 0);
				} else {

				}
				// grid.moveCharacter();

				redraw(grid);
				System.out.println(e.getKeyCode());
			}
		});
		frame.setBounds(200, 200, 1200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.setLocationRelativeTo(null);
		initialize(g);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Grid g) {
		Random r = new Random();
		HashMap<Point, GridSpace> grid = g.getGrid();
		for (int i = 0; i < 100; i++) {

			for (int j = 0; j < 25; j++) {
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = i;
				c.gridy = j;
				c.fill = GridBagConstraints.HORIZONTAL;
				JPanel panel = new JPanel(true);
				panel.setBackground(grid.get(new Point(i, j)).getColor());
				frame.getContentPane().add(panel, c);
			}

		}
	}

	public void redraw(Grid g) {
		frame.getContentPane().removeAll();
		initialize(g);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
	}

	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
