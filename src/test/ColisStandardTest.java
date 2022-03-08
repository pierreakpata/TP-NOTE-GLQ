package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import transport.ColisGaranti;
import transport.ColisStandard;
import transport.Lot;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>La classe ColisStandardTest permet de tester la classe
 * ColisStandard {@link ColisStandard}.</b>
 * @author Kodjo Pierre AKPATA & Dikra CHEMLAL
 */
class ColisStandardTest extends ColisTestAbstraite{

    /**
     * Initialisation des attributs déclarés dans la classe ColisTestAbstraite.
     */
    @BeforeAll
    static void setUp() throws Exception {
        colis1 = new ColisStandard(22.5f, true);
        colis2 = new ColisStandard(23);

        colisG1 = new ColisGaranti(13.0f, 6.5f);
        colisG2 = new ColisGaranti(5.0f, true, 3.9f);
    }


    /**
     * Elle permet de tester la méthode prixDeTransport
     * définie dans la classe ColisStandard {@link ColisStandard#prixDeTransport()}.
     */
    @Test
    void testPrixDeTransport() {
        assertEquals(225, colis1.prixDeTransport());
        assertEquals(92, colis2.prixDeTransport());
    }


    /**
     * Elle permet de tester la méthode toString
     * définie dans la classe ColisStandard {@link ColisStandard#toString()}.
     */
    @Test
    void testToString() {
        assertEquals("U1(22.5 kg)", colis1.toString());
        assertEquals("N2(23.0 kg)", colis2.toString());
    }

    /**
     * Elle permet de tester la méthode equals d'une instance
     * de la classe ColisStandard {@link ColisStandard#equals(Object)} en couvrant tous les cas possibles.
     */
    @Test
    void testEquals() {
        assertSame(colis1, colis1);
        assertFalse(colis1.equals(new Lot()));
        assertTrue(colis1.equals(new ColisStandard(22.5f, true)));
        assertFalse(colis1.equals(new ColisStandard(10.34f)));
        assertFalse(colis1.equals(colis2));
    }

    /**
     * Elle permet de tester la méthode reduction d'une instance
     * de la classe ColisStandard {@link ColisStandard#reduction()} en couvrant tous les cas possibles.
     * @param poids1
     * @param poids2
     */
    @ParameterizedTest
    @CsvSource({"3, 1.0", "4, 1.2", "5, 1.3", "6, 2.1", "7, 2.5", "8, 2.9"})
    void testReduction(float poids1, float poids2) {
        assertEquals(0f, new ColisStandard(poids1).reduction());
        assertEquals(2f, new ColisStandard(poids2).reduction());
    }
}