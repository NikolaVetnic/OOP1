package prakticne_vezbe.pv04_z01_p01;

public class PolovniAuto extends PolovnoVozilo {

	private int brojVrata;
	
	public PolovniAuto(int starost, int brojVrata) {
		super(starost);
		this.brojVrata = brojVrata;
	}

	@Override
	public int cena() {
		
		if (brojVrata > 3) return baznaCena();
		else return (int) (.95 * baznaCena());
	}

	@Override
	public String opisVozila() {
		return "Automobil sa " + brojVrata + " vrata";
	}
}
