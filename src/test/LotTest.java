package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transport.Colis;
import transport.DoublureColis;
import transport.Lot;

import static org.junit.jupiter.api.Assertions.*;


/**
 * <b>La classe LotTest permet de tester la classe Lot {@link Lot}.</b>
 * @author Kodjo Pierre AKPATA & Dikra CHEMLAL
 */
class LotTest {

    /**
     * L'attribut lot est une instance de la classe Lot.
     */
    private Lot lot;

    /**
     * Initialisation de l'attribut lot.
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        lot = new Lot();
        lot.ajoute(new DoublureColis(5f, "U1", 4f, 2f));
        lot.ajoute(new DoublureColis(4f, "U2", 3.2f, 2f));
        lot.ajoute(new DoublureColis(2f, "U3", 2.8f, 0f));
    }

    /**
     * La méthode testTaille permet de tester la méthode taille de la classe Lot {@link Lot#taille()}.
     */
    @Test
    void testTaille() {
        assertEquals(3, lot.taille());
        assertEquals(0, new Lot().taille());
    }

    /**
     * La méthode testEstVide permet de tester la méthode estVide de la classe Lot {@link Lot#estVide()}.
     */
    @Test
    void testEstVide(){
        assertTrue(new Lot().estVide());
        assertTrue(!lot.estVide());
    }


    /**
     * La méthode testAjoute permet de tester la méthode ajoute de la classe Lot {@link Lot#ajoute(Colis)}.
     */
    @Test
    void testAjoute() throws Exception {
        assertThrows(Exception.class, ()->lot.ajoute(null));
        lot.ajoute(new DoublureColis(5f, "U1", 4f, 2f));
        assertEquals(3, lot.taille());
        lot.ajoute(new DoublureColis(3.5f, "U4", 3f, 0f));
        assertEquals(4, lot.taille());
    }

    /**
     * La méthode testEnleve permet de tester la méthode enleve de la classe Lot {@link Lot#enleve(Colis)}.
     */
    @Test
    void testEnleve() {
        assertTrue(lot.enleve(new DoublureColis(4f, "U2", 4f, 2f)));
        assertFalse(lot.enleve(new DoublureColis(4f, "U6", 4f, 2f)));
    }

    /**
     * La méthode testPrixDeTransport permet de tester la méthode prixDeTransport de la classe Lot {@link Lot#prixDeTransport()}.
     */
    @Test
    void testPrixDeTransport() {
        assertEquals(10f, lot.prixDeTransport());
    }

    /**
     * La méthode testReduction permet de tester la méthode reduction de la classe Lot {@link Lot#reduction()}.
     */
    @Test
    void testReduction() {
        assertEquals(4f, lot.reduction());
    }

    /**
     * La méthode testTrierParPrixDeTransport permet de tester la méthode trierParPrixDeTransport
     * de la classe Lot {@link Lot#trierParPrixDeTransport()}.
     */
    @Test
    void testTrierParPrixDeTransport() {
        assertEquals("[(poids=5.0, code='U1'), (poids=4.0, code='U2'), (poids=2.0, code='U3')]", lot.toString());
        lot.trierParPrixDeTransport();
        assertEquals("[(poids=2.0, code='U3'), (poids=4.0, code='U2'), (poids=5.0, code='U1')]", lot.toString());
        assertNotEquals("[(poids=5.0, code='U1'), (poids=4.0, code='U2'), (poids=2.0, code='U3')]", lot.toString());
    }

    /**
     * La méthode testTrierParPoids permet de tester la méthode trierParPoids
     * de la classe Lot {@link Lot#trierParPoids()}.
     */
    @Test
    void testTrierParPoids() {
        assertEquals("[(poids=5.0, code='U1'), (poids=4.0, code='U2'), (poids=2.0, code='U3')]", lot.toString());
        lot.trierParPoids();
        assertEquals("[(poids=2.0, code='U3'), (poids=4.0, code='U2'), (poids=5.0, code='U1')]", lot.toString());
        assertNotEquals("[(poids=5.0, code='U1'), (poids=4.0, code='U2'), (poids=2.0, code='U3')]", lot.toString());
    }

    /**
     * La méthode testToString permet de tester la méthode toString
     * de la classe Lot {@link Lot#toString()}.
     */
    @Test
    void testToString(){
        assertEquals("[(poids=5.0, code='U1'), (poids=4.0, code='U2'), (poids=2.0, code='U3')]", lot.toString());
    }
}