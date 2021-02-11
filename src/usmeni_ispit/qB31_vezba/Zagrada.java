package usmeni_ispit.qB31_vezba;

public class Zagrada {

	int pozicija;
	char z;
	
	public Zagrada(char z, int pozicija) {
		this.z = z;
		this.pozicija = pozicija;
	}
	
	public String toString() {
		return z + ":" + pozicija;
	}
	
	public char getZagrada() {
		return z;
	}
}
