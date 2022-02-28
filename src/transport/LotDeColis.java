package transport;

public interface LotDeColis {
	default boolean estVide() { return taille() == 0;}
	int taille();
	void ajoute(Colis c);
	boolean enleve(Colis c);
	float prixDeTransport();
	float reduction(); 
}
