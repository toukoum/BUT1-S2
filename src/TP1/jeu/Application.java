package TP1.jeu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        // Création du plateau
        Plateau plateau = new Plateau(10);

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
        chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.createChefElfeRouge());

        //Affichage bienvenu
        PlateauUtilitaire.afficheBienvenu(plateau);

        //Affichage des deux équipes
        ChateauUtilitaire.afficheGuerrierNovice(chateauBleu);
        ChateauUtilitaire.afficheGuerrierNovice(chateauRouge);


        System.out.print("\n--- Appuyer sur entrée pour commencer le jeu ---");
        scanner.nextLine();
        scanner.skip(".*");



        ////
        // 4) --Boucle du jeu
        int nbTour = 1;
        while (!plateau.estPartieTerminee()) {
            System.out.println("Plateau (Tour " + nbTour + ")\n");

            ChateauUtilitaire.afficheEntrainement(plateau, chateauBleu);
            ChateauUtilitaire.afficheEntrainement(plateau, chateauRouge);

            System.out.println("\n\n----- Plateau (avant déplacement)-----\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);
            plateau.deplaceGuerrier();

            System.out.println("\n\n----- Plateau (après déplacement)-----\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);



            nbTour++;
            System.out.println("\n--- Appuyer sur entrée pour Jouer le tour " + nbTour + " ---");
            scanner.nextLine();
            scanner.skip(".*");

        }

        System.out.println("BRAVO AUX " + plateau.getGagnant() + " !!! Vous avez gagné un saxophone. A récuperer chez vous");

    }
}
