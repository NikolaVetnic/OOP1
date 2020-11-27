package kol1_2020_11_b_p01;

import java.io.IOException;

import kol1_2020_11_b_p01.shop.Shop;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Shop p = new Shop("uredjaji");
		p.print();
		
		p.sell();
		p.repair();
	}
}
