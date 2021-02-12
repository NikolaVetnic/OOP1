package prakticne_vezbe.pv04_z01_p02;

public class PolovniKombi extends PolovnoVozilo {
	
	private int brojSedista;
	
	public PolovniKombi(int starost, int brojSedista) {
		super(starost);
		this.brojSedista = brojSedista;
	}
	
	@Override
	public int cena() {
		return this.baznaCena() + brojSedista * 50;
	}

	@Override
	public String opisVozila() {
		return "Kombi sa " + brojSedista + " sedista";
	}
}
