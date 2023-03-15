package TP3.etudiant;

import TP2.universite.Etudiant;

import java.util.Collection;

public class UniversiteUtilitaire {

    public static void affichageEtudiants(Collection<Etudiant> etudiants) {
            //affichage du nom et du prénom de chaque étudiant présent dans la collection etudiants
            for(Etudiant etudiant : etudiants) {
                System.out.println(etudiant.getNom() + ", " + etudiant.getPrenom());
        }
    }

    public static void affichageEtudiants2(Collection<Etudiant> etudiants) {
            //affichage du nom et du prénom de chaque étudiant présent dans la collection etudiants
            for(Etudiant etudiant : etudiants) {
                System.out.println("Moyenne = "  + etudiant.calculMoyenne() + " : " + etudiant.getNom() + ", " + etudiant.getPrenom());
        }
    }
}
