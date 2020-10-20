package tv01_z03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintFile {
	
	public static void main(String[] args)
		throws IOException
	{
		PrintWriter pw = new PrintWriter(
				new BufferedWriter(new FileWriter("res//out.txt")));
		
		String[] out = {
				"U kvizu sto ga je smislila Bajford Mila",
				"Saznaces ko je jaci, Brus Li ili Godzila",
				"Zasto tvrdokrilci imaju tvrda krila",
				"Kol'ko grba ima dvogrba kamila..."
		};
		
		for (int i = 0; i < out.length; i++) {
			pw.println(out[i]);
		}
		
		pw.close();
	}
}
