package kol1_2020_11_b_p01;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {

		Prodavnica prodavnica = new Prodavnica();
		
		
		System.out.println("Vrednost prodatih uredjaja = " + prodavnica.prodaj());
		
		boolean sviPopravljeni = prodavnica.popravi();
		if (sviPopravljeni) {
			System.out.println("Svi uredjaji su popravljeni");
		} else {
			System.out.println("Nisu svi uredjaji popravljeni");
		}
	}

}
