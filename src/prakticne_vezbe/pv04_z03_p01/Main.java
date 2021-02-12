package prakticne_vezbe.pv04_z03_p01;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Poliklinika p = new Poliklinika("lekari", "pacijenti");
		p.print();
		
		p.pulmologSaNajmanjomPlatom();
		p.pedijatarSaNajstarijomDecom();
	}
}
