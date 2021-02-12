package prakticne_vezbe.pv07_z02_p02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws GreskaMuckanje {
		
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader("res//sokovi.txt"));
			String[][] zabVoce = ucitajZabranjenoVoce(in);
			
			Barmen b = new Barmen(zabVoce);
			
			String linija;
			
			while ((linija = in.readLine()) != null) {
				
				try {
					dodajVoce(b, linija);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
				if (!b.imaVoca()) continue;
				
				try {
					b.promuckaj();
				} catch (GreskaMuckanje e) {
					System.out.println(e.getMessage());
				}
			}
			
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException io) {
					System.out.println("Nesto ovde bas ne valja...");
				}
			}
		}
	}

	private static void dodajVoce(Barmen b, String linija) 
			throws IOException {
		
		String[] tokens = linija.split(",");
		
		if (tokens.length > 0 && tokens.length % 2 == 1) {
			throw new IOException("Nije dobra linija -> " + linija);
		} else {
			for (int i = 0; i < tokens.length; i += 2)
				try {
					b.dodajVoce(tokens[i].trim(), Integer.parseInt(tokens[i + 1].trim()));
				} catch (NumberFormatException e) {
					System.out.println("Procitana vrednost nije prirodan broj -> " + e.getMessage());
				} catch (GreskaDodavanje e) {
					System.out.println(e.toString());
				}
		}
	}

	private static String[][] ucitajZabranjenoVoce(BufferedReader in) {
		
		int brParova = -1;
		String[][] zabVoce = null;
		
		try {
			
			brParova = Integer.parseInt(in.readLine().trim());
			zabVoce = new String[brParova][2];
			
			for (int i = 0; i < zabVoce.length; i++) {
				
				String[] tokens = in.readLine().split(",");
				
				zabVoce[i][0] = tokens[0].trim();
				zabVoce[i][1] = tokens[1].trim();
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Procitana vrednost nije prirodan broj -> " + e.getMessage());
		} catch (IOException io) {
			System.out.println("Nije dobra linija!");
		}
		
		return zabVoce;
	}
}
