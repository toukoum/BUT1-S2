package TP2.contrainte;

public class Note extends ReelContraint {
    public Note() {
        super(0, 20);
        setValeur(getMin());
    }

    public Note(double valeur) {
        super(0, 20);
        if (valeur < getMin()) {
            setValeur(getMin());
        } else if (valeur > getMax()) {
            setValeur(getMax());
        }else {
            setValeur(valeur);
        }

    }
}
