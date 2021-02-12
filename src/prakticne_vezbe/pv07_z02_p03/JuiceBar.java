package prakticne_vezbe.pv07_z02_p03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuiceBar {
	

	public static void main(String[] args) {
		
		String line = null;
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader("res//sokovi.txt"));
			String[][] zabVoce = ucitajZabranjenoVoce(in);
			
			Barmen b = new Barmen(zabVoce);
			
			while ((line = in.readLine()) != null) {
				
				try {
					
					dodajVoce(b, line);
					
					if (b.imaVoca()) {
						try {
							b.promuckaj();
						} catch (GreskaMuckanje e) {
							System.out.println(e.getMessage());
						}
					}
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

	private static void dodajVoce(Barmen b, String line) throws IOException {
		
		String[] tokens = line.split(",");
		
		if (tokens.length == 0 || tokens.length % 2 == 1) {
			throw new IOException("Nije dobra linija -> " + line);
		} else {
			for (int i = 0; i < tokens.length; i += 2) {
				try {
					b.dodajVoce(tokens[i].trim(), Integer.parseInt(tokens[i + 1].trim()));
				} catch (NumberFormatException e) {
					System.out.println("Procitana vrednost nije prirodan broj -> " + e.getMessage());
				} catch (GreskaDodavanje e) {
					System.out.println(e.toString());
				}
			}
		}
	}
	

	private static String[][] ucitajZabranjenoVoce(BufferedReader in) {
		
		String[][] out = null;
		
		try {
			
			out = new String[Integer.parseInt(in.readLine().trim())][2];
			
			for (int i = 0; i < out.length; i++) {
				
				String[] tokens = in.readLine().split(",");
				
				out[i][0] = tokens[0].trim();
				out[i][1] = tokens[1].trim();
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Procitana vrednost nije prirodan broj -> " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Nije dobra linija -> " + e.getMessage());
		}
		
		return out;
	}
}
