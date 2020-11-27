package kol1_2020_11_b_p01.devices;

import kol1_2020_11_b_p01.Util;

public class Telephone extends Device {
	
	private String broken;

	public Telephone(double cpu, int mem, double pri, String col) {
		
		this.setCpu(cpu);
		this.setMem(mem);
		this.setCam(true);
		this.setPri(pri);
		this.setCol(col);
		
		this.serviceRequired();
	}

	public String broken() 					{ return broken; 		}
	public void setBroken(String broken) 	{ this.broken = broken; }

	@Override
	public String toString() {
		String out = String.format("%20s : %s", "Telephone", super.toString());
		if (serviceRequired()) out += String.format(" [ %5s BROKEN ] ", broken);
		
		return out;
	}
	
	@Override
	public boolean serviceRequired() {
		
		if (this.broken == null)
			if (Util.rng.nextDouble() < 0.07) {
				this.broken = Util.POSSIBLY_BROKEN[Util.rng.nextInt(3)];
				System.out.printf("Component '%s' is broken - service required!\n", this.broken);
			} else {
				this.broken = "";
			}
		
		return this.broken != "";
	}
}
