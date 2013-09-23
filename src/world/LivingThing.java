package world;

public class LivingThing extends Thing {

	private int hp;

	public LivingThing(boolean b) {
		super(b);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
