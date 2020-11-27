package kol1_2020_06_p01;

public class Main {

	public static void main(String[] args) {
		
		int dub = 0;
		int crv = 0;
		int brl = 0;
		int odr = 0;
		
		for (int i = 0; i < 1000; i++) {
			Patike p0 = new Converse(42);
			System.out.println(p0);
			
			if (p0.tip().equals("DUBOKE")) dub++;
			if (p0.boja().equals("CRVENA")) crv++;
			if (p0.boja().equals("BELA")) brl++;
			if (p0.vrsta().equals("ODRASLE")) odr++;
		}
		
		System.out.println();
		
		System.out.println("DUBOKE  = " + dub);
		System.out.println("CRVENA  = " + crv);
		System.out.println("BELA    = " + brl);
		System.out.println("ODRASLE = " + odr);
	}
}
