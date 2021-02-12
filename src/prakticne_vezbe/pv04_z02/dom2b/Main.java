package prakticne_vezbe.pv04_z02.dom2b;

import java.io.IOException;

import prakticne_vezbe.pv04_z02.GenerateAgents;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/**
		 * Agenti tracare dok svi ne dobiju informaciju. Agent takodje ne p-
		 * rosledjuje informaciju agentu kome je vec ranije prosledjivao in-
		 * formaciju.
		 */
		
		int numAgents = 50;		// ukupan broj agenata
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
	}
}
