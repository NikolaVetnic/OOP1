package kol1_2020_11_b_p01.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import kol1_2020_11_b_p01.Util;
import kol1_2020_11_b_p01.devices.DesktopComputer;
import kol1_2020_11_b_p01.devices.Device;
import kol1_2020_11_b_p01.devices.Laptop;
import kol1_2020_11_b_p01.devices.Telephone;

public class Shop implements Repair {

	private Device[] devices;
	private Device[] serviceRequired;
	private int numServiceRequired;
	
	public Shop(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		devices = new Device[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < devices.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			String 	tip = tokens[0].trim();
			String 	col = tokens[1].trim();
					col = col.equals("crna") ? "black" : (col.equals("bela") ? "white" : "gray");
			double 	cpu = Double.parseDouble(tokens[2].trim());
			int    	mem = Integer.parseInt(tokens[3].trim());
			double 	pri = Double.parseDouble(tokens[4].trim());
			boolean cam = tokens.length == 6 ? (tokens[5].trim().equals("da") ? true : false) : false;
			
			if (tip.equalsIgnoreCase("desktop"))
				devices[i] = new DesktopComputer(cpu, mem, pri, col);
			else if (tip.equalsIgnoreCase("laptop"))
				devices[i] = new Laptop(cpu, mem, cam, pri, col);
			else
				devices[i] = new Telephone(cpu, mem, pri, col);
		}
		
		serviceRequired = new Device[3];
		numServiceRequired = 0;
		
		br.close();
	}
	
	public void print() {
		for (Device d : devices)
			System.out.println(d);
	}
	
	public double sell() {

		double sum = 0.0;
		int count = 0;
		
		for (Device d : devices)
			if (d.serviceRequired())
				if (numServiceRequired < serviceRequired.length)
					serviceRequired[numServiceRequired++] = d;
				else
					continue;
			else {
				sum += d.price();
				count++;
			}
		
		System.out.printf("Sold %d devices for a total of : %6.2f EUR (average per device %.2f)\n", count, sum, sum / count);
		
		return sum / count;
	}

	@Override
	public boolean repair() {
		
		int count = 0;
		
		for (Device d : serviceRequired)
			if (d instanceof Telephone)
				count = Util.rng.nextDouble() < 0.80 ? count + 1 : count;
			else
				count = Util.rng.nextDouble() < 0.75 ? count + 1 : count;
		
		if (numServiceRequired == 0) {
			System.out.println("No devices in repair que.");
			return true;
		} else if (numServiceRequired == count) {
			System.out.println("All devices in repair que repaired!");
			return true;
		} else {
			System.out.println("Not all devices in repair que were repaired...");
			return false;
		}
	}
}
