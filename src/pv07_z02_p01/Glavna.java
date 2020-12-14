package pv07_z02_p01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Glavna {
	
	
	public static List<HashMap<String, Integer>> recepti;
	public static String[][] zabranjenoVoce;
	
	
	public static void ucitajZabranjenoVoce(String input) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(input))) {
			
			List<String[]> zabVoce = new ArrayList<String[]>();
			
			int brParova = Integer.parseInt(in.readLine().trim());
			
			for (int i = 0; i < brParova; i++) {
				
				try {
					dodajZabranjenoVoce(zabVoce, in.readLine(), i);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
			String[][] out = new String[zabVoce.size()][2];
			
			for (int i = 0; i < out.length; i++) {
				
				out[i][0] = zabVoce.get(i)[0];
				out[i][1] = zabVoce.get(i)[1];
			}
			
			zabranjenoVoce = out;
			
		} catch (FileNotFoundException e){
			System.out.println("Fajl '" + input + "' ne postoji.");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	
	public static void dodajZabranjenoVoce(List<String[]> zabVoce, String linija, int i) 
			throws IOException {
		
		String[] tokens = linija.split(",");
		
		if (tokens.length != 2)
			throw new IOException("Linija #" + (i + 1) + " nije dobro formatirana!");
		else
			zabVoce.add(new String[] { tokens[0].trim(), tokens[1].trim() });
	}

	
	public static void stampajZabranjenoVoce() {
		
		System.out.println("Zabranjene kombinacije voca u ovom Juice Baru: ");
		
		for (int i = 0; i < zabranjenoVoce.length; i++)
			System.out.println(zabranjenoVoce[i][0] + ", " + zabranjenoVoce[i][1]);
	}
	
	
	public static void ucitajRecepte(String input) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(input))) {
			
			int brParova = Integer.parseInt(in.readLine().trim());
			
			for (int i = 0; i < brParova; i++)
				in.readLine();
			
			ArrayList<HashMap<String, Integer>> receptiOut = new ArrayList<>();
			String linija;
			
			while ((linija = in.readLine()) != null) {
				
				HashMap<String, Integer> out = dodajRecept(linija);
				if (out != null) receptiOut.add(out);
			}
			
			recepti = receptiOut;
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl '" + input + "' ne postoji.");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
	
	
	public static HashMap<String, Integer> dodajRecept(String linija) {
		
		HashMap<String, Integer> out = new HashMap<>();
		
		String[] tokens = linija.split(",");
		
		for (int i = 0; i < tokens.length - 1; i += 2) {

			int kol = 0;
			
			try{ kol = Integer.parseInt(tokens[i + 1].trim()); 
			} catch(NumberFormatException e) {
		    	System.out.println(
		    			"'" + linija + "' -> umesto '" + tokens[i + 1].trim() + "' ocekuje se prirodan broj!");
		    	return null;
		    }
			
			out.put(tokens[i].trim(), kol);
		}
		
		return out;
	}

	
	public static void stampajRecepte() {

		System.out.println("Juice Bar recepti: ");
		
		for (HashMap<String, Integer> r : recepti)
			System.out.println(r);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("UCITAVANJE...");
		ucitajZabranjenoVoce("res//sokovi.txt");
		ucitajRecepte("res//sokovi.txt");
		
		Barmen b = new Barmen(zabranjenoVoce, recepti);
		
		System.out.println();
		System.out.println("POSLUZIVANJE...");

		int brKoktela = 20;
		
		for (int i = 0; i < brKoktela; i++) {
			
			String nezgoda = i % 3 == 2 ? "prosipanje" :
							 i % 7 == 6 ? "razbijanje" : "ok";
			
			try {
			
				System.out.printf("KOKTEL [%02d]\n", i);
				b.pripremiKoktel(b.recept(i % b.brRecepata()), nezgoda);
			} catch (GreskaMuckanje e) {
				
				System.out.println(e);
			} catch (GreskaDodavanje e) {
				
				System.out.println(e);
			}
			
			System.out.println();
		}
	}
}
