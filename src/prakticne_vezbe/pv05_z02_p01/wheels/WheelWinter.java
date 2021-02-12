package prakticne_vezbe.pv05_z02_p01.wheels;

public class WheelWinter extends Wheel {

	private static final int MAX_AGE = 7;

	private static final String TYPE = "Winter";

	public WheelWinter(int age) {
		super(age);
	}

	@Override
	public boolean isUsable() {
		return !this.ruptured && this.age <= MAX_AGE;
	}

	@Override
	public String toString() {
		return super.toString() + 
				String.format("type : %-10s usable : %-10s", TYPE, this.isUsable() ? "yes" : "no");
	}
}
