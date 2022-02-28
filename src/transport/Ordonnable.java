package transport;

public interface Ordonnable<T> extends Comparable<T> {
	default boolean estSuperieurA(T autre) {
		return compareTo(autre) > 0 ;
	}
	default boolean estInferieurA(T autre) {
		return compareTo(autre) < 0 ;
	}
	default boolean estEgalA(T autre) {
		return compareTo(autre) == 0 ;
	}
}
