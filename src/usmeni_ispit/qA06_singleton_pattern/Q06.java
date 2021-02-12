package usmeni_ispit.qA06_singleton_pattern;

public class Q06 {

	private int val;
	
	static private Q06 singleton = null;
	
	private Q06() {
		this.val = 0;
	}
	
	public Q06 getInstance() {
		if (singleton == null)
			singleton = new Q06();
		
		return singleton;
	}
	
	public void inc() { this.val++; }
	public int getVal() { return this.val; }
}
