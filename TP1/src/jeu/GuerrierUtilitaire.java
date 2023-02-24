package jeu;

public class GuerrierUtilitaire {

    public static void afficherGuerrier(Guerrier guerrier) {
        System.out.println("-------------");
        System.out.println("-> Point de vie : " + guerrier.getPointsDeVie());
        System.out.println("-> Force : " + guerrier.getForce() + "\n");

    }

    public static int De3() {
        return 1 + (int)(Math.random() * ((3 - 1) + 1));
    }

    public static int De3(int nombreDes) {
        int somme = 0;
        for (int i = 0; i < nombreDes; i++) {
            somme = somme + De3();
        }
        return somme;
    }
}
