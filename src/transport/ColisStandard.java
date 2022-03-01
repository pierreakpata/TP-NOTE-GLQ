package transport;

public class ColisStandard implements Colis {
	private final boolean urgent;
	private final float  poids ;
	private final String code;
	private static long nombreDeCodes = 1;

	private static String creerCodeUnique() {
		return String.valueOf(nombreDeCodes++);	
	}

	public ColisStandard( float poids, boolean urgent) {
		this.poids = poids;
		this.urgent = urgent;
		String debutCode = "N";
		if (urgent) debutCode = "U";
		this.code = debutCode + creerCodeUnique();
	}

	public ColisStandard( float poids) {
		this( poids, false);
	}

	@Override
	public float poids() {
		return poids;
	}

	@Override
	public float prixDeTransport() {
		if ( urgent )
			return poids * Tarif.TRANSPORT_URGENT.getValeur() ;
		return poids * Tarif.TRANSPORT_NORMAL.getValeur(); 
	}

	@Override
	public String code() { return code; }

	protected String fin() { return ")"; }
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder( code + "(");
		description.append( poids);
		description.append( " kg");
		description.append( fin());
		return  description.toString();		
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if ( !(o instanceof ColisStandard)) return false;
		return poids == ((ColisStandard)o).poids
				&& urgent == ((ColisStandard)o).urgent;
	}
	@Override
	public float reduction() { 
		if (poids < 3.0f || urgent) return Tarif.REDUCTION.getValeur();
		return 0f;
	}
}
