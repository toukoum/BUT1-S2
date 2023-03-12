//package TP1.jeu;
//
//public class TestJeuEtape3 {
//
//    public static void main(String[] args) {
//
//        // étape 3 : tester les méthodes de bases
//        // étape 5 : tester les déplacements
//
//        ///// TEST BLEU
//        // Création d'un plateau de jeu de taille 5
//        Plateau plateauMain = new Plateau(5);
//        Chateau chateauBleu = new Chateau(Couleur.Bleu);
//        Chateau chateauRouge = new Chateau(Couleur.Rouge);
//
//        // Ajouter un guerrier bleu
//        Nain nain1Bleu = new Nain();
//        ChefNain chefNainBleu = new ChefNain(Couleur.Bleu);
//        plateauMain.ajoutGuerriers(chateauBleu, nain1Bleu);
//        plateauMain.ajoutGuerriers(chateauBleu, chefNainBleu);
//
//
//        // Réaliser une itération pour simuler plusieurs déplacements jusqu'au camp opposé
//
//
//
//
//
//        ///// TEST ROUGE
//        // Création d'un plateau de jeu de taille 10
//
//        // Ajouter un guerrier rouge
//        Nain nain1Rouge = new Nain();
//        ChefElfe chefElfeRouge = new ChefElfe();
//        plateauMain.ajoutGuerriers(chateauRouge, nain1Rouge);
//        plateauMain.ajoutGuerriers(chateauRouge, chefElfeRouge);
//
//        PlateauUtilitaire.affichePlateau(plateauMain.getPlateauCarreau());
//
//
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//        plateauMain.deplaceGuerrier();
//
//
//
//        PlateauUtilitaire.affichePlateau(plateauMain.getPlateauCarreau());
//
//        // Réaliser une itération pour simuler plusieurs déplacements jusqu'au camp opposé
//
//
//
//        ///// TEST ARRET BATAILLE
//        // Création d'un plateau de jeu de taille 5
//
//        // Ajouter un guerrier bleu et un guerrier rouge
//
//        // Réaliser une itération pour simuler plusieurs déplacements jusqu'à la rencontre des deux guerriers
//
//
//
//        ///// TEST PLUSIEURS GUERRIERS
//        // Réaliser le même test mais avec plusieurs guerriers lancés à différents moments sur le plateau
//
//    }
//}
