package TP1.jeu;

/*import data.Carreau;
import data.Chateau;
import data.Guerrier;
import data.Plateau;
import utils.GuerrierUtilitaire;
import utils.ChateauUtilitaire;
import java.util.List;*/
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author raphael giraud
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
    public static void affichePlateau2(ArrayList<Carreau> plateau) {

        for (int i = 0; i <= plateau.size()-1; i++) {
            int carreaunum = i+1;
            System.out.println("_______CASE_"+carreaunum+"_______");
            if (plateau.get(i).estBleu()) {
                for (Guerrier guerrier : plateau.get(i).guerriersBleus) {
                    GuerrierUtilitaire.afficherGuerrier(guerrier);
                }
            }
            if (plateau.get(i).estRouge()) {
                for (Guerrier guerrier : plateau.get(i).guerriersRouges) {
                    GuerrierUtilitaire.afficherGuerrier(guerrier);
                }
            }
        }

    }

    public static void affichePlateau(ArrayList<Carreau> plateau) {
        // Affichage de la première ligne du plateau
        for (int i = 0; i < plateau.size(); i++) {
            System.out.print("    _______CASE_" + (i + 1) + "_______ ");
        }
        System.out.println();
        for (int j = 0; j < plateau.size(); j++) {
            if (plateau.get(j).estBleu()) {

                for (Guerrier guerrier : plateau.get(j).guerriersBleus) {
                    System.out.print(repeatSpaces(4+ (j*4) + (21*j)));
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier);
                }
            }
        }

        for (int k = plateau.size(); k > 0; k--) {
            if (plateau.get(k-1).estRouge()) {

                for (Guerrier guerrier : plateau.get(k-1).guerriersRouges) {
                    System.out.print(repeatSpaces(104 -(((5-k)*4) + (21*(5-k)))));
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier);
                }
            }
        }
        System.out.println("    +-------------------+    +-------------------+    +-------------------+    +-------------------+    +-------------------+");
        System.out.println();
    }

    public static String repeatSpaces(int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += " ";
        }
        return result;
    }




}







    /**
     * Affichage de l'équipe gagnante
     * @param plateau
     */
    

    /**
     * Affichage de tous les Guerriers d'un Carreau
     * @param carreau
     */

