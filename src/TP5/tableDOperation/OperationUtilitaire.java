package TP5.tableDOperation;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class OperationUtilitaire {
    private static final Random random = new Random();
    private static final int RANGE_MAX = 200;
    private static final int ARRONDI = 10;


    // Retourne une valeur de type double entre 0 et RANGE_MAX/ARRONDI
    public static double randomDouble() {
        return (double)random.nextInt(RANGE_MAX)/ARRONDI;
    }


    // Retourne la valeur double arrondi
    // Evite les erreurs de calcul du au double en Java
    public static double arrondir(double valeur) {
        return (double)Math.round(valeur * ARRONDI) / ARRONDI;
    }

    public static int saisieEntier(int CHOIX_MIN, int CHOIX_MAX){
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        System.out.println("----- Choix de l'opération -----");

        System.out.println("1 - Addition");
        System.out.println("2 - Soustraction");
        System.out.println("3 - Multiplication");


        // vérification de la saisie de l'utilisateur
        do {
            try {
                System.out.print("\nVeuillez choisir une opération : ");
                choix = scanner.nextInt();
                scanner.nextLine();
                checkInRange(choix, CHOIX_MIN, CHOIX_MAX);
            } catch (InputMismatchException e) {
                System.out.println("Vous devez saisir un nombre, veuillez recommencer.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (choix < CHOIX_MIN || choix > CHOIX_MAX);


        return choix;
    }


    public static void checkInRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException("La valeur doit être entre " + min + " et " + max + " ! Veuillez recommencer.");
        }
    }

    public static double saisieDouble(Operation operation) {
        // saisie de l'utilisateur pour vérifier que ce soit un double
        Scanner scanner = new Scanner(System.in);
        double nombre = 0.0;
        boolean saisieValide = false;
        while (!saisieValide) {
            try {
                System.out.print(operation.toString());
                nombre = scanner.nextDouble();
                saisieValide = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous devez saisir un nombre (double), veuillez recommencer.\n");
                scanner.nextLine();
            }
        }
        return nombre;

    }

    public static boolean saisieModeSansErreur() {
        Scanner scanner = new Scanner(System.in);
        boolean saisieValide = false;
        int choix = 0;

        System.out.println("\n----- Choix du mode d'entrainement -----");


        // vérification de la saisie de l'utilisateur pour le mode de jeur (sans erreur ou avec erreur)
        while (!saisieValide) {
            try {
                System.out.println("1 - Sans erreur");
                System.out.println("2 - Avec erreur");
                System.out.print("\nVeuillez choisir le mode de jeu : ");
                choix = scanner.nextInt();
                checkInRange(choix, 1, 2);
                scanner.nextLine();
                saisieValide = true;
            }catch (InputMismatchException e) {
                System.out.println("Vous devez saisir soit 1 soit 2 ! veuillez recommencer.\n");
                scanner.nextLine();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return choix == 1;
    }
}