package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import world.Grid;

public class GameDisplay implements KeyListener{

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(25, 100, 0, 0));
		frame.setLocationRelativeTo(null);
		initialize(g);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Grid g) {

		Random r = new Random();
		for (int i = 0; i < 2500; i++) {
			JPanel panel = new JPanel(true);
			panel.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			frame.add(panel);
		}

	}

	public void redraw(Grid g) {
		frame.getContentPane().removeAll();
		initialize(g);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
	}
	
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
	}
	
	public void keyTyped(KeyEvent e){
		e.consume();
	}

}
