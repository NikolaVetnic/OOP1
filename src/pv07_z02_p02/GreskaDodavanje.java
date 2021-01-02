package pv07_z02_p02;

public class GreskaDodavanje extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VocniSok vocniSok;
	private String voce;
	
	public GreskaDodavanje(VocniSok vocniSok, String voce) {
		this.vocniSok = vocniSok;
		this.voce = voce;
	}
	
	public String toString() {
		return "Greska prilikom dodavanja voca '" + voce + "' u sok -> " + vocniSok;
	}
}
