package test;

import org.junit.jupiter.api.Test;
import transport.Tarif;

import static org.junit.jupiter.api.Assertions.*;


/**
 * <b>TarifTest, est une classe permettant de tester l'énumération
 * Tarif.</b>
 * @author Kodjo Pierre AKPATA & Dikra CHEMLAL
 */
class TarifTest {


    /**
     * Elle permet de tester la méthode getValeur {@link Tarif#getValeur()} définie
     * dans l'énumération Tarif.
     */
    @Test
    void testGetValeur() {
        assertEquals(2f, Tarif.REDUCTION.getValeur());
        assertEquals(4f, Tarif.TRANSPORT_NORMAL.getValeur());
        assertEquals(10f, Tarif.TRANSPORT_URGENT.getValeur());
    }
}