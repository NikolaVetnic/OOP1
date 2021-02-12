package kolokvijumi.kol_2020_06_p01;

class Red {
	
	static class SLLNode {
		
		Kupac element;
		SLLNode veza;
		
		public SLLNode(Kupac element, SLLNode veza) {
			this.element = element;
			this.veza = veza;
		}
	}
	
	SLLNode prvi, posl;
	
	
	public Red() {
		prvi = null;
		posl = null;
	}
	
	
	public boolean jePrazan() {
		return prvi == null;
	}
	
	
	public Object prvi() {
		
		if (jePrazan())
			return null;
			
		return prvi.element;
	}
	
	
	public void izbaciPrvi() {
		
		if (jePrazan())
			return;
			
		if (prvi == posl) {
			
			prvi = null;
			posl = null;
		} else {
			
			prvi = prvi.veza;
		}
	}
	
	
	public void naKraj(Kupac x) {
		
		SLLNode novi = new SLLNode(x, null);
		
		if (jePrazan())
			prvi = novi;
		else
			posl.veza = novi;
		
		posl = novi;
	}
}
