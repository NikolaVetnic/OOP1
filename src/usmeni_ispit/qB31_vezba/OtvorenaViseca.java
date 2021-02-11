package usmeni_ispit.qB31_vezba;

public class OtvorenaViseca extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OtvorenaViseca(Zagrada z) {
		super("Otvorena " + z + " nema zatvorenu", z);
	}
}
