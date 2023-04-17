package TP2.universite;

import java.util.TreeSet;

public class Groupe {


    private TreeSet<Etudiant> etudiants = new TreeSet<>();
    private String libelle;


    public Groupe(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }


    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.setGroupe(this);
    }

    public void removeEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    public TreeSet<Etudiant> getEtudiants() {
        return etudiants;
    }
}
