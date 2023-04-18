package TP1.jeu;

import java.io.*;
import java.util.Scanner;

/**
 * @Class Application
 * <p>
 *    Classe principale du jeu Faerun
 *    Utilise la serialisation BINAIRE pour sauvegarder les données de la partie en cours
 *    Elle permet de lancer le jeu et de sauvegarder la partie en cours
 *    Elle permet aussi de reprendre une partie sauvegardée
 */
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
            // On essaie de charger les données de la partie que l'on souhaite reprendre
            try {
                plateau = loadGamePlateau("enregistrementPartiePlateau");
                chateauBleu = loadGameChateau("enregistrementPartieChateauBleu");
                chateauRouge = loadGameChateau("enregistrementPartieChateauRouge");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Si une partie est en cours, on demande si on veut la reprendre
        if (plateau != null) {
            System.out.print("Voulez vous reprendre la partie commencée précedemment ? (o,n) : ");
            saisieUser = PlateauUtilitaire.saisirMot("o", "n");
            if (saisieUser.compareTo("o") == 0) {
                run(plateau, chateauBleu, chateauRouge, false);

            }else{
                // sinon on supprime les fichiers de sauvegarde et on lance une nouvelle partie
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
            // Si aucune n'a été sauvergardé, on lance une nouvelle partie
            chateauBleu = new Chateau(Couleur.Bleu);
            chateauRouge = new Chateau(Couleur.Rouge);
            plateau = new Plateau(6);
            run(plateau, chateauBleu, chateauRouge, true);
        }

        // une fois la partie terminée, on affiche le gagnant
        PlateauUtilitaire.afficheGagnant(plateau);

        // si la partie est terminée, on supprime les fichiers de sauvegarde
        if (plateau.estPartieTerminee()) {
            if (plateauSave.exists() && chateauBleuSave.exists() && chateauRougeSave.exists()) {
                chateauBleuSave.delete();
                chateauRougeSave.delete();
                plateauSave.delete();
            }
        }

    }

    public static void saveGamePlateau(Plateau plateau, String filename) throws IOException {
        // sauvegarde de la partie en cours (plateau)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(plateau);
        }
    }

    public static void saveGameChateau(Chateau chateau, String filename) throws IOException {
        // sauvegarde de la partie en cours (chateau)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(chateau);
        }
    }

    public static Plateau loadGamePlateau(String filename) throws IOException, ClassNotFoundException {
        // chargement de la partie en cours (plateau)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Plateau) in.readObject();
        }
    }

    public static Chateau loadGameChateau(String filename) throws IOException, ClassNotFoundException {
        // chargement de la partie en cours (chateau)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Chateau) in.readObject();
        }
    }


    /**
     * Méthode qui permet de lancer le jeu
     * @param plateau
     * @param chateauBleu
     * @param chateauRouge
     * @param nouvellePartie
     * @return void
     * lance le jeu et permet de sauvegarder la partie en cours
     */
    public static void run(Plateau plateau, Chateau chateauBleu, Chateau chateauRouge, boolean nouvellePartie) {
        //

        Scanner scanner = new Scanner(System.in);


        if (nouvellePartie) {
            // seulement si c'est une nouvelle partie, on initialise les équipes, on affiche Bienvenu et on affiche les chateau.
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


            //Mode tremblement de terre ou pas ?
            System.out.print("\u001b[36mVoulez vous activer le mode tremblement de terre ? (o,n) : \u001b[0m");
            String saisieUser = PlateauUtilitaire.saisirMot("o", "n");
            if (saisieUser.compareTo("o") == 0) {
                plateau.setModeTremblement(true);
            } else {
                plateau.setModeTremblement(false);
            }

            //Affichage des deux équipes
            System.out.println("\n\u001b[36m---- Listes des Guerriers novice ----\u001b[0m");

            ChateauUtilitaire.afficheGuerrierNovice(chateauBleu);
            System.out.println();
            ChateauUtilitaire.afficheGuerrierNovice(chateauRouge);


            System.out.print("\n\u001b[36m--- Appuyer sur \u001b[0m\u001b[33mentrée \u001b[0m\u001b[36mpour commencer le jeu ---\u001b[0m");
            scanner.nextLine();


        }

        // --Boucle du jeu--
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


            if (plateau.getModeTremblement()) {
                int carreauTremblement;
                // tremblement de terre #1
                System.out.println("\u001b[34mTREMBLEMENT DE TERRE pour les Bleus\u001b[0m");
                carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
                plateau.lanceTremblement(carreauTremblement-1, chateauRouge);

                // tremblement de terre #2
                System.out.println("\n\u001b[31mTREMBLEMENT DE TERRE pour les Rouges\u001b[0m");
                carreauTremblement = PlateauUtilitaire.saisirnombre(1, plateau.getPlateauCarreau().size());
                plateau.lanceTremblement(carreauTremblement-1, chateauBleu);

            }




            plateau.incrementeNbTour();

            System.out.print("\nVoulez vous continuez ? (o, n) : ");
            saisieUser = PlateauUtilitaire.saisirMot("o", "n");


            if (saisieUser.compareTo("n") == 0) {
                // sauvegarde de la partie en cours
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

