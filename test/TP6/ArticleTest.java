package TP6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



/*
    *  Classe de test pour la classe Article
    * • assertTrue(boolean condition) : vérifie que la condition soit vraie
        • assertFalse(boolean condition) : vérifie que la condition soit fausse
        • assertDoesNotThrow(…) : vérifie que le jeu d’instruction ne renvoie pas
        d’exception
        * assertThrows(…) : vérifie que le jeu d’instruction renvoie une exception
        * assertEquals(…) : vérifie que deux objets soient égaux
 */

class ArticleTest {
    // Test de la méthode getIntitule()
    @Test
    void getIntitule() throws IntituleException, PrixException {
        Article article1 = new Article("minuscule", 2.0, 10);
        assertEquals(article1.getIntitule(), "Minuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");

        Article article2 = new Article("MAJUSCULE", 2.0, 10);
        assertEquals(article2.getIntitule(), "Majuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");
    }

    @Test
    void setIntitule() throws IntituleException, PrixException {
        assertThrows(IntituleException.class, () -> {
            new Article(null, 2.0, 10);
        }, "Un intitulé ne peut pas être null.");

        assertThrows(IntituleException.class, () -> {
            new Article("", 2.0, 10);
        }, "Un intitulé ne peut pas être vide.");

    }


    @Test
    void getPrix() throws PrixException, IntituleException {
        Article article1 = new Article("MAJUSCULE", 1000, 110);

        assertEquals(900, article1.getPrix(110), "Le prix doit être de 900 si la quantité est supérieur à 100");

    }

    @Test
    void setPrix(){
        assertThrows(PrixException.class, () -> {
            new Article("MAJUSCULE", 0, 10);
        }, "Un prix ne peut pas être négatif ou égal à 0.");

        assertThrows(PrixException.class, () -> {
            new Article("MAJUSCULE", -1, 10);
        }, "Un prix ne peut pas être négatif ou égal à 0.");
    }


    @Test
    void existQuantite() throws PrixException, IntituleException {
        Article article1 = new Article("MAJUSCULE", 1000, 110);

        assertTrue(article1.existQuantite(10), "Il doit y avoir 10 articles en stock");
        assertFalse(article1.existQuantite(111), "Il ne doit pas y avoir 111 articles en stock");
    }

    @Test
    void removeQuantite() throws PrixException, IntituleException, StockException {
        Article article1 = new Article("MAJUSCULE", 1000, 110);

        article1.removeQuantite(10);
        assertEquals(100, article1.getStock(), "Il doit y avoir 100 articles en stock");

        assertThrows(StockException.class, () -> {
            article1.removeQuantite(111);
        }, "Il ne doit pas y avoir 111 articles en stock");
    }
}