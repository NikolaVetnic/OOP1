package prakticne_vezbe.pv04_z03_p01;

public class Pedijatar extends Lekar {

	public Pedijatar(String ime, String prz) {
		super(ime, prz, 200);
	}

	@Override
	public int plata() {
		
		int out = this.brPac() * 300;
		
		for (Pacijent p : this.pacijenti())
			if (p.god() < 5)
				out += 100;
		
		return out;
	}
	
	@Override
	public boolean prihvati(Pacijent p) {
		
		if (p.god() > 18) return false;
		
		return super.prihvati(p);
	}
}
