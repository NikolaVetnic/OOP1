package usmeni_ispit.sandbox;

public class Direktor extends usmeni_ispit.sandbox.Radnik implements usmeni_ispit.sandbox.paket.Beneficije {
	
	public Direktor(String ime, int radniStaz) {
		super(ime, radniStaz);
	}

	@Override
	public boolean dodatakNaPlatu() {
		return radniStaz > 10;
	}
}
