package pv07_z02_p02;

public interface Mixer {

	void dodajVoce(String voce, int brojKomada) throws GreskaDodavanje;
	void promuckaj() throws GreskaMuckanje;
	void posluzi();
}
