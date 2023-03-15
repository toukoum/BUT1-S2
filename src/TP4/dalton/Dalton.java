package TP4.dalton;

import java.util.Comparator;

public class Dalton implements Comparable<Dalton> {


    private Taille taille;
    private String nom;

    public Dalton(String nom, Taille taille) {
        this.nom = nom;
        this.taille = taille;
    }

    public Taille getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }


    @Override
    public int compareTo(Dalton o) {
        // Compare by taille, then by nom
        int result = this.taille.compareTo(o.taille);
        if (result == 0) {
            result = this.nom.compareTo(o.nom);
        }
        return result;
    }
}
