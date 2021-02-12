package prakticne_vezbe.pv03_z02_p01;

import java.io.IOException;

import prakticne_vezbe.pv03_z02_p01.spajz.Spajz;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/**
		 * NAPOMENA: treći parametar određuje na�?in slaganja tegli, vidite
		 * klasu Spajz.java za detalje.
		 */
		Spajz sp = Spajz.ucitaj("police", "tegle", 2);
		sp.print();
		
		sp.ukupnaTezina();
		
		sp.najopterecenijaPlastika();
	}
}
