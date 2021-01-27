package usmeni_ispit.qB31_balansirane_zagrade;

public class NepravilneZagrade extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Zagrada z;
	
	public NepravilneZagrade(String poruka, Zagrada z) {
		super(poruka);
		this.z = z;
	}
	
	public Zagrada getZagrada() { return z; }
}
