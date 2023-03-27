package TP5.tableDOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestTableDOperation {
    private final static int CHOIX_MAX = 3;
    private final static int CHOIX_MIN = 1;
    private static final LogManager logManager = LogManager.getLogManager();


    public static void main(String[] args) {

        // Récupération du logger
        Logger LOGGER = Logger.getLogger(TestTableDOperation.class.getPackageName());

        // Configuration du logger
        // (Ou alors => EditConfiguration > Modify options > add VM options : -Djava.util.logging.config.file=conf/debug-logging.properties)
        try {
            logManager.readConfiguration( new FileInputStream("conf/debuglogging.properties") );
        } catch ( IOException exception ) {
            LOGGER.log( Level.SEVERE, "Cannot read configuration file", exception );
        }

        int choix;
        double reponse;
        TableDOperation tableDOperation = null;
        boolean modeSansErreur;

        System.out.println("------------------------------------");
        System.out.println("Bienvenue dans le programme de révision de vos opérations !!".toUpperCase());
        System.out.println("------------------------------------\n");


        // Saisie du choix de l'utilisateur (1, 2 ou 3) pour le type d'opération (addition, soustraction ou multiplication)
        choix = OperationUtilitaire.saisieEntier(CHOIX_MIN, CHOIX_MAX);


        // Saisie du mode de jeu (avec ou sans erreur)
        modeSansErreur = OperationUtilitaire.saisieModeSansErreur();

        // Initialisation de la table d'opération
        if (choix == 1) {
            OperationEnum addition = OperationEnum.ADDITION;
            tableDOperation = new TableDOperation(addition);
            LOGGER.log(Level.INFO, "Type d'opération : Addition");
        } else if (choix == 2) {
            OperationEnum soustraction = OperationEnum.SOUSTRACTION;
            tableDOperation = new TableDOperation(soustraction);
            LOGGER.log(Level.INFO, "Type d'opération : Soustraction");
        } else if (choix == 3) {
            OperationEnum multiplication = OperationEnum.MULTIPLICATION;
            tableDOperation = new TableDOperation(multiplication);
            LOGGER.log(Level.INFO, "Type d'opération : Multiplication");
        }


        // Demande des réponses à l'utilisateur
        System.out.println("\n--- Donner les réponses aux opérations suivantes ---");
        for (int i = 0; i < tableDOperation.getNombreOperation(); i++) {
            // Mode sans erreur
            if (modeSansErreur) {
                    reponse = OperationUtilitaire.saisieDouble(tableDOperation.getOperation(i));
                    do {
                        try {
                            tableDOperation.getOperation(i).setReponseUtilisateur(reponse);
                        } catch (ErreurOperationException e) {
                            System.out.println(e.getMessage());
                            reponse = OperationUtilitaire.saisieDouble(tableDOperation.getOperation(i));
                        }
                    } while (!tableDOperation.getOperation(i).isReponseJuste());
            }else {
                // Mode avec erreur
                reponse = OperationUtilitaire.saisieDouble(tableDOperation.getOperation(i));
                tableDOperation.getOperation(i).setReponseUtilisateurErreur(reponse);
            }
        }


        // Affichage du résultat
        System.out.println("\n--- Résultat ---");
        System.out.println("Vous avez " + tableDOperation.getNombreReponseJuste() + " réponses justes sur " + tableDOperation.getNombreOperation() + " opérations.");
        // rodrimax : pourquoi il aussi bo ?

    }



}
