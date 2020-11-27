package kol1_2020_06_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProdavnicaPatika {
	

	Patike[] patike;
	
	
	public ProdavnicaPatika(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		patike = new Patike[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < patike.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			int broj = Integer.parseInt(tokens[0].trim());
			String marka = tokens[1].trim();
			
			if 		(marka.equals("Adidas"))	patike[i] = new Adidas(broj);
			else if (marka.equals("Nike")) 		patike[i] = new Nike(broj);
			else								patike[i] = new Converse(broj);
		}
		
		br.close();
	}
	
	
	public double[] prosecnaCena() {
		
		double sumD = 0.0, sumO = 0.0;
		int countD = 0, countO = 0;
		
		for (Patike p : patike)
			if (p.vrsta().equals("DECIJE")) {
				sumD += p.cena();
				countD++;
			} else {
				sumO += p.cena();
				countO++;
			}
		
		System.out.printf("Prosecna cena decijih patika:\t%8.2f\n", (sumD / countD));
		System.out.printf("Prosecna cena odraslih patika:\t%8.2f\n", (sumO / countO));
		System.out.printf("Prosecna cena svih patika:\t%8.2f\n", ((sumD + sumO) / (countD + countO)));
		
		return new double[] { sumD / countD, sumO / countO, (sumD + sumO) / (countD + countO) };
	}
	
	
	public void printStats() {
		
		int[] tip = new int[2];
		int[] vrsta = new int[2];
		int[] boja = new int[5];
		int[] marka = new int[3];
		
		for (Patike p : patike) {
			
			if (p.tip().equals("DUBOKE")) tip[0]++;
			else						  tip[1]++;
			
			if (p.vrsta().equals("DECIJE")) vrsta[1]++;
			else							vrsta[0]++;
			
			if 		(p.boja().equals("BELA")) boja[0]++;
			else if (p.boja().equals("CRNA")) boja[1]++;
			else if (p.boja().equals("CRVENA")) boja[2]++;
			else if (p.boja().equals("ZUTA")) boja[3]++;
			else boja[4]++;
			
			if (p instanceof Adidas) marka[0]++;
			else if (p instanceof Nike) marka[1]++;
			else marka[2]++;
		}
		
		System.out.printf("TIP patika (duboke / plitke):\t\t%d / %d\n", tip[0], tip[1]);
		System.out.printf("VRSTA patika (odrasle / decije):\t%d / %d\n", vrsta[0], vrsta[1]);
		System.out.printf("BOJA patika (b / cr / cv / z / k):\t%d / %d / %d / %d / %d\n", boja[0], boja[1], boja[2], boja[3], boja[4]);
		System.out.printf("MARKA patika (Adi / Nike / Conv):\t%d / %d / %d\n", marka[0], marka[1], marka[2]);
		
		this.prosecnaCena();
	}
	
	
	public void print() {
		
		for (Patike p : patike)
			System.out.println(p);
		System.out.println();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		ProdavnicaPatika pp = new ProdavnicaPatika("patike");
		pp.print();
		
		pp.printStats();
	}
}
