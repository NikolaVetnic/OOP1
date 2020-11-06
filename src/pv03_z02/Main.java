package pv03_z02;

import java.io.IOException;

import pv03_z02.spajz.Spajz;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/**
		 * NAPOMENA: treći parametar određuje način slaganja tegli, vidite
		 * klasu Spajz.java za detalje.
		 */
		Spajz sp = Spajz.ucitaj("police", "tegle", 2);
		sp.print();
		
		sp.ukupnaTezina();
		
		sp.najopterecenijaPlastika();
	}
}
