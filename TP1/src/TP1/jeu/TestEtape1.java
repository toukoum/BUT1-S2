//package TP1.jeu;
//
//public class TestEtape1 {
//
//    public static void main(String[] args) {
//
//        System.out.println("Création de guerrier 1 et de guerrier 2.");
//
//        Guerrier guerrier1 = new Guerrier();
//        Guerrier guerrier2 = new Guerrier();
//
//        while (guerrier1.estVivant() && guerrier2.estVivant()) {
//            System.out.println("Guerrier 1 attaque guerrier 2 !\n");
//            guerrier1.attaquer(guerrier2);
//
//            System.out.println("Guerrier 2 contre-attaque guerrier 1 !\n");
//            guerrier2.attaquer(guerrier1);
//
//            System.out.println("Guerrier 1 :");
//            GuerrierUtilitaire.afficherGuerrier(guerrier1);
//            System.out.println("Guerrier 2 :");
//            GuerrierUtilitaire.afficherGuerrier(guerrier2);
//
//        }
//
//        if (guerrier1.estVivant() || guerrier1.getPointsDeVie() > guerrier2.getPointsDeVie()) {
//            System.out.println("Victoire du Guerrier 1, BRAVO !");
//        }
//        else {
//            System.out.println("Victoire du Guerrier 2, BRAVO !");
//        }
//    }
//}
