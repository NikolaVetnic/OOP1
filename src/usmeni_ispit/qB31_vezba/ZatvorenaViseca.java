package usmeni_ispit.qB31_vezba;

public class ZatvorenaViseca extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZatvorenaViseca(Zagrada z) {
		super("Zatvorena " + z + " bez otvorene", z);
	}
}
