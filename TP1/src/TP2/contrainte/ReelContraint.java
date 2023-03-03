package TP2.contrainte;

public class ReelContraint {

    private double min;
    private double max;
    private double valeur;

    public ReelContraint(double min, double max) {
        this.min = min;
        this.max = max;
        setValeur(min);
    }

    public void setValeur(double valeur) {
        if (valeur >= min && valeur <= max) {
            this.valeur = valeur;
        }
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getValeur() {
        return valeur;
    }



    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return ("=> Valeur : " + this.valeur + ", min : " + this.min + ", max : " + this.max);
    }
}
