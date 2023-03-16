package TP1.jeu;

import java.io.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String saisieUser;
        Plateau plateau = null;
        Chateau chateauRouge = null;
        Chateau chateauBleu = null;
        File plateauSave = new File("enregistrementPartiePlateau");
        File chateauBleuSave = new File("enregistrementPartieChateauBleu");
        File chateauRougeSave = new File("enregistrementPartieChateauRouge");

        if (plateauSave.exists() && chateauBleuSave.exists() && chateauRougeSave.exists()) {
            try {
                plateau = loadGamePlateau("enregistrementPartiePlateau");
                chateauBleu = loadGameChateau("enregistrementPartieChateauBleu");
                chateauRouge = loadGameChateau("enregistrementPartieChateauRouge");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (plateau != null) {
            System.out.print("Voulez vous reprendre la partie commencée précedemment ? (o,n) : ");
            saisieUser = PlateauUtilitaire.saisirMot("o", "n");
            if (saisieUser.compareTo("o") == 0) {
                run(plateau, chateauBleu, chateauRouge, false);
            }else{
                chateauBleuSave.delete();
                chateauRougeSave.delete();
                plateauSave.delete();
                System.out.println("NOUVELLE PARTIE !");

                // Création des chateau bleu et rouge
                chateauBleu = new Chateau(Couleur.Bleu);
                chateauRouge = new Chateau(Couleur.Rouge);
                plateau = new Plateau(6);
                run(plateau, chateauBleu, chateauRouge, true);
            }
        }else {
            chateauBleu = new Chateau(Couleur.Bleu);
            chateauRouge = new Chateau(Couleur.Rouge);
            plateau = new Plateau(6);
            run(plateau, chateauBleu, chateauRouge, true);
        }

        PlateauUtilitaire.afficheGagnant(plateau);
        if (plateau.estPartieTerminee()) {

            if (plateauSave.exists() && chateauBleuSave.exists() && chateauRougeSave.exists()) {
                chateauBleuSave.delete();
                chateauRougeSave.delete();
                plateauSave.delete();
            }
        }

    }

    public static void saveGamePlateau(Plateau plateau, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(plateau);
        }
    }

    public static void saveGameChateau(Chateau chateau, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(chateau);
        }
    }

    public static Plateau loadGamePlateau(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Plateau) in.readObject();
        }
    }

    public static Chateau loadGameChateau(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Chateau) in.readObject();
        }
    }

    public static void run(Plateau plateau, Chateau chateauBleu, Chateau chateauRouge, boolean nouvellePartie) {

        Scanner scanner = new Scanner(System.in);


        if (nouvellePartie) {


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
            System.out.println("\n\u001b[36m---- Listes des Guerriers novice ----\u001b[0m");

            ChateauUtilitaire.afficheGuerrierNovice(chateauBleu);
            System.out.println();
            ChateauUtilitaire.afficheGuerrierNovice(chateauRouge);


            System.out.print("\n\u001b[36m--- Appuyer sur \u001b[0m\u001b[33mentrée \u001b[0m\u001b[36mpour commencer le jeu ---\u001b[0m");
            scanner.nextLine();
            scanner.skip(".*");


        }

        // 4) --Boucle du jeu
        int carreauTremblement;
        String saisieUser;
        boolean bool = true;
        while (!plateau.estPartieTerminee() && bool) {
            System.out.println("Plateau (Tour " + plateau.getNbTour() + ")\n");

            ChateauUtilitaire.afficheEntrainement(plateau, chateauBleu);
            ChateauUtilitaire.afficheEntrainement(plateau, chateauRouge);

            System.out.println("\n\n\u001b[36m----- Plateau (avant déplacement)-----\u001b[0m\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);

            //déplacement
            plateau.deplaceGuerrier();

            System.out.println("\n\n\u001b[36m----- Plateau (après déplacement)-----\u001b[0m\n");
            PlateauUtilitaire.affichePlateau(plateau.getPlateauCarreau(), chateauBleu, chateauRouge);

            // tremblement de terre #1
            System.out.println("\u001b[34mTREMBLEMENT DE TERRE pour les Bleus\u001b[0m");
            carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
            plateau.lanceTremblement(carreauTremblement-1, chateauRouge);

            // tremblement de terre #2
            System.out.println("\n\u001b[31mTREMBLEMENT DE TERRE pour les Rouges\u001b[0m");
            carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
            plateau.lanceTremblement(carreauTremblement-1, chateauBleu);


            plateau.incrementeNbTour();
//            System.out.println("\n\u001b[36m--- Appuyer sur entrée pour Jouer le tour \u001b[0m\u001b[33m" + nbTour + "\u001b[0m\u001b[36m ---\u001b[0m");
//            scanner.nextLine();
//            scanner.skip(".*");

            System.out.println("\nVoulez vous continuez ? (o, n) : ");
            saisieUser = PlateauUtilitaire.saisirMot("o", "n");


            if (saisieUser.compareTo("n") == 0) {
                try {
                    saveGamePlateau(plateau, "enregistrementPartiePlateau");
                    saveGameChateau(chateauBleu, "enregistrementPartieChateauBleu");
                    saveGameChateau(chateauRouge, "enregistrementPartieChateauRouge");
                    bool = false;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

