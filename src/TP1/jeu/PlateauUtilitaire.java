package TP1.jeu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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

        System.out.print("\u001b[34m_CHATEAU_\u001b[0m");

        for (int i = 0; i < plateau.size(); i++) {

            System.out.print("_______CASE_\u001b[32m" + (i + 1) + "\u001b[0m_______ ");

        }
        System.out.print("\u001b[31m_CHATEAU_\u001b[0m");
        System.out.println();
        for (int j = 0; j < plateau.size(); j++) {
            if (plateau.get(j).estBleu()) {

                for (Guerrier guerrier : plateau.get(j).guerriersBleus) {
                    System.out.print(repeatSpaces(10));
                    System.out.print(repeatSpaces((j) + (20*j)));
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier, "bleu");
                }
            }
        }

        for (int k = plateau.size(); k > 0; k--) {
            if (plateau.get(k-1).estRouge()) {
                for (Guerrier guerrier : plateau.get(k-1).guerriersRouges) {
                    System.out.print(repeatSpaces((114 - (((plateau.size() - k) * 1) + (20 * (plateau.size() - k))))));
                    System.out.print(" ");
                    GuerrierUtilitaire.afficherGuerrierLiteLite(guerrier, "rouge");
                }
            }
        }
        System.out.print("\u001b[34m--BLEU---\u001b[0m");
        System.out.print(("+------------------+ ").repeat(plateau.size()));
        System.out.print("\u001b[31m--ROUGE---\u001b[0m");
        System.out.println("\n");

    }

    public static String repeatSpaces(int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += " ";
        }
        return result;
    }


    public static void afficheAttaque(Guerrier attaquant, Guerrier defenseur, int degat) {
        System.out.print("    \u001b[30mCOMBAT : \u001b[0m");
        GuerrierUtilitaire.afficherGuerrierLite(attaquant);
        System.out.print("nique la gueule à ");
        GuerrierUtilitaire.afficherGuerrierLite(defenseur);
        System.out.println(" (dégât donné : " + degat + " => dégât subi :" + defenseur.getDegatReel() + ")");
    }


    public static void afficheMort(Guerrier vivant, Guerrier mort) {
        System.out.print("    \u001b[30mMORT : \u001b[0m" );
        GuerrierUtilitaire.afficherGuerrierLite(vivant);
        System.out.print("KILL ");
        GuerrierUtilitaire.afficherGuerrierLite(mort);
        System.out.println();
    }

    public static void afficheBienvenu(Plateau plateau) {
        System.out.println("\u001b[35m _______ _______ .     .      _______ _______ _______ _______ .     . .     . ");
        System.out.println("     |   |       |     |      |       |     | |       |     | |     | | \\   | ");
        System.out.println("     |   ----    |     |      ----    ------- ----    ------- |     | |  \\  | ");
        System.out.println(" |___|   |______ |_____|      |       |     | |______ |   \\   |_____| |   \\ | \u001b[0m");
    }

    public static void afficheGagnant(Plateau plateau) {
        if (!(plateau.getGagnant().compareTo(Couleur.noGagnant) == 0)) {
            System.out.println("\u001b[35mBRAVO AUX " + plateau.getGagnant() + "\u001b[35m !!! Vous avez gagné un saxophone. A récuperer chez vous\u001b[0m");
        }else {
            System.out.println("\u001b[35mPas encore de gagnant ! \u001b[0m(partie non terminée)");
        }
    }

    public static int saisirnombre(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        System.out.print("Veuillez saisir un carreau (entre " + min + " et " + max + ") : ");
        do {
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                checkInRange(result, min, max);
            } catch (InputMismatchException e) {
                System.out.println("Vous n'avez pas saisie un nombre, réessayer.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Vous n'avez pas saisie un nombre entre 1 et 6, réessayer.");
            }
        } while (result < min || result > max);

        return result;
    }


    public static void checkInRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException("La valeur doit être entre " + min + " et " + max + " !");
        }
    }

    public static String saisirMot(String mot1, String mot2) {
        Scanner scanner = new Scanner(System.in);
        String motSaisi;
        boolean motValide = false;

        do {
            motSaisi = scanner.nextLine().trim();

            if (motSaisi.equalsIgnoreCase(mot1)) {
                motValide = true;
            } else if (motSaisi.equalsIgnoreCase(mot2)) {
                motValide = true;
            } else {
                System.out.println("Le mot saisi n'est pas valide, réessayer.");
            }
        } while (!motValide);

        return motSaisi;
    }

}

