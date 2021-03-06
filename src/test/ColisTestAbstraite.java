package test;

import org.junit.jupiter.api.Test;
import transport.Colis;
import transport.ColisGaranti;
import transport.ColisStandard;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>La classe ColisTestAbstraite permet de tester les méthodes communes aux classes
 * de test ColisGarantiTest {@link ColisGarantiTest} et ColisStandardTest {@link ColisStandardTest} .</b>
 * @author Kodjo Pierre AKPATA & Dikra CHEMLAL
 */
abstract class ColisTestAbstraite {

    /**
     * L'attribut colis1 représente l'instance 1 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre le poids et l'urgence du colis.
     */
    protected static ColisStandard colis1;


    /**
     * L'attribut colis4 représente l'instance 2 de la classe ColisStandard et qui est construit
     * à partir du constructeur qui prend en paramètre uniquement le poids du colis.
     */
    protected static ColisStandard colis2;


    /**
     * L'attribut colisG1 représente l'instance 1 de la classe ColisGaranti et qui est construit
     * à partir du constructeur qui prend en paramètre le poids et l'assurance.
     */
    protected static ColisGaranti colisG1;

    /**
     * L'attribut colisG2 représente l'instance 2 de la classe ColisGaranti et qui est construit
     * à partir du constructeur qui prend en paramètre le poids, l'urgence et l'assurance.
     */
    protected static ColisGaranti colisG2;


    /**
     * Elle permet de tester la méthode poids {@link Colis#poids()} définie dans
     * l'interface Colis .
     */
    @Test
    void testPoids() {
        assertEquals(22.5f, colis1.poids());
        assertEquals(23, colis2.poids());

        assertEquals(13.0, colisG1.poids());
        assertEquals(5.0, colisG2.poids());
    }

    /**
     * Elle permet de tester la méthode {@link Colis#code()} code définie
     * dans l'interface Colis.
     */
    @Test
    void testCode() {
        assertEquals("U1", colis1.code());
        assertEquals("N2", colis2.code());

        assertEquals("N3", colisG1.code());
        assertEquals("U4", colisG2.code());
    }

    /**
     * Elle permet de tester la méthode {@link transport.Ordonnable#estSuperieurA(Object)} définie
     * dans l'interface Ordonnable.
     */
    @Test
    void testEstSuperieurA(){
        assertTrue(colis1.estSuperieurA(colis2));
        assertTrue(colis1.estSuperieurA(colisG1));
        assertTrue(colis1.estSuperieurA(colisG2));
    }

    /**
     * Elle permet de tester la méthode {@link transport.Ordonnable#estInferieurA(Object)} définie
     * dans l'interface Ordonnable.
     */
    @Test
    void testEstInferieurA(){
        assertTrue(colis2.estInferieurA(colis1));
        assertTrue(colisG1.estInferieurA(colis1));
        assertTrue(colisG2.estInferieurA(colis1));
    }

    /**
     * Elle permet de tester la méthode {@link transport.Ordonnable#estEgalA(Object)} définie
     * dans l'interface Ordonnable.
     */
    @Test
    void testEstEgalA(){
        assertTrue(colis1.estEgalA(colis1));
        assertTrue(colis2.estEgalA(colis2));
        assertTrue(colisG1.estEgalA(colisG1));
        assertTrue(colisG2.estEgalA(colisG2));
    }
}