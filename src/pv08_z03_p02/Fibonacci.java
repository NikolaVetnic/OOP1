package pv08_z03_p02;

public class Fibonacci {

	private int curr, prev;
	
	public Fibonacci() {
		this.prev = 0;
		this.curr = 1;
	}
	
	public int next() {
		
		int temp = prev + curr;
			prev = curr;
			curr = temp;
		
		return curr;
	}
	
	public int prev() {
		
		int temp = curr;
			curr = prev;
			prev = temp - curr;
		
		return curr;
	}
}
