package pv03_z02;

import java.io.IOException;

import pv03_z02.spajz.Spajz;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Spajz sp = Spajz.ucitaj("police", "tegle");
		sp.print();
		
		sp.ukupnaTezina();
		
		sp.najopterecenijaPlastika();
	}
}
