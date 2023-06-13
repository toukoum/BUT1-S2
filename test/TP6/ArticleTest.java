package TP6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void getIntitule() throws IntituleException, PrixException {
        //
        Article article1 = new Article("minuscule", 2.0, 10);
        assertEquals(article1.getIntitule(), "Minuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");

        Article article2 = new Article("MAJUSCULE", 2.0, 10);
        assertEquals(article2.getIntitule(), "Majuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");
    }

    @Test
    void setIntitule() {

        // ne valide pas le test si l'exception IntituleException n'est pas levée.
        assertThrows(IntituleException.class, () -> {
            new Article(null, 2.0, 10);
        }, "Un intitulé ne peut pas être null.");
        //
        assertThrows(IntituleException.class, () -> {
            new Article("", 2.0, 10);
        }, "Un intitulé ne peut pas être vide.");
    }

    @Test
    void getPrix() throws IntituleException, PrixException {
//        retourne le prix unitaire si la quantité demandée est
//        inférieur à 100, retourne le prix unitaire avec une ristourne de 10% si la quantité
//        demandée est supérieur ou égal à 100. Créer une constante SEUIL égale à 100 pour
//        votre réalisation.
        Article article1 = new Article("minuscule", 2.0, 10);

        assertEquals(article1.getPrix(article1.getPrix()), 2.0, "ton prix n'est pas bon !");

        Article article2 = new Article("minuscule", 200, 10);

        assertEquals(article2.getPrix(article2.getPrix()), 180, "ton prix n'est pas bon 2 !");

    }

    @Test
    void setPrix() {

        assertThrows(PrixException.class, () -> {
            new Article("testPrix", 0, 10);
        }, "Le prix ne peut pas être null gros nul !");

    }

    @Test
    void existQuantite() throws PrixException, IntituleException {
        Article article1 = new Article("minuscule", 2.0, 10);
        assertTrue(article1.existQuantite(10), "pas assez de stock !");


    }
    @Test
    void removeQuantite() throws PrixException, IntituleException, StockException {
        Article article = new Article("minuscule", 2.0, 10);
        assertDoesNotThrow(() -> { article.removeQuantite(5);}, "pas assez pour en retirer !");

        //pour vérifier que cela lance bien une exception
        assertThrows(StockException.class, () -> article.removeQuantite(13), " test");
    }



 /*   public void testRemoveQuantite() {
        Stock stock = new Stock();
        stock.addQuantite(10); // Ajoute une quantité au stock

        // Vérifie que la méthode removeQuantite fonctionne correctement
        assertDoesNotThrow(() -> stock.removeQuantite(5)); // Supprime une quantité existante
        assertEquals(5, stock.getQuantite()); // Vérifie que la quantité a été mise à jour correctement

        // Vérifie que la méthode removeQuantite lance une exception lorsque la quantité n'est pas présente
        StockException exception = assertThrows(StockException.class, () -> stock.removeQuantite(8));
        assertEquals("La quantité demandée n'est pas présente dans le stock", exception.getMessage());
        assertEquals(5, stock.getQuantite()); // Vérifie que la quantité n'a pas été modifiée incorrectement
    }
*/



}