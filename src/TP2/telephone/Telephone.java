package TP2.telephone;

import java.util.ArrayList;

public class Telephone {
    private String libelle;
    private Processeur processeur;
    private Memoire memoire;
    private Ecran ecran;

    ArrayList<Memoire> listeRam = new ArrayList<>();

    public Telephone(String libelle, Processeur processeur, Memoire memoire, Ecran ecran) {
        this.libelle = libelle;
        this.processeur = processeur;
        this.memoire = memoire;
        this.ecran = ecran;
    }


    public void addRam(Memoire ram) {
        listeRam.add(ram);
    }

    public int getNombreGigaRam() {
        int somme = 0;
        for (int i = 0; i < listeRam.size(); i++) {
            somme += listeRam.get(i).getNombreGiga();
        }

        return somme;
    }

    @Override
    public String toString() {
        String retour ="";
        retour += (this.libelle + ", processeur = " + this.processeur.getLibelle());
        retour += (", ram = " + getNombreGigaRam() + " [" );
        for (int i = 0; i < listeRam.size(); i++) {
            retour += listeRam.get(i).getType() + " ";
        }
        retour += ("], stockage = " + this.memoire.getType() + ", écran = [" + this.ecran.getType() + ", " + this.ecran.getTaille() + " pouces]");

        return retour;
    }
}
