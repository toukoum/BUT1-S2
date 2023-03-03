package TP2.universite;

import TP2.contrainte.ContrainteUtilitaire;
import TP2.contrainte.ReelContraint;

public class Personnel extends Personne {
    private int echelon;
    private ReelContraint pointDIndice;
    public static final int ECHELON_MIN = 1;
//    public static final int POINTDINDICEMIN = 1000;

    public Personnel(String login, String nom, String prenom) {
        super(login, nom, prenom);
        setEchelon(ECHELON_MIN);
//        setPointDIndice(POINTDINDICEMIN);
        this.pointDIndice = ContrainteUtilitaire.saisir(1000, 1200);

    }

    public Personnel(String login, String nom, String prenom, int echelon) {
        super(login, nom, prenom);
        this.echelon = echelon;
        this.pointDIndice = ContrainteUtilitaire.saisir(1000, 1200);
        setEchelon(echelon);
//        setPointDIndice(pointDIndice);

    }

    public int getEchelon() {
        return echelon;
    }


    public double getPointdindice() {
        return pointDIndice.getValeur();
    }

    public double getSalaire() {
        return getEchelon() * pointDIndice.getValeur();
    }

    public void setEchelon(int echelon) {
        if (echelon > 4) {
            echelon = 4;
        } else if (echelon < 1) {
            echelon = 1;
        }
        this.echelon = echelon;
    }

   /* public void setPointDIndice(double pointDIndice) {
        if (pointDIndice > 1200) {
            pointDIndice = 1200;
        } else if (pointDIndice < 1000) {
            pointDIndice = 1000;
        }
        this.pointDIndice = pointDIndice;
    }*/

    /**
     * Méthode de redéfinition de la méthode getMail de la classe Personne
     *
     * @return Une chaîne de caractères correspondant à
     * "prenom.nom@etu.univ-grenoble-alpes.fr" (rajoute le "etu." si c'est un étudiant)
     */
    @Override
    public String getMail() {
        return getPrenom() + "." + getNom() + "@univ-grenoble-alpes.fr";
    }
}
