package TP2.universite;

public class UniversiteUtilitaire {



    /**
     * Affiche les données d'une etudiant
     *
     * @void que ce soit un étudiant ou non, les donées sont correctement affiché
     */
    public static void afficheEtudiant(Etudiant etudiant) {
        //affichage des données d'une etudiant

        System.out.println("_____________________");
        System.out.println("Login : " + etudiant.getLogin());
        System.out.println("Nom complet : " + etudiant.getNomComplet());
        System.out.println("Mail : " + etudiant.getMail());
        if (etudiant.getAdresse() == null) {
            System.out.println("Adresse : aucune");
        }
        else {
            System.out.println("Adresse : " + etudiant.getAdresse());
        }
        System.out.println();

        if (etudiant.getListeNotes().size() != 0) {

            for (int i = 0; i < etudiant.getListeNotes().size(); i++) {
                System.out.print(etudiant.getListeNotes().get(i).getValeur() + " ");
            }
            System.out.println("\n");
            System.out.println("Moyenne : " + etudiant.calculMoyenne());

        }
        else {
            System.out.println("Moyenne : Aucune notes donc aucune moyenne !");
            System.out.println("Notes : Aucune notes !");
        }
    }


    /**
     * Affiche les données d'un personnel
     *
     * @void que ce soit un personnel ou non, les donées sont correctement affiché
     */
    public static void affichePersonnel(Personnel personnel) {
        //affichage des données d'un personnel

        System.out.println("_____________________");
        System.out.println("Login : " + personnel.getLogin());
        System.out.println("Nom complet : " + personnel.getNomComplet());
        System.out.println("Mail : " + personnel.getMail());
        if (personnel.getAdresse() == null) {
            System.out.println("Adresse : aucune");
        }
        else {
            System.out.println("Adresse : " + personnel.getAdresse());
        }
        System.out.println("Echelon : " + personnel.getEchelon());
        System.out.println("Point d'indice : " + personnel.getPointdindice());
        System.out.println("Salaire : " + personnel.getSalaire());
    }


    /**
     * Méthode capitalize
     *
     * @return La première lettre de la chaine en majuscule et tout le reste en minuscule
     */
    public static String capitalize(String chaine) {
        //prend en paramètre une chaine de caractères et qui retourne la même
        //chaîne de caractères avec le premier caractère en majuscule et les autres en
        //minuscule


        return chaine.substring(0, 1).toUpperCase() + chaine.substring(1).toLowerCase();

    }

}
