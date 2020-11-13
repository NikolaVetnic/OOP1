package pv04_z02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateAgents {
	
	public static final String OBAZRIV = "obazriv";
	public static final String OPUSTEN = "opusten";
	
	public static void generateAgents(int numAgents, int probability) throws IOException {
		
		if (numAgents == -1) return;
		
		if (probability < 0 || 100 < probability)
			throw new IllegalArgumentException("Ocekuje se vrednost u opsegu [0, 100]");
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("res//agenti" + numAgents + ".txt"));
		
		bw.write(numAgents + "\n");
		
		for (int i = 0; i < numAgents; i++) {
//			bw.write((Math.random() >= 1.0 / probability ? OBAZRIV : OPUSTEN) + ", " + i + "\n");
			bw.write((i % 2 == 0 ? OBAZRIV : OPUSTEN) + ", " + i + "\n");
		}
		
		bw.close();
	}
	
	public static void generateContacts(int numAgents) throws IOException {
		
		if (numAgents == -1) return;
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("res//kontakti" + numAgents + ".txt"));
		
		for (int i = 0; i < numAgents; i++) {
			
			for (int j = i + 1; j < numAgents; j++) {
				
				if (Math.random() <= .5)
					bw.write(i + ", " + j + "\n");
			}
		}
		
		bw.close();
	}
}
