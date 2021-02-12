package teorijske_vezbe.tv02_z06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RadnaOrganizacija {

	private Radnik[] radnici;
	
	protected RadnaOrganizacija(String imeFajla) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new FileReader(imeFajla));
		
		int brRadnika = Integer.parseInt(br.readLine());
		radnici = new Radnik[brRadnika];
		
		for (int i = 0; i < radnici.length; i++) {
			
			String[] s = br.readLine().split(",");
			
			if (s.length == 3)
				radnici[i] = Rukovodilac.novi(
						s[0].trim(),
						Integer.parseInt(s[1].trim()),
						Integer.parseInt(s[2].trim()));
			else
				radnici[i] = Radnik.novi(
						s[0].trim(),
						Integer.parseInt(s[1].trim()));
		}
		
		br.close();
	}
	
	public static RadnaOrganizacija ucitaj(String imeFajla) throws IOException {
		return new RadnaOrganizacija(imeFajla);
	}
	
	public double prosecnaPlataRukovodioca(int brPodredjenih) {
		
		double sum = 0.0;
		int num = 0;
		
		for (Radnik r : radnici)
			if (r instanceof Rukovodilac)
				if (((Rukovodilac) r).brPodredjenih() >= brPodredjenih) {
					sum += r.plata();
					num++;
				}
		
		return num == 0 ? Double.NaN : sum / num;
	}
}
