package kolokvijumi.kol_2020_06_p01;

public class NemaDovoljnoNovca extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Kupac k;
	
	public NemaDovoljnoNovca(Kupac k) {
		this.k = k;
	}
	
	public String toString() {
		return "Kupac " + k + " -> nema dovoljno novca.";
	}
}
