package kol1_2020_11_a_p01;

import java.io.IOException;

import kol1_2020_11_a_p01.kafana.Kafana;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Kafana k = new Kafana("Brauhaus", "Bulevar Mihajla Pupina", "pivoteka");
		
		k.print();
		
		k.posluziPivo();
		k.posluziPivo();
		
		k.prosecnaJacinaPiva();
	}
}
