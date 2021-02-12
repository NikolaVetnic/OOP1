package prakticne_vezbe.pv07_z01_p01;

public class FaliZadatak extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DomaciRad domaciRad;
	
	public FaliZadatak(DomaciRad domaciRad) {
		this.domaciRad = domaciRad;
	}
	
	@Override
	public String getMessage() {
		return "Nema dovoljno predatih zadataka za rad -> " + domaciRad;
	}
}
