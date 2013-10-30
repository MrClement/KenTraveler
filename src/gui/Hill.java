package gui;
import java.util.Random;

/**
 * @author WesleyDencker
 *
 */
public class Hill {
	private int hillHeight;
	private int stepHeight;
	private int finishHeight;
	private int startingLocation;
	private int width;
	
	public Hill(int hillHeight, int stepHeight, int startingLocation, boolean randomize){
		if (randomize){
			Random r = new Random();
			hillHeight = r.nextInt(16)+5;
			stepHeight = r.nextInt(3)+2;
			startingLocation = r.nextInt(71)+10;
		}
		else{
			this.setHillHeight(hillHeight);
			this.setStepHeight(stepHeight);
			this.setStartingLocation(startingLocation);
		}
		finishHeight = hillHeight % stepHeight;
		if (finishHeight == 0){
			setWidth(((hillHeight/stepHeight) *2) -1);
		}else{
			setWidth((((hillHeight/stepHeight) +1) *2) -1);
		}
		
	}

	public int getHillHeight() {
		return hillHeight;
	}

	public void setHillHeight(int hillHeight) {
		this.hillHeight = hillHeight;
	}

	public int getStepHeight() {
		return stepHeight;
	}

	public void setStepHeight(int stepHeight) {
		this.stepHeight = stepHeight;
	}

	public int getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(int startingLocation) {
		this.startingLocation = startingLocation;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
}
