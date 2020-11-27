package kol1_2020_11_b_p01.devices;

public abstract class Device {

	private double cpu;
	private int mem;
	private boolean cam;
	private double pri;
	private String col;
	
	public String toString() {
		return String.format("%4.2f %6d %8s %8.2f %8s", cpu, mem, cam, pri, col);
	}

	public double 	cpu() 		{ return cpu; }
	public int 		mem() 		{ return mem; }
	public boolean 	hasCam() 	{ return cam; }
	public double 	price() 	{ return pri; }
	public String 	color() 	{ return col; }

	public void setCpu(double cpu) 	{ this.cpu = cpu; }
	public void setMem(int mem) 	{ this.mem = mem; }
	public void setCam(boolean cam) { this.cam = cam; }
	public void setPri(double pri) 	{ this.pri = pri; }
	public void setCol(String col) 	{ this.col = col; }
	
	abstract public boolean serviceRequired();		// govori da li je potrebno odneti uredjaj na servisiranje
}
