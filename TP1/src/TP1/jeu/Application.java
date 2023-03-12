package TP1.jeu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Création du plateau
        Plateau plateau = new Plateau(5);

        // Création des chateau bleu et rouge
        Chateau chateauBleu = new Chateau(Couleur.Bleu);
        Chateau chateauRouge = new Chateau(Couleur.Rouge);

        //Initialisation des équipes
        //Rouge
        chateauBleu.ajoutGuerrierNovice(GuerrierUtilitaire.createNainBleu());
        chateauBleu.ajoutGuerrierNovice(GuerrierUtilitaire.createElfeBleu());
        chateauBleu.ajoutGuerrierNovice(GuerrierUtilitaire.createChefElfeBleu());

        //Bleu
        chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.createNainRouge());
        chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.createElfeRouge());
        chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.createChefNainRouge());

        //Affichage des deux équipes
        ChateauUtilitaire.afficheGuerrierNovice(chateauBleu);
        ChateauUtilitaire.afficheGuerrierNovice(chateauRouge);


        System.out.println("\n--- Appuyer sur entrée pour commencer le jeu ---");
        scanner.nextLine();
        

        ////
        // 4) --Boucle du jeu
        //while (---) {

            // Affichage du numéro de tour

            ////
            // 4.1) -- Entraînement et mise en jeu des Guerriers entraînés

            ////
            // 4.2) -- Tous les Guerriers des deux camps avance d'un Carreau
            //           sauf s'il y a un ou plusieurs Guerriers du
            //           camp adverse sur leur Carreau


            ////
            // 4.3) -- Lancer les combats + affichage des combats (et des morts)

        //}

        ////
        // 5) -- Affichage de l'équipe gagnate

    }
}
