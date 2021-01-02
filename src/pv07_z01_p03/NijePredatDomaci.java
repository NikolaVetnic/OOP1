package pv07_z01_p03;

public class NijePredatDomaci extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NijePredatDomaci(String imeUcenika, String predmet) {
		super(imeUcenika + " : fali domaci iz predmeta -> " + predmet);
	}
}
