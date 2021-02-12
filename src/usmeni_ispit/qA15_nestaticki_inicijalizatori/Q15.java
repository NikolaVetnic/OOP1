package usmeni_ispit.qA15_nestaticki_inicijalizatori;

import java.util.Random;

public class Q15 {

	static class Sirena {
		
		String zvuk;
		
		{ 
			this.zvuk = "viuviuu";
		}
		
		public Sirena() {
			for (int i = 0; i < new Random().nextInt(5); i++)
				this.zvuk += this.zvuk;
		}
	}
	
	public static void main(String[] args) {
		
		Sirena s1 = new Sirena();
		System.out.println(s1.zvuk);
		
		Sirena s2 = new Sirena();
		System.out.println(s2.zvuk);
	}
}
