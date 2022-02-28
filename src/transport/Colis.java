package transport;

public interface Colis extends Ordonnable<Colis> {
	float prixDeTransport();
	float reduction();
	String code();
	float poids();
	@Override
	default public int compareTo(Colis c) {
		return Float.compare(prixDeTransport(), c.prixDeTransport());
	}
}
