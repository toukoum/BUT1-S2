package TP3.billeterie;

public class BilletReduit extends Billet{

    private double tauxDeReduction;

    public BilletReduit(Trajet trajet, double prixAuKm, double tauxDeReduction) {
        super(trajet, prixAuKm);
        this.tauxDeReduction = tauxDeReduction;
        setTauxDeReduction(tauxDeReduction);
    }

    public double getTauxDeReduction() {
        return tauxDeReduction;
    }

    public double getPrix() {
        return super.getPrix()* (1-tauxDeReduction);
    }

    public void setTauxDeReduction(double tauxDeReduction) {
        if (tauxDeReduction > 0.5) {
            this.tauxDeReduction = 0.5;
        } else if (tauxDeReduction < 0.05) {
            this.tauxDeReduction = 0.05;
        }
        else {
            this.tauxDeReduction = tauxDeReduction;
        }

    }


    @Override
    public String toString() {
        return "BilletReduit : [" + trajet.toString() + "], prix = " + BilletterieUtilitaire.arrondir(getPrix()) + " euros, avec une réduction de " + tauxDeReduction*100 + "%";
    }
}
