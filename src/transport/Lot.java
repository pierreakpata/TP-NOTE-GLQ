package transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Lot implements LotDeColis {
	private final ArrayList<Colis> contenu;
	public Lot() {
		contenu = new ArrayList<>(); 
	}
	@Override
	public int taille() {
		return contenu.size();
	}
	@Override
	public void ajoute(Colis c) {
		Objects.requireNonNull(c);
		if ( contenu.contains(c)) return;
		contenu.add( c);
	}
	@Override
	public boolean enleve(Colis c) {
		return contenu.remove( c);
	}
	@Override
	public float prixDeTransport() {
		float prix = 0.0f;
		for (Colis c : contenu) {
			prix += c.prixDeTransport();
		}
		return prix;
	}
	@Override
	public float reduction() {
		float reduction = 0.0f; 
		for (Colis c : contenu) {
			reduction += c.reduction();
		}
		return reduction;
	}
	public void trierParPrixDeTransport() {
		Collections.sort(contenu);
	}
	public void trierParPoids() {
		Collections.sort(contenu, (c1, c2) -> Float.compare(c1.poids(),c2.poids()));
	}
	@Override
	public String toString() { return contenu.toString(); }
}
