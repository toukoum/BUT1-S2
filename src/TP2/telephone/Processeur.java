package TP2.telephone;

public class Processeur {
    private String libelle;
    private double frequence;

    public Processeur(String libelle, double frequence) {
        this.libelle = libelle;
        this.frequence = frequence;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getFrequence() {
        return frequence;
    }
}
