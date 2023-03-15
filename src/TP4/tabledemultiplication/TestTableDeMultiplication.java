package TP4.tabledemultiplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTableDeMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombreTable = 0;
        int melange = 0;
        boolean mlg;
        int reponseUtilisateur;


        do {
            try {
                System.out.print("Donner un nombre pour la table de multiplication entre 10 et 20 : ");
                nombreTable = scanner.nextInt();
                scanner.nextLine(); // pour consommer la fin de ligne
                checkInRange(nombreTable, 11, 20);
            } catch (InputMismatchException f) {
                System.out.println("Veuillez entrer un nombre !");
                scanner.nextLine(); // pour vider la ligne erronée
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (nombreTable < 11 || nombreTable > 20);




        do {
            try {
                System.out.print("Mode Entrainement (1) ou Mode exercice (2) : ");
                melange = scanner.nextInt();
                scanner.nextLine();
                checkInRange(melange, 1, 2);
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrez un nombre !!!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (melange < 1 || melange > 2);


        if (melange == 1) {
            mlg = false;
        }else {
            mlg = true;
        }

        TableDeMultiplication tableDeMultiplication = new TableDeMultiplication(nombreTable, mlg);

        System.out.println("Donner les réponses aux multiplications : ");
        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    System.out.print(tableDeMultiplication.getMultiplication(i));
                    reponseUtilisateur = scanner.nextInt();
                    scanner.nextLine();
                    tableDeMultiplication.getMultiplication(i).setReponseUtilisateur(reponseUtilisateur);
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Veuillez rentrez un nombre !!");
                    scanner.nextLine();
                } catch (ErreurMultiplicationException e) {
                    System.out.println("Pas la bonne réponse, réessayer !");
                }
            }
        }
        System.out.println("\nNombre de réponses justes : " + tableDeMultiplication.getNombreReponsesJustes());
    }

    public static void checkInRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException("La valeur doit être entre " + min + " et " + max + " !");
        }
    }
}
