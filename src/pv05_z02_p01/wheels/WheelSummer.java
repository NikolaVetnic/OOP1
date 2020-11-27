package pv05_z02_p01.wheels;

import pv05_z02_p01.Util;

public class WheelSummer extends Wheel {
	
	private static final int CHANCE_TO_RUPTURE_ON_INIT = 5;
	private static final int MAX_AGE = 10;
	
	private static final String TYPE = "Summer";

	public WheelSummer(int age) {
		super(age);
		isRupturedOnInit();
	}
	
	@Override
	public boolean isUsable() {
		return !this.ruptured && this.age <= MAX_AGE;
	}

	private void isRupturedOnInit() {
		this.ruptured = Util.getPercent(0, 100) <= CHANCE_TO_RUPTURE_ON_INIT ? true : false;
	}

	@Override
	public String toString() {
		return super.toString() + 
				String.format("type : %-10s usable : %-10s", TYPE, this.isUsable() ? "yes" : "no");
	}
}
