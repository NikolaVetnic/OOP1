package pv03_z02_p02;

import java.io.IOException;

import pv03_z02_p02.spajz.Spajz;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Spajz s = Spajz.ucitaj("police", "tegle");
		s.print();
		
		s.ukupnaTezina();
		System.out.println();
		
		s.najopterecenijaPlastika(2.9);
		System.out.println();
	}
}
