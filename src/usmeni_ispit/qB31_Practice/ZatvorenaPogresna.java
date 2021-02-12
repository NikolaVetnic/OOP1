package usmeni_ispit.qB31_Practice;

public class ZatvorenaPogresna extends NepravilneZagrade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZatvorenaPogresna(Zagrada otv, Zagrada ztv) {
		super("Otvorena " + otv.zag + " zatvorena za " + ztv.zag, otv);
	}
}
