package usmeni_ispit.qB31_Practice;

public class OtvorenaViseca extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OtvorenaViseca(Zagrada zag) {
		super("Otvorena " + zag.zag + " viseca", zag);
	}
}
