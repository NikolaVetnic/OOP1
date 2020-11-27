package pv05_z02_p01;

import java.util.Random;

public class Util {

	private static Random rng = new Random();

	public static int getPercent() {
		return getPercent(0, 100);
	}
	
	public static int getPercent(int min, int max) {
		return rng.nextInt((max - min) + 1) + min;
	}
}
