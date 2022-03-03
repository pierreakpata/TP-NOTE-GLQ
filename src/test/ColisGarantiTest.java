package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import transport.ColisGaranti;
import transport.ColisStandard;
import transport.Lot;

import static org.junit.jupiter.api.Assertions.*;


/**
 * <b>La classe ColisGarantiTest, est une classe permettant de tester la classe
 * ColisGaranti.</b>
 * @author Kodjo Pierre AKPATA
 */
class ColisGarantiTest extends ColisTestAbstraite{

    /**
     * La méthode setUp permet d'initialiser en une seule fois les attributs déclarés.
     * @throws Exception
     */
    @BeforeAll
    static void setUp() throws Exception {
        colis1 = new ColisStandard(22.5f, true);
        colis2 = new ColisStandard(23);

        colisG1 = new ColisGaranti(13.0f, 6.5f);
        colisG2 = new ColisGaranti(5.0f, true, 3.9f);
    }

    /**
     * La méthode testConstructeur permet de tester les constructeurs de la classe
     * ColisGaranti.
     */
    @Test
    void testConstructeur(){
        assertEquals(13.0f, colisG1.poids());
        assertEquals("N3", colisG1.code());
        assertEquals(5.0f, colisG2.poids());
        assertEquals("U4", colisG2.code());
        assertThrows(Exception.class, ()-> new ColisGaranti(21.0f, -12.0f));
        assertThrows(Exception.class, ()-> new ColisGaranti(23.0f, 0.0f));
    }


    /**
     * La méthode testPrixDeTransport permet de tester la méthode prixDeTransport définie
     * dans la classe ColisGaranti.
     */
    @Test
    void testPrixDeTransport() {
        assertEquals(58.5f, colisG1.prixDeTransport());
        assertEquals(53.9f, colisG2.prixDeTransport());
    }

    /**
     * La méthode testReduction permet de tester la méthode reduction définie
     * dans la classe ColisGaranti.
     */
    @Test
    void testReduction() {
        assertEquals(2f, colisG1.reduction());
        assertEquals(2f, colisG2.reduction());
    }

    /**
     * La méthode testReduction permet de tester la méthode reduction définie
     * dans la classe ColisGaranti.
     */
    @Test
    void testEquals() throws Exception {
        assertSame(colisG1, colisG1);
        assertFalse(colisG1.equals(new Lot()));
        assertFalse(colisG1.equals(colisG2));
        assertFalse(colisG2.equals(new ColisGaranti(5.0f, 3.9f)));
        assertTrue(colisG2.equals(new ColisGaranti(5.0f, true, 3.9f)));
    }

    /**
     * La méthode testToString permet de tester la méthode toString définie
     * dans la classe ColisGaranti.
     */
    @Test
    void testToString() {
        assertEquals("N3(13.0 kg, 6.5 €)", colisG1.toString());
        assertEquals("U4(5.0 kg, 3.9 €)", colisG2.toString());
    }
}