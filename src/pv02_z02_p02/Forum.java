package pv02_z02_p02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Forum {

	Objava[] objave;
	
	private Forum(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		objave = new Objava[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < objave.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			objave[i] = Objava.nova(tokens[0].trim(), tokens[1].trim(), 
					Integer.parseInt(tokens[2].trim()));
		}
		
		br.close();
	}
	
	public static Forum ucitaj(String input) throws IOException {
		return new Forum(input);
	}
	
	
	public String toString() {
		
		String out = "";
		
		for (Objava o : objave)
			out += o + " ";
		
		return out;
	}
	
	public void print() {
		for (Objava o : objave) System.out.println(o);
	}
	
	
	public Objava najpopularnijaObjava(String tema) {
		
		Objava out = null;
		
		for (Objava o : objave)
			if (o.tema().equals(tema))
				if (out == null)
					out = o;
				else
					if (o.brKomentara() > out.brKomentara())
						out = o;
		
		if (out == null) {
			System.out.println("Tema nije dozvoljena ili nema objava za zadatu temu.");
			return null;
		} else {
			System.out.println(out);
			return out;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void statistika() throws IOException {
		
		HashMap<String, Integer[]> stats = new HashMap<>();
		
		for (Objava o : objave) {
			
			if (!stats.containsKey(o.tema()))
				stats.put(o.tema(), new Integer[] { 1, o.brKomentara() });
			else
				stats.replace(o.tema(), new Integer[] { stats.get(o.tema())[0] + 1, stats.get(o.tema())[1] + o.brKomentara() });
		}
		
		TreeMap<String, Integer[]> sortedStats = new TreeMap<>();
		sortedStats.putAll(stats);
		
		System.out.println("Statistika foruma: ");
		BufferedWriter bw = new BufferedWriter(new FileWriter("res//forum_stats.txt"));
		
		for (Map.Entry mapElement : sortedStats.entrySet()) {
			
			String tema = (String) mapElement.getKey();
			int brTema = ((Integer[]) mapElement.getValue())[0];
			int brPolaznika = ((Integer[]) mapElement.getValue())[1];
			
			String line = String.format("%-20s [ objave: %3d ] [ komentari: %3d ]\n", tema, brTema, brPolaznika);
			
			System.out.print(line);
			bw.write(line);
		}
		
		bw.close();
	}
}
