package TP2.universite;

public class UniversiteUtilitaire {



    /**
     * Affiche les données d'une personne
     *
     * @void que ce soit un étudiant ou non, les donées sont correctement affiché
     */
    public static void affichePersonne(Personne personne) {
        //affichage des données d'une personne

        System.out.println("_____________________");
        System.out.println("Login : " + personne.getLogin());
        System.out.println("Nom complet : " + personne.getNomComplet());
        System.out.println("Mail : " + personne.getMail());
        if (personne.getAdresse() == null) {
            System.out.println("Adresse : aucune");
        }
        else {
            System.out.println("Adresse : " + personne.getAdresse());
        }
        System.out.println();
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
        System.out.println("Point d'indice : " + personnel.getPointDIndice());
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
