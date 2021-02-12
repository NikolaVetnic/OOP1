package prakticne_vezbe.pv08_z01_p01;

public class Matrica {

	private int[][] m;
	private int dim;
	private int[] prethodni;
	
	private int brParnih;
	private int brNeparnih;
	
	public Matrica(int dim, int brojPrethodnih) {
		this.dim = dim;
		this.brParnih = 0;
		this.brNeparnih = 0;
		
		this.prethodni = new int[brojPrethodnih];
		this.m = new int[dim][dim];
		
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				m[i][j] = i * dim + j + 1;
	}
	
	public int brojNaLokaciji(int i, int j) {
		return this.m[i][j];
	}
	
	public boolean sviIsti() {
		for (int i = 0; i < this.prethodni.length - 1; i++)
			if (this.prethodni[i] != this.prethodni[i + 1])
				return false;
		
		return true;
	}
	
	public void odaberiBroj(int broj) {
		
		for (int i = 0; i < this.prethodni.length - 1; i++)
			this.prethodni[i] = this.prethodni[i + 1];
		
		this.prethodni[this.prethodni.length - 1] = broj;
		
		if (broj % 2 == 0) 	this.brParnih++;
		else				this.brNeparnih++;
	}
	
	public int getBrParnih() 	{ return this.brParnih; 	}
	public int getBrNeparnih() 	{ return this.brNeparnih; 	}
}
