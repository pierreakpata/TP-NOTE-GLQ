package transport;

public class ColisGaranti extends ColisStandard {
	private float assurance;
	public ColisGaranti ( float  poids, float assurance) throws Exception {
		this(poids, false, assurance);
	}
	public ColisGaranti ( float  poids, boolean urgent, float assurance) throws Exception {
		super(poids, urgent);
		if (assurance <= 0f) 
			throw new Exception("montant d'assurance invalide");
		this.assurance = assurance;
	}
	@Override
	public float prixDeTransport() {
		return super.prixDeTransport() + assurance;
	}
	@Override
	public float reduction() { 
		return Tarif.REDUCTION.getValeur();
	}
	@Override
	protected String fin() { return ", "+ assurance + " €)"; }
	@Override
	public boolean equals(Object o) {
		if ( this == o ) return true;
		return super.equals(o) && 
				(! (o instanceof ColisGaranti) || assurance == ((ColisGaranti)o).assurance);
	}
}
