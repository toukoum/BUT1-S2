package TP3.billeterie;

public class Billet {
    private double prixAuKm;

    Trajet trajet;
    public Billet(Trajet trajet, double prixAuKm) {
        this.prixAuKm = prixAuKm;
        this.trajet = trajet;
        setPrixAuKm(prixAuKm);
    }

    public String getDepart() {
        return trajet.getDepart();
    }

    public String getArrivee() {
        return trajet.getArrivee();
    }

    public int getDistance() {
        return trajet.getDistance();
    }

    public double getPrixAuKm() {
        return prixAuKm;
    }

    public double getPrix() {
        double prix = getDistance() * getPrixAuKm();
        return prix;
    }



    public void setPrixAuKm(double prixAuKm) {
        if (prixAuKm > 2) {
            this.prixAuKm = 2;
        } else if (prixAuKm < 0.1) {
            this.prixAuKm = 0.1;
        }
        else {
            this.prixAuKm = prixAuKm;
        }
    }

    @Override
    public String toString() {
        return "Billet : [" + trajet.toString() + "], prix = " + BilletterieUtilitaire.arrondir(getPrix()) + " euros";
    }
}
