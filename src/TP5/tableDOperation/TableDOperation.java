package TP5.tableDOperation;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDOperation {
    private OperationEnum typeOperation;
    private static Logger LOGGER = Logger.getLogger(TableDOperation.class.getPackageName());

    ArrayList<Operation> listeOperation = new ArrayList<>();
    public TableDOperation(OperationEnum typeOperation) {
        this.typeOperation = typeOperation;
        LOGGER.log(Level.INFO, "Initialisation des opérations");
        initialisation();
    }

    private void initialisation() {
        for (int i = 0; i < 5; i++) {
            double terme1 = OperationUtilitaire.randomDouble();
            double terme2 = OperationUtilitaire.randomDouble();

            // ajout de l'operation dans la liste en fonction du type d'operation
            if (typeOperation == OperationEnum.ADDITION) {
                LOGGER.log(Level.INFO, "création d'une addition avec les termes " + terme1 + " et " + terme2);
                Addition addition = new Addition(terme1, terme2);
                listeOperation.add(addition);
            } else if (typeOperation == OperationEnum.SOUSTRACTION) {
                LOGGER.log(Level.INFO, "création d'une soustraction avec les termes " + terme1 + " et " + terme2);
                Soustraction soustraction = new Soustraction(terme1, terme2);
                listeOperation.add(soustraction);
            } else if (typeOperation == OperationEnum.MULTIPLICATION) {
                LOGGER.log(Level.INFO, "création d'une multiplication avec les termes " + terme1 + " et " + terme2);
                Multiplication multiplication = new Multiplication(terme1, terme2);
                listeOperation.add(multiplication);
            }
        }
    }

    public int getNombreReponseJuste() {
        int nombreReponseJuste = 0;
        for (Operation operation : listeOperation) {
            if (operation.isReponseJuste() && operation.getFirstTry() == true) {
                LOGGER.log(Level.INFO, "Une réponse juste de l'utilisateur");
                nombreReponseJuste++;
            } else{
                LOGGER.log(Level.WARNING, "Une réponse fausse de l'utilisateur");
            }
        }
        return nombreReponseJuste;
    }


    public int getNombreOperation() {
        return listeOperation.size();
    }

    public Operation getOperation(int index) {
        return listeOperation.get(index);
    }
}
