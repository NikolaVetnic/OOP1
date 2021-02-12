package prakticne_vezbe.pv07_z01_p01;

public interface Nastavnik {

	void odrziRoditeljski();
	void pregledajZadatke(String predmet) throws NijePredatDomaci, FaliZadatak;
}
