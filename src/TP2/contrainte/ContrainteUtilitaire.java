package TP2.contrainte;

import java.util.Scanner;

public class ContrainteUtilitaire {

    public static ReelContraint saisir(double min, double max) {
        Scanner lecteur = new Scanner(System.in);
        double saisie;
        ReelContraint userSaisie;
        userSaisie = new ReelContraint(min, max);

        do {
            System.out.print("Veuillez saisir un Réel compris entre " + min + " et " + max + " : ");
            saisie = lecteur.nextDouble();
            lecteur.nextLine();
            if (saisie > max || saisie < min) {
                System.out.println("Votres réel n'est pas compris dans l'intervalle demandé ! Recommencez.");
            }

        } while (saisie < min || saisie > max);

        userSaisie.setValeur(saisie);

        return userSaisie;
    }

    public static Note saisirNote(double min, double max) {
        Scanner lecteur = new Scanner(System.in);
        double saisie;
        Note userSaisie;
        userSaisie = new Note();

        do {
            System.out.print("Veuillez saisir un Réel compris entre " + min + " et " + max + " : ");
            saisie = lecteur.nextDouble();
            lecteur.nextLine();
            if (saisie > max || saisie < min) {
                System.out.println("Votres réel n'est pas compris dans l'intervalle demandé ! Recommencez.");
            }

        } while (saisie < min || saisie > max);

        userSaisie.setValeur(saisie);

        return userSaisie;
    }
}
