package pv05_z02.vehicles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import pv05_z02.Util;
import pv05_z02.wheels.Wheel;
import pv05_z02.wheels.WheelSummer;
import pv05_z02.wheels.WheelUniversal;
import pv05_z02.wheels.WheelWinter;

public class Truck {
	
	private static final int MAX_WHEELS = 10;
	

	private String name;
	private Wheel[] wheels;
	private Wheel[] reserve;
	
	private int numUsableWheels;
	
	
	public Truck(String name, String input) throws IOException {
		this.name = name;
		setBestWheels(input);
		
		int num = 0;
		for (Wheel w : wheels) num = !w.ruptured() ? num + 1 : num;
		this.numUsableWheels = num;
	}
	
	
	private static Wheel[] loadWheels(String input) throws IOException {
		
		String line;
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Wheel> output = new ArrayList<>();
		
		while ((line = br.readLine()) != null) {
			
			String[] tokens = line.split(",");
			int age = Integer.parseInt(tokens[0].trim());
			
			if (tokens.length == 1)
				output.add(new WheelUniversal(age));
			else {
				String type = tokens[1].trim();
				if (type.equals("letnja"))
					output.add(new WheelSummer(age));
				else
					output.add(new WheelWinter(age));
			}
		}
		
		br.close();
		
		Wheel[] arr = new Wheel[output.size()];
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = output.get(i);
		
		return arr;
	}
	
	private void setBestWheels(String input) throws IOException {
		
		Wheel[] loadedWheels = loadWheels(input);
		Arrays.sort(loadedWheels);
		
		wheels = new Wheel[MAX_WHEELS];
		reserve = new Wheel[loadedWheels.length - MAX_WHEELS];
		
		for (int i = 0; i < wheels.length; i++)
			wheels[i] = loadedWheels[i];
		
		for (int i = 0; i < reserve.length; i++)
			reserve[i] = loadedWheels[i + MAX_WHEELS];
	}
	
	public boolean drive(int currentDist) {
		
		if (Util.getPercent(1, 1000) <= 5) {
			
			int idx = Util.getPercent(1, 10) - 1;
			
			wheels[idx].setRuptured(true);
			
			int rep = -1;
			
			for (int i = 0; i < reserve.length; i++)
				if (reserve[i].isUsable()) {
					rep = i;
					break;
				}
			
			if (rep != -1) {
				
				System.out.printf("After %dkm replaced wheel #%d with one of the spares.\n", currentDist, idx);
				
				Wheel tmp = wheels[idx];
				wheels[idx] = reserve[rep];
				reserve[rep] = tmp;
			} else {
				
				System.out.printf("After %dkm wheel #%d ruptured, but there are no spare wheels left.\n", currentDist, idx);
				numUsableWheels--;
			}
		}
		
		if (numUsableWheels > MAX_WHEELS / 2) 	return true;
		else				  					return false;
	}
	
	
	public String toString() {
		
		String out = "TRUCK '" + name + "' : [ ";
		
		for (Wheel w : wheels)
			out += w + " ] [ ";
		
		return out + " ]";
	}
	
	
	public void printWheels() 	{ for (Wheel w : wheels) System.out.println(w); 	}
	public void printReserve() 	{ for (Wheel w : reserve) System.out.println(w); 	}
	

	public String name() 		{ return name; 	 	}
	public Wheel[] wheels() 	{ return wheels; 	}
	public Wheel[] reserve() 	{ return reserve; 	}
}
