package usmeni_ispit.sandbox;

public class KlasaB extends KlasaA {

	private int b;
	
	public KlasaB(int a, int b) {
		super(a);
		this.b = b;
	}

	public void b() {
		System.out.println(super.a());
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		
//		KlasaB b = new KlasaB(2, 3);
//		b.b();
		
		KlasaA b = new KlasaB(2, 3);
		KlasaB bb = (KlasaB) b;
		bb.b();
	}
}
