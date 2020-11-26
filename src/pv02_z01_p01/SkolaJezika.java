package pv02_z01_p01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SkolaJezika {

	Kurs[] kursevi;
	
	private SkolaJezika(String file) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(
				new FileReader(file));
		
		kursevi = new Kurs[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < kursevi.length; i++) {
			
			String curr = br.readLine();
			
			kursevi[i] = Kurs.novi(
									 curr.split(",")[0].trim(), 
									 curr.split(",")[1].trim(), 
					Integer.parseInt(curr.split(",")[2].trim()));
		}
		
		br.close();
	}
	
	public static SkolaJezika load(String input) throws NumberFormatException, IOException {
		
		String file = "res//" + input + ".txt";
		
		if (!(new File(file)).exists()) {
			System.out.println("Fajl ne postoji.");
			return null;
		}
		
		return new SkolaJezika(file);
	}
	
	public void save(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		if ((new File(file)).exists()) {
			System.out.println("Fajl vec postoji.");
			return;
		}
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(file));
		
		bw.write(this.kursevi.length + "\n");
		
		for (Kurs k : kursevi)
			bw.write(k.jezik() + ", " + k.nivo() + ", " + k.brP() + "\n");
		
		bw.close();
	}
	
	public Kurs najnaprednijiKurs() {
		
		Kurs out = null;
		
		for (Kurs k : kursevi)
			if (k.nivo().equalsIgnoreCase("napredni"))
				if (out == null) out = k;
				else
					if (k.brP() > out.brP()) out = k;
		
		return out;
	}
	
	public void unaprediGrupu(String jezik, String nivo) {
		
		if (nivo.equalsIgnoreCase("napredni")) return;
		
		Kurs tmp = null;
		
		boolean srd = false;
		boolean nap = false;
		
		for (Kurs k : kursevi)
			if (k.jezik().equalsIgnoreCase(jezik))
				if (k.nivo().equalsIgnoreCase(nivo))
					tmp = k;
				else
					if (k.nivo().equalsIgnoreCase("srednji"))
						srd = true;
					else if (k.nivo().equalsIgnoreCase("napredni"))
						nap = true;
		
		if (tmp == null) return;
		
		if (tmp.nivo().equalsIgnoreCase("osnovni")) tmp.setNivo("srednji");
		else tmp.setNivo("napredni");
		
		System.out.println("Grupa za " + jezik + " jezik nivoa " + nivo + " je unapredjena.");
		
		if (srd) 
			System.out.println("Postoje dve grupe srednjeg nivoa koje je potrebno spojiti.");
		
		if (nap) 
			System.out.println("Postoje dve grupe naprednog nivoa koje je potrebno spojiti.");	
	}
	
	public void print() {
		
		System.out.println("Spisak svih grupa: ");
		
		for (Kurs k : kursevi)
			System.out.println(k);
	}
}
