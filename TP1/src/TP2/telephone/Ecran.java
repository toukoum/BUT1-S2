package TP2.telephone;

public class Ecran {

    private String type;
    private int taille;

    public Ecran(String type, int taille) {
        this.type = type;
        this.taille = taille;
    }

    public String getType() {
        return type;
    }

    public int getTaille() {
        return taille;
    }
}
