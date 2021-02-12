package prakticne_vezbe.pv04_z02.dom1;

import java.io.IOException;

import prakticne_vezbe.pv04_z02.GenerateAgents;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/**
		 * Agent nikad ne prosledjuje informaciju agentu kojem je vec prosl-
		 * edjivao informaciju.
		 */
		
		int numAgents = 10;		// ukupan broj agenata
		int probability = 50;	// verovatnoca da agent bude obazriv
		
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
	}
}
