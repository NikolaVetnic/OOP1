package usmeni_ispit.qB31_vezba;

public class ZatvorenaPogresna extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ZatvorenaPogresna(Zagrada otvorena, Zagrada zatvorena) {
		super("Otvorena " + otvorena + " zatvorena sa " + zatvorena, otvorena);
	}
}
