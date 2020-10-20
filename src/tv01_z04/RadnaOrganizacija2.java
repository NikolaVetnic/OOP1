package tv01_z04;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import tv01_z03.Radnik;

public class RadnaOrganizacija2 {
	
	private Radnik[] zaposleni;
	private int brZaposlenih;

	public RadnaOrganizacija2(String ulazniFajl) 
		throws IOException
	{
		BufferedReader br = new BufferedReader(
				new FileReader(ulazniFajl));
		
		this.brZaposlenih = Integer.parseInt(br.readLine());
		this.zaposleni = new Radnik[brZaposlenih];
		
		for (int i = 0; i < brZaposlenih; i++) {
			
			String ime = br.readLine();
			double plata = Double.parseDouble(br.readLine());
			int radniStaz = Integer.parseInt(br.readLine());
			
			this.zaposleni[i] = new Radnik(ime, plata, radniStaz);
		}
		
		br.close();
	}
	
	public void stampajZaposlene() {
		for (int i = 0; i < brZaposlenih; i++)
			System.out.println(zaposleni[i]);
	}
	
	public Radnik maxStaz() {
		
		int idx = 0;
		
		for (int i = 1; i < brZaposlenih; i++)
			if (zaposleni[i].getRadniStaz() > zaposleni[idx].getRadniStaz())
				idx = i;
		
		return zaposleni[idx];
	}
	
	public double prosekPlata() {
		
		if (brZaposlenih == 0)
			return Double.NaN;
		
		double sum = zaposleni[0].getPlata();
		
		for (int i = 1; i < brZaposlenih; i++)
			sum += zaposleni[i].getPlata();
		
		return sum / brZaposlenih;
	}
}
