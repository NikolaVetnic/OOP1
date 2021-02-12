package usmeni_ispit.qB21_enum;

public class TestEnum {

	enum AB {
		A1(1, 1),
		A2(2, 2);
		
		private int a, b;
		
		private AB(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public void print() {
			System.out.println(a + b);
		}
	}
	
	public static void main(String[] args) {
		
		AB ab = AB.A1;
		ab.print();
	}
}
