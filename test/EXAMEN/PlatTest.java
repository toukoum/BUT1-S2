package EXAMEN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatTest {

    @Test
    void getNom() throws PlatException {
        Plat plat = new Plat("lASAGNe", 1);
        assertEquals("Lasagne", plat.getNom(), "Le nom du plat doit être Lasagne");
    }

    @Test
    void getCoutDeFabrication() throws PlatException {
        assertThrows(PlatException.class, () -> {
            new Plat("Lasagne", -1929);
        }, "Le cout de fabrication ne peut être négatif");

        assertThrows(PlatException.class, () -> {
            new Plat("Lasagne", 1929);
        }, "Le cout ne peut être au dessus de 20");

    }

    @Test
    void getPrixDeVente() throws PlatException{
        Plat plat = new Plat("Lasagne", 10);

        assertEquals(15, plat.getPrixDeVente(), "Le prix de vente doit être de 15");
    }
}