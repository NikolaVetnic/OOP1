package pv03_z01_p01;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Galerija g = new Galerija("umetnici", "dela");
		g.print();
		
		g.autorNajstarijegDela();
		System.out.println();
		
		g.prosecnaVrednostSvihDela();
	}
}
