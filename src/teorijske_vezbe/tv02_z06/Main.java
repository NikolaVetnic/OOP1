package teorijske_vezbe.tv02_z06;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		RadnaOrganizacija ro = RadnaOrganizacija.ucitaj("res//radnaorg.txt");
		System.out.println("Prosecna plata rukovodilaca sa >= 5 radnika: " + ro.prosecnaPlataRukovodioca(5));
	}
}
