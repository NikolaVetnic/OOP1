package usmeni_ispit.qA19_interfejsi;

public class TestInterface {

	interface I {
		static class Val { static int val = 10; }
		default void print() { System.out.println(Val.val); }
		void printTwice();
	}
	
	public static void main(String[] args) {
		
		I i = new I() {
			@Override
			public void printTwice() {
				System.out.println(Val.val + ", " + Val.val);
			}
		};
		
		i.print();
		i.printTwice();
	}
}
