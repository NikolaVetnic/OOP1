package kol2_2021_01_a_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;

public class PonudaUkrasa {

	
	private static final String FAJL = "res//kol2_2021_01_a_ukrasi.txt";
	
	
	private List<Ukras> ukrasi;
	
	
	public PonudaUkrasa() {
		this.ukrasi = new ArrayList<Ukras>();
		ucitaj(FAJL);
	}


	private boolean ucitaj(String fajl) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(fajl))) {
			
			String line = null;
			int lineCount = 0;
			
			while ((line = in.readLine()) != null) {
				
				String[] tokens = line.split(",");
				lineCount++;
				
				/*
				 * Ovaj izuzetak koji se javlja kada linija nije ispravno formatir-
				 * ana sam namerno uhvatio i obradio ovde, uz prikazivanje poruke u
				 * konzoli jer sam zeleo da dozvolim ucitavanje ostalih linija koje
				 * su ispravne. Smatram da je program tako funkcionalniji umesto da
				 * sam izbacivao Alert prozor korisniku...
				 */ 
				
				try {
					
					String boja 	= tokens[0].trim();
					
					double tezina 	= Double.parseDouble(tokens[1].trim());
					double cena 	= Double.parseDouble(tokens[2].trim());
					
					if (tokens.length == 3) {
						
						Ukras u 	= new Ukras(boja, tezina, cena);
						
						ukrasi.add(u);
					} else if (tokens.length == 4) {
						double visina 	= Double.parseDouble(tokens[3].trim());
						VrhZaJelku v 	= new VrhZaJelku(boja, tezina, cena, visina);
						
						ukrasi.add(v);
					}
					
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Greska prilikom citanja fajla u liniji -> " + lineCount);
				}
			}
			
		} catch (IOException e) {
			new Alert(Alert.AlertType.ERROR, "Greska prilikom citanja fajla -> " + e.getMessage()).showAndWait();
			return false;
		}
		
		return true;
	}

	
	public List<Ukras> ukrasi() 	{ return this.ukrasi;	}
	
	
	public void stampaj() {
		for (Ukras u : ukrasi)
			System.out.println(u);
	}
}
