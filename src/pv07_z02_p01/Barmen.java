package pv07_z02_p01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Barmen implements Mixer {
	
	
	private List<VocniSok> sokovi;
	private String[][] zabVoce;
	
	private List<HashMap<String, Integer>> recepti; 
	
	
	// Konstruktor kako bih je implementirao da radim za sebe.
	public Barmen(String input) {
		this.sokovi = null;
		ucitajZabVoce(input);
		ucitajRecepte(input);
	}
	
	
	// Konstruktor kakav je trazen zadatkom.
	public Barmen(String[][] zabranjenoVoce, List<HashMap<String, Integer>> recepti) {
		
		this.sokovi = null;
		this.zabVoce = zabranjenoVoce;
		this.recepti = recepti;
	}
	
	
	// Metode za voce.
	private void ucitajZabVoce(String input) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(input))) {
			
			List<String[]> inParovi = new ArrayList<String[]>();
			
			int brParova = Integer.parseInt(in.readLine().trim());
			
			for (int i = 0; i < brParova; i++) {
				
				String[] out = new String[2];
				
				try {
					out = parsirajZabVoce(in.readLine(), i);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
				if (out[0] != null) inParovi.add(out);
			}
			
			zabVoce = new String[inParovi.size()][2];
			
			for (int i = 0; i < zabVoce.length; i++) {
				
				zabVoce[i][0] = inParovi.get(i)[0];
				zabVoce[i][1] = inParovi.get(i)[1];
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl '" + input + "' ne postoji.");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}


	private String[] parsirajZabVoce(String linija, int i) 
			throws IOException {
		
		String[] tokens = linija.split(",");
		
		if (tokens.length != 2) {
			throw new IOException("Linija #" + (i + 1) + " nije dobro formatirana!");
		} else {
			return new String[] { tokens[0].trim(), tokens[1].trim() };
		}
	}


	public void stampajZabVoce() {
		
		System.out.println("Zabranjene kombinacije voca: ");
		
		for (int i = 0; i < zabVoce.length; i++)
			System.out.println(zabVoce[i][0] + ", " + zabVoce[i][1]);
	}
	
	
	// Metode za recepte.
	public void ucitajRecepte(String input) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(input))) {
			
			int brParova = Integer.parseInt(in.readLine().trim());
			
			for (int i = 0; i < brParova; i++)
				in.readLine();
			
			ArrayList<HashMap<String, Integer>> receptiOut = new ArrayList<>();
			String linija;
			
			while ((linija = in.readLine()) != null) {
				
				HashMap<String, Integer> out = parsirajRecept(linija);
				if (out != null) receptiOut.add(out);
			}
			
			recepti = receptiOut;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl '" + input + "' ne postoji.");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
	
	
	private HashMap<String, Integer> parsirajRecept(String linija) {
		
		HashMap<String, Integer> out = new HashMap<>();
		
		String[] tokens = linija.split(",");
		
		for (int i = 0; i < tokens.length - 1; i += 2) {

			int kol = 0;
			
			try { kol = Integer.parseInt(tokens[i + 1].trim()); 
			} catch (NumberFormatException e) {
		    	System.out.println(
		    			"'" + linija + "' -> umesto '" + tokens[i + 1].trim() + "' ocekuje se prirodan broj!");
		    	return null;
		    }
			
			out.put(tokens[i].trim(), kol);
		}
		
		return out;
	}


	public void stampajRecepte() {

		System.out.println("Poznati recepti: ");
		
		for (HashMap<String, Integer> r : recepti)
			System.out.println(r);
	}
	
	
	// Metode za koktele.
	public void pripremiKoktel(HashMap<String, Integer> recept, String nezgoda) 
			throws GreskaDodavanje, GreskaMuckanje {
		
		sokovi = null;
		
		for (String key : recept.keySet()) {
			try {
				dodajVoce(key, recept.get(key));
			} catch (GreskaDodavanje e) {
				System.out.println(e);
			}
		}
		
		if (!nezgoda.equals("ok")) {
			throw new GreskaMuckanje("Doslo je do nezgode! Desilo se -> " + nezgoda);
		}
		
		posluzi();
	}
	

	public void dodajVoce(String voce, int brojKomada) throws GreskaDodavanje {
		
		if (!jeMoguceDodatiVoce(voce)) {
			throw new GreskaDodavanje(new VocniSok(voce, brojKomada));
		} else if (sokovi == null) {
			sokovi = new ArrayList<>();
			sokovi.add(new VocniSok(voce, brojKomada));
		} else {
			sokovi.add(new VocniSok(voce, brojKomada));
		}
	}

	
	private boolean jeMoguceDodatiVoce(String voce) {
		
		if (sokovi == null) return true;
		if (zabVoce.length == 0) return true;
		
		for (String[] par : zabVoce)
			if (par[0].equals(voce) || par[1].equals(voce)) {
				
				int p = par[0].equals(voce) ? 1 : 0;
				
				for (VocniSok s : sokovi)
					if (s.vrs().equals(par[p]))
						return false;
			}
		
		return true;
	}
	
	
	public void stampajSokove() {
		
		System.out.println("Sokovi koji su trenutno u koktelu: ");
		
		for (VocniSok s : sokovi)
			System.out.println(s);
	}


	public void promuckaj() throws GreskaMuckanje {
		// TODO Auto-generated method stub

	}

	
	public void posluzi() {
		
		System.out.print("Sluzi se koktel : ");
		stampajKoktel();
	}

	
	public void stampajKoktel() {
		
		String out = "";
		
		for (VocniSok s : sokovi)
			out += String.format("%s (%2.1f), ", s.vrs(), s.kol());
		
		System.out.println(out.substring(0, out.length() - 2));
	}

	
	// Get / Set metode.
	public int brRecepata()							{ return recepti.size(); }
	public HashMap<String, Integer> recept(int i) 	{ return recepti.get(i); }
}
