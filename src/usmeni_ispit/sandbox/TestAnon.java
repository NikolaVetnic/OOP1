package usmeni_ispit.sandbox;

public class TestAnon {

	public static void main(String[] args) {
		
		abstract class A {
			String s;
			public A(String s) { this.s = s; }
			abstract void print();
		}
		
		A a = new A("Hello world!") {
			@Override
			void print() {
				System.out.println(s);
			}
		};
		
		a.print();
	}
}
