package TP3.etudiant;

import TP2.universite.Etudiant;
import TP2.universite.Groupe;

public class TestEtudiantGroupe {
    public static void main(String[] args) {

        // Créer des groupes
        Groupe groupeA = new Groupe("A");
        Groupe groupeB = new Groupe("B");


        // Créer des étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "Sanz", "FLORIANT");
        Etudiant etudiant2 = new Etudiant("portepa", "Porte", "Pierre-Antoine");
        Etudiant etudiant3 = new Etudiant("burlatn", "burlat", "nils");
        Etudiant etudiant4 = new Etudiant("test", "Brunet-manquat", "Maxime");
        Etudiant etudiant5 = new Etudiant("testt", "brunet-Manquat", "Raphael");


        // Ajouter TOUS les étudiants au groupe A
        // ATTENTION à ne pas boucler à cause de l'association bidirectionnelle !
        groupeA.addEtudiant(etudiant1);
        groupeA.addEtudiant(etudiant1); // On ajoute plusieurs fois le même étudiant
        groupeA.addEtudiant(etudiant1); //
        groupeA.addEtudiant(etudiant2);
        groupeA.addEtudiant(etudiant3);


        groupeA.addEtudiant(etudiant4);
        groupeA.addEtudiant(etudiant5);
//
//
//        // Ajouter les deux derniers étudiants au groupe B
        etudiant4.setGroupe(groupeB);
        etudiant5.setGroupe(groupeB);


        // Afficher les étudiants du groupe A
        System.out.println("---------");
        System.out.println("Etudiants du Groupe A");
        for (Etudiant etudiant : groupeA.getEtudiants()) {
            System.out.println(etudiant.getGroupe().getLibelle() + " " +
                    etudiant.getNom() + " " + etudiant.getPrenom());
        }

        // Afficher les étudiants du groupe B
        System.out.println("---------");
        System.out.println("Etudiants du Groupe B");
        for (Etudiant etudiant : groupeB.getEtudiants()) {
            System.out.println(etudiant.getGroupe().getLibelle() + " " +
                    etudiant.getNom() + " " + etudiant.getPrenom());
        }
    }
}
