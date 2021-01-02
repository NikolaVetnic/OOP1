package pv07_z01_p02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Uciteljica implements Nastavnik {

	private DomaciRad[] pregledaniRadovi;
	private String pregledaniPredmeti;
	
	@Override
	public void odrziRoditeljski() {
		
		if (pregledaniPredmeti == null || pregledaniRadovi == null) {
			System.out.println("Idemo na ekskurziju ako situacija dozvoli...");
		} else {
			
			System.out.println("Pregledani su zadaci iz predmeta -> " + pregledaniPredmeti + ":");
			ispisiZadatke();
			anulirajPolja();
		}
	}
	
	private void ispisiZadatke() {
		for (int i = 0; i < pregledaniRadovi.length; i++)
			System.out.println(pregledaniRadovi[i]);
	}
	
	private void anulirajPolja() {
		pregledaniRadovi = null;
		pregledaniPredmeti = null;
	}
	
	@Override
	public void pregledajZadatke(String predmet) {
		
		try (BufferedReader in = new BufferedReader(
								 new FileReader(predmet))) {
			
			dodajPredmetUPregledane(predmet);
			
			String[] resenja = uzmiResenja(in.readLine(), predmet);
			String linija;
			
			while ((linija = in.readLine()) != null) {
				
				try {
					pregledajZadatak(linija, resenja, predmet);
				} catch (IOException | NijePredatDomaci | FaliZadatak e) {
					System.out.println(e.getMessage());
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(predmet + " ne postoji");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	private void dodajPredmetUPregledane(String predmet) {
		pregledaniPredmeti = pregledaniPredmeti == null ? 
				predmet.toLowerCase() : 
				pregledaniPredmeti + ", " + predmet.toLowerCase();
	}
	
	private String[] uzmiResenja(String readLine, String predmet) throws IOException {
		
		String[] tokens = readLine.split(",");
		String[] resenja = new String[Integer.parseInt(tokens[0].trim())];
		
		if (resenja.length != tokens.length - 1)
			throw new IOException("Nije dobra linija!");
		
		for (int i = 0; i < resenja.length; i++)
			resenja[i] = tokens[i + 1].trim();
		
		return resenja;
	}

	private void pregledajZadatak(String linija, String[] resenja, String predmet)
			throws IOException, NijePredatDomaci, FaliZadatak {
		
		String[] tokens = linija.split(",");
		
		if (tokens.length == 0) {
			throw new IOException("Nije dobra linija!");
		} else if (tokens.length == 1) {
			throw new NijePredatDomaci(tokens[0].trim(), predmet);
		} else {
			
			String[] zadaci = new String[tokens.length - 1];
			for (int i = 0; i < zadaci.length; i++)
				zadaci[i] = tokens[i + 1].trim();
			
			DomaciRad domaciRad = new DomaciRad(tokens[0].trim(), zadaci);
			
			if (resenja.length != zadaci.length) {
				throw new FaliZadatak(domaciRad);
			} else {
				oceniZadatak(domaciRad, resenja);
				dodajZadatakUNizPredmeta(domaciRad);
			}
		}
	}

	private void oceniZadatak(DomaciRad domaciRad, String[] resenja) {
		
		int correct = 0;
		
		for (int i = 0; i < domaciRad.resenja().length; i++)
			if (domaciRad.resenja()[i].equals(resenja[i]))
				correct++;
		
		if (correct == resenja.length)
			domaciRad.setOcena(5);
		else if (correct == 0)
			domaciRad.setOcena(1);
		else
			domaciRad.setOcena(new Random().nextInt(3) + 2);
	}
	
	private void dodajZadatakUNizPredmeta(DomaciRad domaciRad) {
		
		if (pregledaniRadovi == null) {
			pregledaniRadovi = new DomaciRad[] { domaciRad };
		} else {
			DomaciRad[] novi = new DomaciRad[pregledaniRadovi.length + 1];
			
			for (int i = 0; i < pregledaniRadovi.length; i++)
				novi[i] = pregledaniRadovi[i];
			
			novi[novi.length - 1] = domaciRad;
			pregledaniRadovi = novi;
		}
	}
}
