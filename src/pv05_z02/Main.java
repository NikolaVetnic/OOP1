package pv05_z02;

import java.io.IOException;

import pv05_z02.vehicles.Truck;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Truck t = new Truck("Volvo", "tockovi");
		
		System.out.println("Wheels currently set:");
		t.printWheels();
		System.out.println();
		
		System.out.println("Spare wheels (including unusable ones): ");
		t.printReserve();
		System.out.println();
		
		int driveOption = 2;
		int currentDist = 0;
		int maxDist = 500;
		boolean spareWheelsAvailable = true;
		
		switch (driveOption) {
		
			case 1:	
				
				System.out.printf("Let's go on a %dkm ride!\n", maxDist);
				
				while (spareWheelsAvailable && currentDist <= maxDist)
					spareWheelsAvailable = t.drive(currentDist++);
				
				if (spareWheelsAvailable && --currentDist == maxDist)
					System.out.println("Successful drive!");
				
				break;
				
			case 2:

				System.out.printf("Let's hit the road!\n");
				
				while (spareWheelsAvailable)
					spareWheelsAvailable = t.drive(currentDist++);
				
				break;
			
			default:
				System.out.println("Wrong option.");
				break;
		}
	}
}
