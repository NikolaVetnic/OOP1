package pv06_z02_p01;

import java.io.IOException;

import pv06_z02_p01.registar.Registar;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Registar r = new Registar("gazdinstva", "polja");
		r.stampaj();
		
		r.najprofitabilnije("kukuruz");
		r.najprofitabilnije("psenica");
		r.najstedljivije();
	}
}
