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
    public static void afficheEntrainement(Plateau plateau, Chateau chateau) {

        chateau.getCouleur().toString();
        System.out.println("-------- CHATEAU " + chateau.getCouleur() + " -------");
        System.out.println("Ressources = " + chateau.getRessource());
        System.out.println("Unités construites dans ce tour :");
        if (!chateau.entrainer().isEmpty()) {
            for (Guerrier guerrier : chateau.entrainer()) {
                plateau.ajoutGuerriers(chateau, guerrier);
                System.out.print("    GUERRIER AU COMBAT : ");
                GuerrierUtilitaire.afficherGuerrier(guerrier);
            }
        }
        else {
            System.out.println("    AUCUN GUERRIER ENTRAINE !");
        }
        if (chateau.getRessource() == 0) {
            System.out.println("Après entrainement, plus de ressources !\n");
        }else {
            System.out.println("Après entrainement, plus que : " + chateau.getRessource() + " ressources.\n");
        }
        chateau.incrementeRessources();
        chateau.enleveGuerrierEntrainer();


    }
}
