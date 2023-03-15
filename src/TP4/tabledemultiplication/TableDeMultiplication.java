package TP4.tabledemultiplication;

import java.util.ArrayList;
import java.util.Collections;

public class TableDeMultiplication {
    ArrayList<Multiplication> listeMultiplications = new ArrayList<>();
    private int nombreTable;




    public TableDeMultiplication(int nombreTable, boolean estMelange) {
        this.nombreTable = nombreTable;
        initialisation();
        if (estMelange) {
            melange();
        }
    }

    private void initialisation() {
        for (int i = 0; i < 10; i++) {
            listeMultiplications.add(new Multiplication(nombreTable, i));
        }
    }

    public void melange() {
        Collections.shuffle(listeMultiplications);
    }

    public int getNombreReponsesJustes() {
        int sommeJuste = 0;

        for (Multiplication multiplication : listeMultiplications) {
            if (multiplication.isReponseJuste2()) {
                sommeJuste +=1;
            }
        }
        return sommeJuste;
    }

    public int getNombreTableDeMultiplications() {
        return nombreTable;
    }

    public Multiplication getMultiplication(int index) {
        return listeMultiplications.get(index);

    }


}
