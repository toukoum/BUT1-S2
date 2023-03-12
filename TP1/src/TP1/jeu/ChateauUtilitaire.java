package TP1.jeu;


import java.util.Queue;

/**
 *
 * @author fbm rev hb
 */
public class ChateauUtilitaire {


    ///////////////////////
    public static void afficheGuerrierNovice(Chateau chateau) {
        chateau.getCouleur().toString();
        System.out.println("\n---- Listes des Guerriers novice ----");
        System.out.println("Ordre entrainement du Chateau " + chateau.getCouleur());
        for (Guerrier guerrier : chateau.listeGuerrierNovice) {
            GuerrierUtilitaire.afficherGuerrier(guerrier);
        }
    }

    public static void afficheGuerrierEntrainer(Queue<Guerrier> guerriers) {
        System.out.println("---- Listes des Guerriers entrainé ----");
        for (Guerrier guerrier : guerriers) {
            System.out.println(guerrier.getClass().getSimpleName());
        }
    }

    public static void afficheDonneeChateau(Chateau chateau) {
        chateau.getCouleur().toString();
        System.out.println("-------- CHATEAU " + chateau.getCouleur().toString() + " -------");
        System.out.println("Ressources = " + chateau.getRessource());

    }
}
