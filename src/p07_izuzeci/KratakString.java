package p07_izuzeci;

public class KratakString extends Exception {
	
	private static final long serialVersionUID = 1L;

	public KratakString() {
		super("String ima manje od dva slova");
	}
}
