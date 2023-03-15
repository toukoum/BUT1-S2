package TP3.billeterie;

import java.util.ArrayList;

public class BilletterieUtilitaire {

    public static void afficheTrajets(ArrayList<Trajet> trajets) {

        System.out.println("------------------- Les trajets -------------------");
        for (Trajet trajet : trajets) {
            System.out.println(trajet);
        }
        System.out.println();

    }

    public static void afficheBillets(ArrayList<Billet> billets) {
        System.out.println("------------------- Les billets -------------------");
        for (Billet billet : billets) {
            System.out.println(billet);
        }
        System.out.println();
    }


    public static double arrondir(double prix) {
        return Math.round(prix * 100.0) / 100.0;
    }

}
