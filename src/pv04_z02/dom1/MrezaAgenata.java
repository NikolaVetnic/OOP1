package pv04_z02.dom1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MrezaAgenata {

	public TajniAgent[] agent;
	
	private HashMap<String, TajniAgent> indeks = new HashMap<String, TajniAgent>();
	
	public MrezaAgenata(String agentiFajl, String kontaktiFajl) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(agentiFajl));
		
		int brAgenata = Integer.parseInt(br.readLine().trim());
		agent = new TajniAgent[brAgenata];
		
		for (int i = 0; i < brAgenata; i++) {
			
			String[] tokens = br.readLine().split(",");
			String tip = tokens[0].trim();
			String kodnoIme = tokens[1].trim();
			
			if (tip.equals("obazriv"))
				agent[i] = new ObazrivAgent(kodnoIme);
			else
				agent[i] = new OpustenAgent(kodnoIme);
			
			indeks.put(kodnoIme, agent[i]);
		}
		
		br.close();
		
		br = new BufferedReader(new FileReader(kontaktiFajl));
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			
			String[] tokens = line.split(",");
			TajniAgent agent1 = indeks.get(tokens[0].trim());
			TajniAgent agent2 = indeks.get(tokens[1].trim());
			
			if (agent1 != null && agent2 != null) {
				agent1.dodajKontakt(agent2);
				agent2.dodajKontakt(agent1);
			}
		}
		
		br.close();
	}
	
	public void propagirajInformaciju() {
		
		int rndIndex = (int) (Math.random() * agent.length);
		TajniAgent start = agent[rndIndex];
		start.primiInformaciju(null);
		System.out.println("Pocinje od " + start);
		
		for (int i = 0; i < agent.length; i++)
			if (agent[i].primioInformaciju())
				System.out.println(agent[i]);
	}
}
