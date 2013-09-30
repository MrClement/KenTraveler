package driver;

public class Driver {

	public static void main(String[] args) {
		// Grid g = new Grid();
		// GameDisplay display = new GameDisplay(g);
		long s = System.currentTimeMillis();
		while (true) {
			if ((System.currentTimeMillis() - s) >= 1000) {
				// display.redraw(g);
				System.out.println(s);
				s = System.currentTimeMillis();
			}
		}
	}

}
