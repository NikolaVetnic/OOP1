package tv01_z03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	/*
	 * IOException: In other words, main might be the entry point, how-
	 * ever it could also be called like any method, and even as an en-
	 * try point it's called by other code in the JVM.
	 */

	public static void main(String[] args) 
		throws IOException
	{
		BufferedReader br = new BufferedReader(
				new FileReader("res//ulaz.txt"));
		
		String s = br.readLine();
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}
		
		br.close();
	}
}
