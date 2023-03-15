package TP1.jeu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        // Création du plateau
        Plateau plateau = new Plateau(6);

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
        chateauRouge.ajoutGuerrierNovice(GuerrierUtilitaire.createNainRouge());



        //Affichage bienvenu
        PlateauUtilitaire.afficheBienvenu(plateau);

        //Affichage des deux équipes
        System.out.println("\n\u001b[36m---- Listes des Guerriers novice ----\u001b[0m");

        ChateauUtilitaire.afficheGuerrierNovice(chateauBleu);
        System.out.println();
        ChateauUtilitaire.afficheGuerrierNovice(chateauRouge);


        System.out.print("\n\u001b[36m--- Appuyer sur \u001b[0m\u001b[33mentrée \u001b[0m\u001b[36mpour commencer le jeu ---\u001b[0m");
        scanner.nextLine();
        scanner.skip(".*");



        // 4) --Boucle du jeu
        int nbTour = 1;
        int carreauTremblement;
        String mot1 = "o";
        String mot2 = "n";
        String saisieUser;
        boolean bool = true;
        while (!plateau.estPartieTerminee()) {
            System.out.println("Plateau (Tour " + nbTour + ")\n");

            ChateauUtilitaire.afficheEntrainement(plateau, chateauBleu);
            ChateauUtilitaire.afficheEntrainement(plateau, chateauRouge);

            System.out.println("\n\n\u001b[36m----- Plateau (avant déplacement)-----\u001b[0m\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);

            //déplacement
            plateau.deplaceGuerrier();

            System.out.println("\n\n\u001b[36m----- Plateau (après déplacement)-----\u001b[0m\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);

            // tremblement de terre #1
            System.out.println("TREMBLEMENT DE TERRE pour les Bleus");
            carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
            plateau.lanceTremblement(carreauTremblement-1, chateauRouge);

            // tremblement de terre #2
            System.out.println("TREMBLEMENT DE TERRE pour les Rouges");
            carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
            plateau.lanceTremblement(carreauTremblement-1, chateauBleu);


            nbTour++;
            System.out.println("\n\u001b[36m--- Appuyer sur entrée pour Jouer le tour \u001b[0m\u001b[33m" + nbTour + "\u001b[0m\u001b[36m ---\u001b[0m");
            scanner.nextLine();
            scanner.skip(".*");

//            System.out.println();
//            System.out.println("Voulez vous continuez ? (o, n) : ");

//            saisieUser = PlateauUtilitaire.saisirMot(mot1, mot2);
//            if (saisieUser.compareTo("n") == 0) {
//                try {
//                    saveGame(plateau, "enregistrementPartie");
//                    bool = false;
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            if (!bool) {
//                break;
//            }
//        }

        PlateauUtilitaire.afficheGagnant(plateau);

//        try {
//            loadGame("enregistrementPartie");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

//    public static void saveGame(Plateau plateau, String filename) throws IOException {
//        Gson gson = new Gson();
//        String json = gson.toJson(plateau);
//        FileWriter writer = new FileWriter(filename);
//        writer.write(json);
//        writer.close();
//    }
//
//    public static Plateau loadGame(String filename) throws IOException {
//        Gson gson = new Gson();
//        FileReader reader = new FileReader(filename);
//        Plateau plateau = gson.fromJson(reader, Plateau.class);
//        reader.close();
//        return plateau;
//    }
}
}
