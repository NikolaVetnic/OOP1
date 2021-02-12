package usmeni_ispit.qB31_Practice;

public class NepravilneZagrade extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Zagrada zag;
	
	public NepravilneZagrade(String poruka, Zagrada zag) {
		super(poruka);
		this.zag = zag;
	}
	
	public Zagrada getZagrada() { return zag; }
}
