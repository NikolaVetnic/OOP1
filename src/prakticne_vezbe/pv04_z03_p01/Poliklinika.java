package prakticne_vezbe.pv04_z03_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Poliklinika {
	
	static Random rng = new Random(132082374519373312L);

	private Lekar[] lekari;
	
	public Poliklinika(String inLekari, String inPacijenti) throws IOException {
		
		String file = "res//" + inLekari + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		lekari = new Lekar[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < lekari.length; i++) {
			
			String ime = br.readLine().trim();
			String prz = br.readLine().trim();
			String tip = br.readLine().trim();
			
			if (tip.equals("pedijatar")) lekari[i] = new Pedijatar(ime, prz);
			else						 lekari[i] = new Pulmolog(ime, prz);
		}
		
		dodeliPacijente(inPacijenti);
		
		br.close();
	}
	
	private void dodeliPacijente(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int num = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < num; i++) {

			boolean dodeljen = false;
			
			Pacijent tmp = new Pacijent(
									 br.readLine().trim()  ,
									 br.readLine().trim()  ,
					Integer.parseInt(br.readLine().trim()));
			
			while (!dodeljen)
				if (lekari[rng.nextInt(lekari.length)].prihvati(tmp))
					dodeljen = true;
		}
		
		br.close();
	}
	
	public void print() {
		
		for (Lekar l : lekari) {
			System.out.println(l);
			
			for (int i = 0; i < l.brPac(); i++)
				System.out.println("\t" + l.pacijent(i));
		}
	}
	
	public Lekar pulmologSaNajmanjomPlatom() {
		
		Pulmolog p = null;
		
		for (Lekar l : lekari)
			if (l instanceof Pulmolog)
				if (p == null)
					p = (Pulmolog) l;
				else
					if (l.plata() < p.plata())
						p = (Pulmolog) l;
		
		System.out.println("Pulmolog sa najmanjom platom: " + p);
		
		return p;
	}
	
	private static double prosecnaStarostPacijenata(Lekar l) {
		
		if (l.brPac() == 0) return 0.0;
		
		double sum = 0.0;
		
		for (int i = 0; i < l.brPac(); i++)
			sum += l.pacijent(i).god();
		
		return sum / l.brPac();
	}
	
	public Pedijatar pedijatarSaNajstarijomDecom() {
		
		Pedijatar p = null;
		
		for (Lekar l : lekari)
			if (l instanceof Pedijatar)
				if (p == null)
					p = (Pedijatar) l;
				else
					if (prosecnaStarostPacijenata(l) > prosecnaStarostPacijenata(p))
						p = (Pedijatar) l;
		
		System.out.println("Pedijatar sa najstarijom decom: " + p);
		
		return p;
	}
}
