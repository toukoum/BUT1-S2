package tp1.universite;

public class EtudiantUtilitaire {

    public static String capitalize(String chaine) {
        //prend en paramètre une chaine de caractères et qui retourne la même
        //chaîne de caractères avec le premier caractère en majuscule et les autres en
        //minuscule


        StringBuilder sb = new StringBuilder(chaine);

        // remplace le caractère à la position spécifiée
        sb.setCharAt(0, chaine.charAt(0)).to;
        str = sb.toString();
        chaine.toLowerCase();
        chaine.set(0, ;

        return chaine;

    }

    public static void affiche(Etudiant etudiant) {
        //affichage des données d'un etudiant

        System.out.println("_____________________");
        System.out.println("Login : " + etudiant.getLogin());
        System.out.println("Nom complet : " + etudiant.getNomComplet());
        System.out.println("Mail : " + etudiant.getMail());
        System.out.println("Adresse : " + etudiant.getAdresse());

    }
}
