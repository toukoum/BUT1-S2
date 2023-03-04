package TP3.etudiant;

import TP2.universite.Etudiant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestEtudiantTriMoyenne {

    /**
     * @Comparator compEtudiantTriMoyenne
     * <p>
     * compare la moyenne de deux étudiants
     */
    public static final Comparator<Etudiant> CompEtudiantTriMoyenne = new Comparator<Etudiant>() {
        @Override
        public int compare(Etudiant o1, Etudiant o2) {
            if (o1.calculMoyenne() < o2.calculMoyenne()) {
                return -1;
            } else if (o1.calculMoyenne() == o2.calculMoyenne()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    };

    public static void main(String[] args) {

        // Créer les étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "Sanz", "FLORIANT");
        Etudiant etudiant2 = new Etudiant("portepa", "Porte", "Pierre-Antoine");
        Etudiant etudiant3 = new Etudiant("burlatn", "burlat", "nils");
        Etudiant etudiant4 = new Etudiant("test", "Brunet-manquat", "Maxime");
        Etudiant etudiant5 = new Etudiant("testt", "brunet-Manquat", "Raphael");

        // Ajouter des notes aux étudiants
        etudiant1.addNote();
        etudiant2.addNote();
        etudiant3.addNote();
        etudiant4.addNote();
        etudiant5.addNote();

        // Créer la liste d'étudiants et ajouter les étudiants
        ArrayList<Etudiant> mesEtudiantsTries = new ArrayList<>();

        mesEtudiantsTries.add(etudiant1);
        mesEtudiantsTries.add(etudiant2);
        mesEtudiantsTries.add(etudiant3);
        mesEtudiantsTries.add(etudiant4);
        mesEtudiantsTries.add(etudiant5);


        // Afficher la liste des étudiants avant tri
        System.out.println("\n----------------- Les étudiants avant tri ----------------- ");
        UniversiteUtilitaire.affichageEtudiants2(mesEtudiantsTries);


        // trier la liste
        Collections.sort(mesEtudiantsTries, CompEtudiantTriMoyenne);



        // Afficher la liste des étudiants après tri
        System.out.println("\n----------------- Les étudiants après tri ----------------- ");
        UniversiteUtilitaire.affichageEtudiants2(mesEtudiantsTries);

    }

}
