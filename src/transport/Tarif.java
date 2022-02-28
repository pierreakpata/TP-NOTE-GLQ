package transport;

public enum Tarif {
	TRANSPORT_NORMAL(4f), TRANSPORT_URGENT(10f), REDUCTION(2f);
	private float valeur;
	private Tarif(float f) { valeur = f; }
	public float getValeur() { return valeur; }
}
