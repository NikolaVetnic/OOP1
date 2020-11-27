package kol1_2020_06_p01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateInput {
	
	static String[] MARKA = { "Nike", "Converse", "Adidas" };

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("res//patike.txt"));
		
		int num = 100;
		
		bw.write(num + "\n");
		
		for (int i = 0; i < num; i++)
			bw.write("" + (Patike.rng.nextInt(40) + 10) + ", " + MARKA[Patike.rng.nextInt(3)] + "\n");
		
		bw.close();
	}
}
