package prakticne_vezbe.pv04_z03_p01;

public class Pulmolog extends Lekar {

	public Pulmolog(String ime, String prz) {
		super(ime, prz, 100);
	}

	@Override
	public int plata() { return this.brPac() * 500; }
}
