package kol2_2021_01_a_p01;

import java.util.ArrayList;
import java.util.List;

public class Jelka {

	
	private static final double MAX_TEZINA 	= 250.0;
	private static final int 	MAX_BROJ	= 5;
	
	
	private double trenTezina;
	private int trenBroj;
	private boolean imaVrh;
	
	
	List<Ukras> ukrasi;
	
	
	public Jelka() {
		this.trenTezina = 0.0;
		this.trenBroj = 0;
		this.ukrasi = new ArrayList<Ukras>();
	}
	
	
	public void pokusajDodavanje(Ukras u) 
			throws MaksimalnoOpterecenjeDostignuto, MaksimalanBrojUkrasaNaJelci, JelkaNeMozeImatiDvaVrha {
		
		if (trenTezina + u.tezina() > MAX_TEZINA)
			throw new MaksimalnoOpterecenjeDostignuto("Maksimalno opterecenje dostignuto!");
		
		if (trenBroj + 1 > MAX_BROJ)
			throw new MaksimalanBrojUkrasaNaJelci("Maksimalan broj ukrasa je vec na jelci!");
		
		if (imaVrh && u instanceof VrhZaJelku)
			throw new JelkaNeMozeImatiDvaVrha("Jelka vec ima vrh na sebi!");
		
		ukrasi.add(u);
		if (u instanceof VrhZaJelku) imaVrh = true;
		trenTezina += u.tezina();
		trenBroj++;
	}
	
	
	public void stampaj() {
		for (Ukras u : ukrasi)
			System.out.println(u);
	}
}
