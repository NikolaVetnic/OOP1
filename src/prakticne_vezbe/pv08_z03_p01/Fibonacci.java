package prakticne_vezbe.pv08_z03_p01;

public class Fibonacci {

	private int curr, prev;
	
	public Fibonacci() {
		this.prev = 0;
		this.curr = 1;
	}
	
	public int greater() {

//		if ((long) prev + (long) curr > Integer.MAX_VALUE) System.out.println("AAA");
		int tmp = prev + curr;
		prev 	= curr;
		curr 	= tmp;
		
		return curr;
	}
	
	public int lesser() {
		
		int tmp	= curr;
		curr 	= prev;
		prev 	= tmp - curr;
		
		return curr;
	}
}
