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
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
		frame.setBounds(100, 100, 450, 300);
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
