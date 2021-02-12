package prakticne_vezbe.pv07_z02_p01;

public interface Mixer {

	void dodajVoce(String voce, int brojKomada) throws GreskaDodavanje;
	void promuckaj() throws GreskaMuckanje;
	void posluzi();
}
