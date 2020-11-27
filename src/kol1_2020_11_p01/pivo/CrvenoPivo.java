package kol1_2020_11_p01.pivo;

import kol1_2020_11_p01.Osobina;

public class CrvenoPivo extends Pivo {
	
	public boolean pitko;

	public CrvenoPivo(String proizvodjac) {
		
		super();
		
		this.setProizvodjac(proizvodjac);
		this.setJacina(8.0);
		this.setBoja(Osobina.BOJA[2]);
		this.setTip("crveno");
		this.pitko = !this.jeIzlapelo();
	}

	@Override
	public String toString() {
		return super.toString() + (pitko ? "pitko" : "izlapelo");
	}
	
	@Override
	boolean jeIzlapelo() {
		return Osobina.rng.nextDouble() < 0.5;
	}
}
