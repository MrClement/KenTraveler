package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import world.Grid;

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
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 25;
		c.gridwidth = 100;
		c.fill = GridBagConstraints.HORIZONTAL;
		Random r = new Random();
		for (int i = 0; i < 2500; i++) {
			JPanel panel = new JPanel(true);
			panel.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			frame.getContentPane().add(panel);
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
