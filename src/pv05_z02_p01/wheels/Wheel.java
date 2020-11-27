package pv05_z02_p01.wheels;

import pv05_z02_p01.Util;

public abstract class Wheel implements Comparable<Wheel> {
	
	private static final int CHANCE_TO_RUPTURE_ON_INIT = 1;

	protected boolean ruptured;
	protected int age;
	
	public Wheel(int age) {
		this.age = age;
		isRupturedOnInit();
	}
	
	abstract public boolean isUsable();
	
	private void isRupturedOnInit() {
		this.ruptured = Util.getPercent(0, 100) <= CHANCE_TO_RUPTURE_ON_INIT ? true : false;
	}
	
	public String toString() {
		return String.format("%-10s age : %-5d ruptured : %-6s", "Wheel", age, ruptured ? "yes" : "no");
	}

	public boolean ruptured() 	{ return ruptured; 	}
	public int age() 			{ return age; 		}

	public void setRuptured(boolean r) 		{ this.ruptured = r;	}
	public void setAge(int age) 			{ this.age = age; 		}

	@Override
	public int compareTo(Wheel that) {
		
		if (this.isUsable())
			if (that.isUsable())
				return this.age - that.age;
			else
				return -1;
		else
			if (that.isUsable())
				return  1;
			else
				return  0;
	}
}
