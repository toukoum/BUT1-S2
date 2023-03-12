//
////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package fr.iut2.poo.tp5.faerun;
//
//import fr.iut2.poo.tp5.faerun.data.Chateau;
//import fr.iut2.poo.tp5.faerun.data.Plateau;
//import fr.iut2.poo.tp5.faerun.utils.ChateauUtilitaire;
//import fr.iut2.poo.tp5.faerun.utils.GuerrierUtilitaire;
//import fr.iut2.poo.tp5.faerun.utils.PlateauUtilitaire;
//import java.util.Scanner;
//d
//public class Application {
//    public Application() {
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Plateau plateau = PlateauUtilitaire.createMiniPlateau();
//        Chateau chateauBleu = ChateauUtilitaire.createChateauBleu();
//        Chateau chateauRouge = ChateauUtilitaire.createChateauRouge();
//        chateauBleu.addGuerrier(GuerrierUtilitaire.createNainBleu());
//        chateauBleu.addGuerrier(GuerrierUtilitaire.createElfeBleu());
//        chateauBleu.addGuerrier(GuerrierUtilitaire.createSuperElfeBleu());
//        chateauRouge.addGuerrier(GuerrierUtilitaire.createNainRouge());
//        chateauRouge.addGuerrier(GuerrierUtilitaire.createElfeRouge());
//        chateauRouge.addGuerrier(GuerrierUtilitaire.createSuperNainRouge());
//        ChateauUtilitaire.afficheGuerriersEnEntrainement(chateauBleu);
//        ChateauUtilitaire.afficheGuerriersEnEntrainement(chateauRouge);
//        System.out.println("Appuyer sur entrée pour commencer le jeu");
//        sc.nextLine();
//
//        while(!plateau.isPartieTerminee()) {
//            System.out.println("------------------------------");
//            PlateauUtilitaire.afficheTourPlateau(plateau);
//            System.out.println("Unités construites dans ce tour");
//            PlateauUtilitaire.trainAndAddGuerriersPlateau(plateau, chateauBleu);
//            PlateauUtilitaire.trainAndAddGuerriersPlateau(plateau, chateauRouge);
//            System.out.println("\nPlateau avant déplacement des unités");
//            PlateauUtilitaire.affichePlateau(plateau);
//            plateau.deplaceGuerriers();
//            System.out.println("Plateau après déplacement des unités");
//            PlateauUtilitaire.affichePlateau(plateau);
//            System.out.println("Combat sur le plateau");
//            plateau.combat();
//            System.out.println();
//            System.out.println("Appuyer pour continuer le jeu");
//            sc.nextLine();
//        }
//
//        PlateauUtilitaire.afficheGagnantPlateau(plateau);
//        sc.close();
//    }
//}
