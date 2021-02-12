package usmeni_ispit.qB31_Practice;

public class Zagrada {

	char zag;
	int  poz;
	
	public Zagrada(char zag, int poz) {
		this.zag = zag;
		this.poz = poz;
	}
	
	public char getZagrada() { return zag; }
	
	public String toString() {
		return "(" + zag + ", " + poz + ")";
	}
}
