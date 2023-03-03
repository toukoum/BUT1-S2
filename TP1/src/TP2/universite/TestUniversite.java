package TP2.universite;

import java.util.ArrayList;

public class TestUniversite {

    public static void main(String[] args) {

        // Création d'une liste de personnes
        ArrayList<Personne> personnes = new ArrayList<>();

        // Création de trois étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "Sanz", "FLORIANT");
        Etudiant etudiant2 = new Etudiant("portepa", "Porte", "Pierre-Antoine");
        Etudiant etudiant3 = new Etudiant("burlatn", "burlat", "nils", "1 rue pas loin", "10 rue des parents");

        // Ajouter l'adresse de ses parents à l'étudiant1
        // Ajouter l'adresse personnelle de l'étudiant2
        etudiant1.setAdresse("13 rue à côté", "23 rue beaucoup plus loin");
        etudiant2.setAdresse("30 avenue Berlioz");

        etudiant1.addNote();
        etudiant1.addNote();
        System.out.println(etudiant1.calculMoyenne());

        ArrayList<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);
        etudiants.add(etudiant3);


        // Ajouter les trois étudiants à la liste
        personnes.add(etudiant1);
        personnes.add(etudiant2);
        personnes.add(etudiant3);

        // Création de deux personnels
        Personnel personnel1 = new Personnel("goulianj", "Goulian", "Jérôme");
        Personnel personnel2 = new Personnel("brunetf", "BrunetManquat", "Francis", 0);
        Personnel personnel3 = new Personnel("lejeuna", "LejeunE", "Anne");
        personnel3.setEchelon(5);
//        personnel3.setPointDIndice(900);

        // Ajouter les personnels à la liste personnes
        personnes.add(personnel1);
        personnes.add(personnel2);
        personnes.add(personnel3);

        // Créer et ajouter les personnels à une liste personnels
        ArrayList<Personnel> personnels = new ArrayList<>();
        personnels.add(personnel1);
        personnels.add(personnel2);
        personnels.add(personnel3);

        System.out.println("------------------------------------------\n PERSONNE\n------------------------------------------");

        // Affichage des personnes
        // Utilisation d'une simplifacation d'écriture avec le for
        for (Etudiant etudiant : etudiants) {
            UniversiteUtilitaire.afficheEtudiant(etudiant);
        }

        System.out.println("------------------------------------------\n PERSONNEL\n------------------------------------------");

        // Affichage du personnel
        for (Personnel personnel : personnels) {
            UniversiteUtilitaire.affichePersonnel(personnel);
        }


    }


}
