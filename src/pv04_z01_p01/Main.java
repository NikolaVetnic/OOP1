package pv04_z01_p01;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Stovariste s = new Stovariste("res//polovnavozila.txt");
		PolovniKombi[] r = s.najjeftinijiKombi();
		
		if (r == null)
			System.out.println("U ponudi nema kombija...");
		else
			for (int i = 0; i < r.length; i++)
				System.out.println(r[i]);
	}
}
