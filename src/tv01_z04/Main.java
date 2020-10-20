package tv01_z04;

import java.io.IOException;

public class Main {

	public static void main(String[] args)
		throws IOException
	{
		RadnaOrganizacija2 ro = new RadnaOrganizacija2("res//ulaz.txt");
		
		ro.stampajZaposlene();
		System.out.println("Prosek plata: " + ro.prosekPlata());
		System.out.println("Radnik sa najvecim stazom: " + ro.maxStaz());
	}
}
