package prakticne_vezbe.pv07_z02_p01;

public class GreskaDodavanje extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VocniSok sok;

	public GreskaDodavanje(VocniSok sok) {
		this.sok = sok;
	}
	
	@Override
	public String getMessage() {
		return "Greska prilikom dodavanja voca u sok -> " + sok;
	}
}
