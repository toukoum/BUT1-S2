package TP1.jeu;

import data.Carreau;
import data.Chateau;
import data.Guerrier;
import data.Plateau;
import utils.GuerrierUtilitaire;
import utils.ChateauUtilitaire;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fbm rev hb
 */
public class PlateauUtilitaire {

    private static final Random RANDOM = new Random();

    // nombre de cases des différents plateaux
        /**
     * lancé d'un dé trois faces
     * @return : entier entre 1 et 3
     */
    public static int De3() {
        return RANDOM.nextInt(3)+1;
    }

    /**
     * nombreLances d'un dé 3 faces
     * @param nombreLances
     * @return
     */
    public static int De3(int nombreLances) {
        int somme = 0;
        for (int i = 0; i < nombreLances; i++) {
            somme = somme + De3();
        }
        return somme;
    }

        ///////////////////////
    // AFFICHAGE
    
    /**
     * Affichage des Guerriers sur chaque Carreaux du plateau
     * @param plateau
     */
    
    /**
     * Affichage de l'équipe gagnante
     * @param plateau
     */
    

    /**
     * Affichage de tous les Guerriers d'un Carreau
     * @param carreau
     */
    
}
