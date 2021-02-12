package prakticne_vezbe.pv04_z02.dom2a;

import java.io.IOException;

import prakticne_vezbe.pv04_z02.GenerateAgents;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/**
		 * Agent informaciju prosledjuje tacno jednom - ako mu se informacija
		 * vrati nece prosledjivati nikome drugi put. Takodje, agent ne pros-
		 * ledjuje informaciju agentu kome je vec ranije prosledjivao inform-
		 * aciju.
		 */
		
		int numAgents = 100;	// ukupan broj agenata
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
