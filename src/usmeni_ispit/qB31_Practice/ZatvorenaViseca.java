package usmeni_ispit.qB31_Practice;

public class ZatvorenaViseca extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ZatvorenaViseca(Zagrada zag) {
		super("Zatvorena " + zag.zag + " viseca", zag);
	}
}
