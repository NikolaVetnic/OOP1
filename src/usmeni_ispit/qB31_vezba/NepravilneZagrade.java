package usmeni_ispit.qB31_vezba;

public class NepravilneZagrade extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9191307611209332157L;

	private Zagrada z;
	
	public NepravilneZagrade(String poruka, Zagrada z) {
		super(poruka);
		this.z = z;
	}
	
	public Zagrada getZagrada() { return z; }
}
