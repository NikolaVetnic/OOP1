package pv04_z01;

public class PolovniKombi extends PolovnoVozilo {

	private int brojSedista;
	
	public PolovniKombi(int starost, int brojSedista) {
		super(starost);
		this.brojSedista = brojSedista;
	}

	@Override
	public int cena() {
		return baznaCena() + brojSedista * 50;
	}

	@Override
	public String opisVozila() {
		return "Kombi sa " + brojSedista + " sedista";
	}
}
