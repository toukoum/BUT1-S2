package TP5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestLogging {
    // Récupérarion du gestionnaire de logs.
    private static final LogManager logManager = LogManager.getLogManager();
    public static void main(String[] args) {

        // Récupération du logger
        Logger LOGGER = Logger.getLogger(TestLogging.class.getName());


        // Configuration du logger
        // (Ou alors => EditConfiguration > Modify options > add VM options : -Djava.util.logging.config.file=conf/debuglogging.properties)
        try {
            logManager.readConfiguration( new FileInputStream("conf/debuglogging.properties") );
        } catch ( IOException exception ) {
            LOGGER.log( Level.SEVERE, "Cannot read configuration file", exception );
        }



        LOGGER.log(Level.INFO, "Mon premier log !");


        // réaliser une division avec un dividende random entre 0 et 9 (compris)
        // et un diviseur random entre 0 et 2 (compris)

        int dividende = (int) (Math.random() * 10);
        int diviseur = (int) (0);
        int quotient = 0;



        LOGGER.log(Level.WARNING, "Attention, une division par zéro est possible !");

        try {
            quotient = dividende / diviseur;
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, "Division par zéro !", e);
        }

        Object[] data = {dividende, diviseur, quotient};
        LOGGER.log(Level.WARNING, "Dividende : {0}, Diviseur : {1}, Quotient : {2}", data);



    }
}
