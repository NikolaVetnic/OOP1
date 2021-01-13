package kol_2020_06_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ProdavnicaPatika implements Prodavnica {
	

	Patike[] patike;
	Red kupci;
	
	
	public ProdavnicaPatika(String patikeIn, String kupciIn) throws IOException {
		
		String file = "res//" + patikeIn + ".txt";
		
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
		
		ucitajKupce("res//" + kupciIn + ".txt");
		
		br.close();
	}
	
	
	private void ucitajKupce(String file) {
		
		try (BufferedReader in = 
				new BufferedReader(
				new FileReader(file))) {
			
			kupci = new Red();
			String line;
			
			while ((line = in.readLine()) != null) {
				
				try {
					dodajKupca(line);
				} catch (IOException e) {
					System.out.println("Nije dobra linija -> " + e.getMessage());
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

	private void dodajKupca(String line) throws IOException {
		
		String[] tokens = line.split(";");
		
		if (tokens.length != 3) {
			throw new IOException("Nije dobra linija -> " + line);
		} else {
			kupci.naKraj(new Kupac(
					tokens[0].trim(),
					Integer.parseInt(tokens[1].trim()),
					Double.parseDouble(tokens[2].trim())));
		}
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
			
			if (p.tip().equals("DUBOKE")) 		tip[0]++;
			else						  		tip[1]++;
			
			if (p.vrsta().equals("DECIJE")) 	vrsta[1]++;
			else								vrsta[0]++;
			
			if 		(p.boja().equals("BELA")) 	boja[0]++;
			else if (p.boja().equals("CRNA")) 	boja[1]++;
			else if (p.boja().equals("CRVENA")) boja[2]++;
			else if (p.boja().equals("ZUTA")) 	boja[3]++;
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
	
	
	public void stampajPatike() {
		
		for (Patike p : patike)
			System.out.println(p);
		System.out.println();
	}
	
	
	public void stampajKupce() {
		
		while (!kupci.jePrazan()) {
			System.out.println(kupci.prvi());
			kupci.izbaciPrvi();
		}
		
		System.out.println();
	}
	
	
	@Override
	public void sledeci() throws NemaViseKupaca {
		kupci.izbaciPrvi();
		
		if (kupci.jePrazan())
			throw new NemaViseKupaca();
		
	}
	
	
	@Override
	public void kupi() throws NemaDovoljnoNovca {
		
		Patike ptk = getRandomPatike();
		Kupac k = (Kupac) kupci.prvi();
		
		if (k.nvc() < ptk.cena()) {
			
			try {
				sledeci();
			} catch (NemaViseKupaca e) {
				System.out.println(e.getMessage());
			}
			
			throw new NemaDovoljnoNovca(k);
		}
		
		System.out.println("Kupac " + k.ime() + " kupuje " + ptk.marka() + " patike!");
	}
	
	
	private Patike getRandomPatike() {
		return patike[new Random().nextInt(patike.length)];
	}
	
	
	public void pocetakRadnogVremena() {
		
		while (!kupci.jePrazan()) {
			try {
				kupi();
				sledeci();
			} catch (NemaDovoljnoNovca e) {
				System.out.println(e.toString());
			} catch (NemaViseKupaca e) {
				System.out.println(e.getMessage());
			}
		}
	}


	public static void main(String[] args) throws IOException {
		
		ProdavnicaPatika pp = new ProdavnicaPatika("patike", "kol2_2020_06_p01_kupci");
//		pp.stampajPatike();
//		pp.stampajKupce();
//		
//		pp.printStats();
		
		pp.pocetakRadnogVremena();
	}
}
