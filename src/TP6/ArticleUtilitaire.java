package TP6;

public class ArticleUtilitaire {
    public static String capitalize(String intitule) {
        //prend en paramètre une chaine de caractères et qui retourne la même
        //chaîne de caractères avec le premier caractère en majuscule et les autres en
        //minuscule
        return intitule.substring(0, 1).toUpperCase() + intitule.substring(1).toLowerCase();
    }
}
