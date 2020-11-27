package pv04_z01_p02;

public abstract class PolovnoVozilo {
	
	private int starost;
	
	public PolovnoVozilo(int starost) {
		this.starost = starost;
	}	
	
	public abstract int cena();	
	
	public abstract String opisVozila();	
	
	public String toString() {
		return opisVozila() + ", starost : " + starost;
	}	
	
	protected int baznaCena() {
		return starost > 20 ? 400 : 2000 - starost * 70;
	}
}
