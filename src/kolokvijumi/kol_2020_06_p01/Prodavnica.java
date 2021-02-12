package kolokvijumi.kol_2020_06_p01;

public interface Prodavnica {

	void sledeci() throws NemaViseKupaca;
	void kupi() throws NemaDovoljnoNovca;
}
