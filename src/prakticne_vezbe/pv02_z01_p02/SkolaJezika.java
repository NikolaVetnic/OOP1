package prakticne_vezbe.pv02_z01_p02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SkolaJezika {
	

	Kurs[] kursevi;
	
	
	private SkolaJezika(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		kursevi = new Kurs[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < kursevi.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			kursevi[i] = Kurs.novi(tokens[0].trim(), tokens[1].trim(),
					Integer.parseInt(tokens[2].trim()));
		}
		
		br.close();
	}
	
	public static SkolaJezika load(String input) throws IOException {
		return new SkolaJezika(input);
	}
	
	
	public String toString() {
		
		String out = "";
		
		for (Kurs k : kursevi)
			out += k + " ";
		
		return out;
	}
	
	public void print() {
		for (Kurs k : kursevi) System.out.println(k);
	}
	
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public String najnaprednijiJezik() {
		
		HashMap<String, Integer> count = new HashMap<>();
		
		for (Kurs k : kursevi)
			if (k.nivo().equals("napredni"))
				if (count.containsKey(k.jezik()))
					if (count.get(k.jezik()) == null)
						count.replace(k.jezik(), k.brPolaznika());
					else
						count.replace(k.jezik(), count.get(k.jezik()) + k.brPolaznika());
				else
					count.put(k.jezik(), k.brPolaznika());
		
		// iteracija kroz mapu (podsetnik)
		if (false)
			for (Map.Entry mapElement : count.entrySet()) {
				
				String jezik = (String) mapElement.getKey();
				int brPolaznika = (int) mapElement.getValue();
				
				System.out.println(jezik + ", " + brPolaznika);
			}
		
		String jezik = "";
		int brPolaznika = -1;
		
		for (Map.Entry mapElement : count.entrySet())
			if (jezik.equals("") || (int) mapElement.getValue() > brPolaznika) {
				jezik = (String) mapElement.getKey();
				brPolaznika = (int) mapElement.getValue();
			}
		
		return jezik;
	}
	
	public void unaprediGrupu(String jezik, String nivo) {
		
		Kurs k = null;
		boolean vecPostojiNapredni = false;
		
		for (Kurs i : kursevi)
			if (i.jezik().equals(jezik))
				if (i.nivo().equals(nivo))
					k = i;
				else if (i.nivo().equals("napredni"))
					vecPostojiNapredni = true;
		
		if (k == null) return;
		
		k.podigniNivo();
		
		if (vecPostojiNapredni)
			System.out.printf(
				"Postoji dve napredne grupe za %s jezik i potrebno ih je spojiti.\n", jezik);
	}
}
