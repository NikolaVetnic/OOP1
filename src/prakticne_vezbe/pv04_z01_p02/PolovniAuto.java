package prakticne_vezbe.pv04_z01_p02;

public class PolovniAuto extends PolovnoVozilo {
	
	private int brojVrata;
	
	public PolovniAuto(int starost, int brojVrata) {
		super(starost);
		this.brojVrata = brojVrata;
	}

	@Override
	public int cena() {
		return brojVrata > 3 ? this.baznaCena() : (int) (this.baznaCena() * 0.95);
	}

	@Override
	public String opisVozila() {
		return "Automobil sa " + brojVrata + " vrata";
	}
}
