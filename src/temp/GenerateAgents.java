package temp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GenerateAgents {
	
	public static final String OBAZRIV = "obazriv";
	public static final String OPUSTEN = "opusten";

	public static void main(String[] args) throws IOException {
		
		int numAgents = 100;
		
		generateAgents(numAgents);
		generateContacts(numAgents);
	}
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) { 
  
        // create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>(); 
  
        // add the elements to set 
        set.addAll(list); 
  
        // clear the list 
        list.clear(); 
  
        // add the elements of set with no duplicates to the list 
        list.addAll(set); 
  
        // return the list 
        return list; 
    }
	
	public static void generateAgents(int numAgents) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("res//agenti" + numAgents + ".txt"));
		
		bw.write(numAgents + "\n");
		
		for (int i = 0; i < numAgents; i++) {
			bw.write((Math.random() < .5 ? OBAZRIV : OPUSTEN) + ", " + i + "\n");
		}
		
		bw.close();
	}
	
	public static void generateContacts(int numAgents) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("res//kontakti" + numAgents + ".txt"));
		
		for (int i = 0; i < numAgents; i++) {
			
			int numCont = (int) (Math.random() * numAgents);
				numCont = numCont == 0 ? 1 : numCont;
				
			ArrayList<Integer> arrCont = new ArrayList<>();
			
			for (int j = 0; j < numCont; j++)
				arrCont.add((int) (Math.random() * numAgents));
			
			arrCont = removeDuplicates(arrCont);
			
			Comparator<Integer> c = (i1, i2) -> i1 - i2;
			arrCont.sort(c);
			
			for (int j = 0; j < arrCont.size(); j++)
				bw.write(i + ", " + arrCont.get(j) + "\n");
		}
		
		bw.close();
	}
}
