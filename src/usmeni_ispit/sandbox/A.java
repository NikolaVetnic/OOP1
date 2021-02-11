package usmeni_ispit.sandbox;

class A {
	private int a = 10;
	private int[] b;
	  
	{
		b = new int[a];
	}

	public A() {
		for (int i = 0; i < a; i++) b[i] = i * i;
	}
}
