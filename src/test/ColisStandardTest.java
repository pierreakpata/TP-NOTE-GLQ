package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import transport.ColisGaranti;
import transport.ColisStandard;
import transport.Lot;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>La classe ColisStandardTest, est une classe permettant de tester la classe
 * ColisStandard.</b>
 * @author Kodjo Pierre AKPATA
 */
class ColisStandardTest extends ColisTestAbstraite{

    /**
     * La méthode setUp permet d'initialiser les attributs déclarés.
     */
    @BeforeAll
    static void setUp() throws Exception {
        colis1 = new ColisStandard(22.5f, true);
        colis2 = new ColisStandard(23);

        colisG1 = new ColisGaranti(13.0f, 6.5f);
        colisG2 = new ColisGaranti(5.0f, true, 3.9f);
    }


    /**
     * La méthode testPrixDeTransport permet de tester la méthode prixDeTransport
     * définie dans la classe ColisStandard.
     */
    @Test
    void testPrixDeTransport() {
        assertEquals(225, colis1.prixDeTransport());
        assertEquals(92, colis2.prixDeTransport());
    }


    /**
     * La méthode testToString permet de tester la méthode toString
     * définie dans la classe ColisStandard.
     */
    @Test
    void testToString() {
        assertEquals("U1(22.5 kg)", colis1.toString());
        assertEquals("N2(23.0 kg)", colis2.toString());
    }

    /**
     * La méthode de test testEquals() permet de tester la méthode equals d'une instance
     * de la classe ColisStandard en couvrant tous les cas possibles.
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
     * La méthode de test reduction() permet de tester la méthode reduction d'une instance
     * de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void reduction() {
        assertEquals(2f, colis1.reduction());
        assertEquals(0f, colis2.reduction());
    }
}