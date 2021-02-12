package prakticne_vezbe.pv04_z02.base;

import java.io.IOException;

import prakticne_vezbe.pv04_z02.GenerateAgents;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		
		int numAgents = -1;		// ukupan broj agenata
		int probability = 5;	// verovatnoca da agent bude obazriv
		
		GenerateAgents.generateAgents(numAgents, probability);
		GenerateAgents.generateContacts(numAgents);
		
		MrezaAgenata ma;
		
		if (numAgents == -1)
			ma = new MrezaAgenata(
					"res//agenti.txt", 
					"res//kontakti.txt");
		else
			ma = new MrezaAgenata(
					"res//agenti" + numAgents + ".txt", 
					"res//kontakti" + numAgents + ".txt");
		
		ma.propagirajInformaciju();
		
		System.out.println();
	}
}
