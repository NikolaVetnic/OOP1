package usmeni_ispit.qB31_balansirane_zagrade;

public class Zagrada {

	private int pozicija;
	private char z;
	
	public Zagrada(char z, int pozicija) {
		this.pozicija = pozicija;
		this.z = z;
	}
	
	public String toString() {
		return z + ":" + pozicija;
	}
	
	public char getZagrada() {
		return z;
	}
}
