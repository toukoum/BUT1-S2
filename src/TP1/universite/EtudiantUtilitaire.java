package TP1.universite;

public class EtudiantUtilitaire {


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


    /**
     * Affichage
     *
     * @void Affichage détaillé des éléments d'un étudiant
     */
    public static void affiche(Etudiant etudiant) {
        //affichage des données d'un etudiant

        System.out.println("_____________________");
        System.out.println("Login : " + etudiant.getLogin());
        System.out.println("Nom complet : " + etudiant.getNomComplet());
        System.out.println("Mail : " + etudiant.getMail());
        System.out.println("Adresse : " + etudiant.getAdresse());


        if (etudiant.getGroupe() != null) {
            System.out.println("Groupe : " + etudiant.getGroupe().getLibelle());

        }
        else {
            System.out.println("Groupe : Aucun !");
        }


        if (etudiant.getNbreNotes() != 0) {
            System.out.print(etudiant.getNbreNotes() + " Notes : ");
            for (int i = 0; i < etudiant.getNbreNotes(); i++) {
                System.out.print(etudiant.getNotes()[i] + " ");
            }
            System.out.println("\n");
            System.out.println("Moyenne : " + etudiant.getMoyenne());

        }
        else {
            System.out.println("Moyenne : Aucune notes donc aucune moyenne !");
            System.out.println("Notes : Aucune notes !");
        }

    }
}
