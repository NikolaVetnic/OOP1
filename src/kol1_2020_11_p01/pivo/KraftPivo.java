package kol1_2020_11_p01.pivo;

import kol1_2020_11_p01.Osobina;

public class KraftPivo extends Pivo {
	
	public boolean pitko;
	
	public KraftPivo(String proizvodjac) {
		
		super();
		
		this.setProizvodjac(proizvodjac);
		this.setJacina(Osobina.rng.nextDouble() * 5.0 + 6.0);
		this.setBoja(Osobina.BOJA[Osobina.rng.nextInt(Osobina.BOJA.length)]);
		this.setTip("kraft");
		this.pitko = !this.jeIzlapelo();
	}

	@Override
	public String toString() {
		return super.toString() + (pitko ? "pitko" : "izlapelo");
	}
	
	@Override
	boolean jeIzlapelo() {
		return Osobina.rng.nextDouble() < Osobina.rng.nextDouble() * 0.2 + 0.7;
	}
}
