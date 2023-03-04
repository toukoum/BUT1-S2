package TP2.universite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Groupe {


    private TreeSet<Etudiant> Etudiants = new TreeSet<>();
    private String libelle;


    public Groupe(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void addEtudiant(Etudiant etudiant) {
        if (!containsEtudiant(etudiant)) {
            Etudiants.add(etudiant);
            etudiant.setGroupe(this);
        }
    }

    public void removeEtudiant(Etudiant etudiant) {
        Iterator<Etudiant> iterator = Etudiants.iterator();
        while (iterator.hasNext()) {
            Etudiant e = iterator.next();
            if (e.equals(etudiant)) {
                iterator.remove();
                break;
            }
        }
    }


    public boolean containsEtudiant(Etudiant etudiant) {
        for (Etudiant e : Etudiants) {
            if (e.equals(etudiant)) {
                return true;
            }
        }
        return false;
    }

    public TreeSet<Etudiant> getEtudiants() {
        return Etudiants;
    }
}
