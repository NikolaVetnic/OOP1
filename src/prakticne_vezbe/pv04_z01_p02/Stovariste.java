package prakticne_vezbe.pv04_z01_p02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Stovariste {

	PolovnoVozilo[] vozila;
	
	public Stovariste(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		vozila = new PolovnoVozilo[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < vozila.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			String s0 = tokens[0].trim();
			int n1 = Integer.parseInt(tokens[1].trim());
			int n2 = Integer.parseInt(tokens[2].trim());
			
			if (s0.equals("auto")) vozila[i] = new PolovniAuto(n1, n2);
			else				   vozila[i] = new PolovniKombi(n1, n2);
		}
		
		br.close();
	}
	
	public PolovniKombi[] najjeftinijiKombi() {
		
		PolovniKombi min = null;
		
		for (PolovnoVozilo v : vozila)
			if (v instanceof PolovniKombi)
				if (min == null)
					min = (PolovniKombi) v;
				else
					if (v.cena() < min.cena())
						min = (PolovniKombi) v;
		
		List<PolovniKombi> lista = new ArrayList<PolovniKombi>();

		for (PolovnoVozilo v : vozila)
			if (v instanceof PolovniKombi && v.cena() == min.cena())
				lista.add((PolovniKombi) v);
		
		PolovniKombi[] out = new PolovniKombi[lista.size()];
		for (int i = 0; i < out.length; i++) out[i] = lista.get(i);
		
		return out;
	}
}
