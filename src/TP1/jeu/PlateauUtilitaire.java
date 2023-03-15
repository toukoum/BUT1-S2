package TP1.jeu;

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
     *
     * @param plateau
     * @param chateauBleu
     * @param chateauRouge
     */

    public static void affichePlateau(ArrayList<Carreau> plateau, Chateau chateauBleu, Chateau chateauRouge) {
        // Affichage de la première ligne du plateau
        System.out.print("CHATEAU " + chateauBleu.getCouleur());
        for (int i = 0; i < plateau.size(); i++) {

            System.out.print(" _______CASE_" + (i + 1) + "_______ ");

        }
        System.out.print("CHATEAU " + chateauRouge.getCouleur());
        System.out.println();
        for (int j = 0; j < plateau.size(); j++) {
            if (plateau.get(j).estBleu()) {

                for (Guerrier guerrier : plateau.get(j).guerriersBleus) {
                    System.out.print(repeatSpaces(12+ (j*2) + (20*j)));
                    System.out.print(" ");
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier);
                }
            }
        }

        for (int k = plateau.size(); k > 0; k--) {
            if (plateau.get(k-1).estRouge()) {

                for (Guerrier guerrier : plateau.get(k-1).guerriersRouges) {
                    System.out.print(repeatSpaces(210 -(((plateau.size()-k)*2) + (20*(plateau.size()-k)))));
                    System.out.print(" ");
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier);
                }
            }
        }
        System.out.print(repeatSpaces(11));
        System.out.println((repeatSpaces(2) + "+------------------+").repeat(plateau.size()));
        System.out.println();
    }

    public static String repeatSpaces(int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += " ";
        }
        return result;
    }


    public static void afficheAttaque(Guerrier attaquant, Guerrier defenseur, int degat) {
        System.out.print("    COMBAT : ");
        GuerrierUtilitaire.afficherGuerrierLite(attaquant);
        System.out.print("nique la gueule à ");
        GuerrierUtilitaire.afficherGuerrierLite(defenseur);
        System.out.println(" (dégât donné : " + degat + " => dégât subi :" + defenseur.getDegatReel() + ")");
    }



    public static void afficheMort(Guerrier guerrier) {
        System.out.print("    MORT : " );
        GuerrierUtilitaire.afficherGuerrierLite(guerrier);
        System.out.print("KILL ");
        GuerrierUtilitaire.afficherGuerrierLite(guerrier);
    }

    public static void afficheBienvenu(Plateau plateau) {
        System.out.println("  _______ _______ .     .      _______ _______ _______ _______ .     . .     . ");
        System.out.println("      |   |       |     |      |       |     | |       |     | |     | | \\   | ");
        System.out.println("      |   ----    |     |      ----    ------- ----    ------- |     | |  \\  | ");
        System.out.println("  |___|   |______ |_____|      |       |     | |______ |   \\   |_____| |   \\ | ");
    }
}

