package TP3.etudiant;

import TP2.universite.Etudiant;

import java.util.ArrayList;
import java.util.TreeSet;

public class TestOrdreNaturelEtudiant {
    public static void main(String[] args) {

        // Créer les étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "Sanz", "FLORIANT");
        Etudiant etudiant2 = new Etudiant("portepa", "Porte", "Pierre-Antoine");
        Etudiant etudiant3 = new Etudiant("burlatn", "burlat", "nils");
        Etudiant etudiant4 = new Etudiant("test", "Brunet-manquat", "Maxime");
        Etudiant etudiant5 = new Etudiant("testt", "brunet-Manquat", "Raphael");

        // Créer la liste d'étudiants quelconque et ajouter les étudiants
        ArrayList<Etudiant> mesEtudiantsOrdreQcq = new ArrayList<>();

        mesEtudiantsOrdreQcq.add(etudiant1);
        mesEtudiantsOrdreQcq.add(etudiant2);
        mesEtudiantsOrdreQcq.add(etudiant3);
        mesEtudiantsOrdreQcq.add(etudiant4);
        mesEtudiantsOrdreQcq.add(etudiant5);


        // Afficher la liste d'étudiants quelconque
        System.out.println("----------------- Les étudiants non triés ----------------- ");
        UniversiteUtilitaire.affichageEtudiants(mesEtudiantsOrdreQcq);

        // Créer l'ensemble d'étudiants trié et ajouter les étudiants
        TreeSet<Etudiant> mesEtudiantsTries = new TreeSet<>();

        mesEtudiantsTries.add(etudiant1);
        mesEtudiantsTries.add(etudiant2);
        mesEtudiantsTries.add(etudiant3);
        mesEtudiantsTries.add(etudiant4);
        mesEtudiantsTries.add(etudiant5);

        // Afficher l'ensemble d'étudiants trié
        System.out.println("\n----------------- Les étudiants triés ----------------- ");
        UniversiteUtilitaire.affichageEtudiants(mesEtudiantsTries);





    }
}
