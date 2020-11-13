package pv04_z02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class CheckOutput {

	public static void main(String[] args) throws IOException {
		checkOutput("log");
	}

	
	public static void checkOutput(String input) throws IOException {
		
		/**
		 * Pomoćna klasa koja proverava duplikate u izlaznom ispisivanju na
		 * konzolu - koliko nije bilo duplikata znači da nije bilo ponovlj-
		 * ene propagacije između dva ista agenta u istom smeru.
		 */
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		ArrayList<String> arr = new ArrayList<>();
		String line;
		
		while ((line = br.readLine()) != null)
			arr.add(line);
		
		Set<String> arrSet = new LinkedHashSet<String>(arr);
		
		if (arr.size() == arrSet.size()) System.out.println("No duplicates.");
		else System.out.println("Found " + (arr.size() - arrSet.size()) + " duplicate(s).");
		
		br.close();
	}
}
