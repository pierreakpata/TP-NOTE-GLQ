package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import transport.ColisStandard;
import transport.Lot;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe ColisStandardTest, est une classe permettant de tester la classe
 * ColisStandard.
 * @author Kodjo Pierre AKPATA
 */
class ColisStandardTest {

    /**
     * Colis1 représente l'instance 1 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre le poids et l'urgence du colis.
     */
    private static ColisStandard colis1;

    /**
     * Colis2 représente l'instance 2 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre le poids et l'urgence du colis.
     */
    private static ColisStandard colis2;

    /**
     * Colis3 représente l'instance 3 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre uniquement le poids du colis.
     */
    private static ColisStandard colis3;

    /**
     * Colis4 représente l'instance 4 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre uniquement le poids du colis.
     */
    private static ColisStandard colis4;

    /**
     * Colis5 représente l'instance 5 de la classe ColisStandard qui à la même référence
     * que l'instance colis 1.
     */
    private static ColisStandard colis5;

    /**
     * La méthode setUp permet d'initialiser les 5 attributs déclarés comme attributs
     * de la classe de Test ColisStandardTest.
     */
    @BeforeAll
    static void setUp() {
        colis1 = new ColisStandard(22.5f, true);
        colis2 = new ColisStandard(10.34f, true);
        colis3 = new ColisStandard(34.2f);
        colis4 = new ColisStandard(23);
        colis5 = colis1;
    }

    /**
     * La méthode de test poids() permet de tester la méthode poids de la classe ColisStandard
     * en couvrant tous les cas possibles.
     */
    @Test
    void poids() {
        assertEquals(22.5f, colis1.poids());
        assertEquals(10.34f, colis2.poids());
        assertEquals(34.2f, colis3.poids());
        assertEquals(23, colis4.poids());
    }

    /**
     * La méthode de test prixDeTransport() permet de tester la méthode prixDeTransport
     * d'une instance de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void prixDeTransport() {
        assertEquals(225, colis1.prixDeTransport());
        assertEquals(103.4f,  colis2.prixDeTransport());
        assertEquals(136.8f, colis3.prixDeTransport());
        assertEquals(92, colis4.prixDeTransport());
    }

    /**
     * La méthode de test code() permet de tester la méthode code d'une instance
     * de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void code() {
        assertEquals("U1", colis1.code());
        assertEquals("U2", colis2.code());
        assertEquals("N3", colis3.code());
        assertEquals("N4", colis4.code());
    }

    /**
     * La méthode de test testToString() permet de tester la méthode toString
     * d'une instance de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void testToString() {
        assertEquals("U1(22.5 kg)", colis1.toString());
        assertEquals("U2(10.34 kg)", colis2.toString());
        assertEquals("N3(34.2 kg)", colis3.toString());
        assertEquals("N4(23.0 kg)", colis4.toString());
    }

    /**
     * La méthode de test testEquals() permet de tester la méthode equals d'une instance
     * de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void testEquals() {
        assertTrue(colis1.equals(colis5));
        assertFalse(colis1.equals(new Lot()));
        assertTrue(colis2.equals(new ColisStandard(10.34f, true)));
        assertFalse(colis2.equals(new ColisStandard(10.34f)));
        assertFalse(colis2.equals(new ColisStandard(3.0f, true)));
    }

    /**
     * La méthode de test reduction() permet de tester la méthode reduction d'une instance
     * de la classe ColisStandard en couvrant tous les cas possibles.
     */
    @Test
    void reduction() {
        assertEquals(2f, colis1.reduction());
        assertEquals(2f, colis2.reduction());
        assertEquals(0f, colis3.reduction());
        assertEquals(0f, colis4.reduction());
    }
}