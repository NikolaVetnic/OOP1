package usmeni_ispit.qA09_nasledjivanje;

public class Direktor extends usmeni_ispit.qA09_nasledjivanje.Radnik implements usmeni_ispit.qA09_nasledjivanje.paket.Beneficije {
	
	public Direktor(String ime, int radniStaz) {
		super(ime, radniStaz);
	}

	@Override
	public boolean dodatakNaPlatu() {
		return radniStaz > 10;
	}
}
