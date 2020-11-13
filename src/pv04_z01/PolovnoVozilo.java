package pv04_z01;

public abstract class PolovnoVozilo {

	private int starost;
	
	public PolovnoVozilo(int starost) {
		this.starost = starost;
	}
	
	public abstract int cena();
	
	public abstract String opisVozila();
	
	protected int baznaCena() {
		
		if (starost > 20) return 400;
		else return 2000 - 70 * starost;
	}
	
	public String toString() {
		return opisVozila() + ", starost = " + starost;
	}
}
