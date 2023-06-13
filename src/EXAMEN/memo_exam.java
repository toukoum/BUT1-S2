package EXAMEN;

import java.util.*;

public class memo_exam {
    public static void main(String[] args) {
        /*saisirNombre(0, 20);
        saisirNombre2(0, 20);*/

        /*boolean bool = true;
        do {
            try {
                testEx();
            } catch (exc e) {
                System.out.println(e);
                bool = false;
            }

        }while(!bool);*/

        compteMot("Le chien mange sa nourriture, mais le chien est gentil.");

    }

    public static void compteMot(String phrase) {

        HashMap<String, Integer> compteur = new HashMap<>();
        for (String mot : phrase.split(" ")) {
            if (compteur.containsKey(mot)) {
                compteur.put(mot, compteur.get(mot)+1);
            }else {
                compteur.put(mot, 1);
            }

        }


        for (String mot : compteur.keySet()) {
            System.out.println(mot + ":" + compteur.get(mot));
        }

    }



    public static int saisirNombre(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int valeur;

        do {
            System.out.print("Veuillez saisir un nombre entre " + min + " et " + max + " : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Erreur : Vous devez saisir un nombre !");
                System.out.print("Veuillez saisir un nombre entre " + min + " et " + max + " : ");
                scanner.next();
            }
            valeur = scanner.nextInt();

            if (valeur < min || valeur > max) {
                System.out.println("Erreur : La valeur saisie est hors de l'intervalle [" + min + ", " + max + "] !");
            }
        } while (valeur < min || valeur > max);

        return valeur;
    }

    public static int saisirNombre2(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int valeur;

        do {
            try {
                System.out.print("Veuillez saisir un nombre entre " + min + " et " + max + " : ");
                valeur = scanner.nextInt();

                if (valeur < min || valeur > max) {
                    System.out.println("Erreur : La valeur saisie est hors de l'intervalle [" + min + ", " + max + "] !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Vous devez saisir un nombre !");
                scanner.next(); // Vider la saisie incorrecte du scanner
                valeur = min - 1; // Affecter une valeur incorrecte pour que la boucle continue
            }
        } while (valeur < min || valeur > max);

        return valeur;
    }


    public static void testEx () throws exc {
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Veuillez saisir un nombre en dessous de 10 :");

        int nb = lecteur.nextInt();

        if (nb > 10) {
            throw new exc(nb);
        }else {
            System.out.println("Bravo votre chiffre est au dessus de 10");
        }
    }


}
