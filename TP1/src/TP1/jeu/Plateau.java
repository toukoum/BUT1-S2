package TP1.jeu;

import java.util.ArrayList;

public class Plateau {
    private int longueur;
    private Chateau chateau;
    private Guerrier guerriers;
    private ArrayList<Carreau> plateauCarreau;

    public Plateau(int longueur) {
        this.longueur = longueur;

    }

    public void setPlateauCarreau() {
        //Création d'un ArrayList de Carreau
        for (int i = 0; i < this.longueur; i++) {
            plateauCarreau.add(new Carreau());
        }
    }

    public void ajoutGuerriers(Chateau chateau, Guerrier guerrier) {
        chateau.ajoutGuerrierNovice(guerrier);
    }

    public void deplaceGuerrier() {

        // Parcours du plateau de droite à gauche pour déplacer les Queue de guerrier bleu vers la droite
        for (int i = 10; i > 0; i--) {
            if (plateauCarreau.get(i).estBleu()) {
                plateauCarreau.get(i + 1).setGuerriersBleus(plateauCarreau.get(i).guerriersBleus);
            }
        }

        // Parcours du plateau de gauche à droite pour déplacer les Queue de guerrier Rouge vers la gauche
        for (int i = 0; i < this.longueur; i++) {
            if (plateauCarreau.get(i).estRouge()) {
                plateauCarreau.get(i + 1).setGuerriersRouges(plateauCarreau.get(i).guerriersRouges);
            }
        }
    }

    public void lanceCombat() {
        //Parcours de tous le plateau, si des rouges et des bleu sur un même case, combat !
        for (int i = 0; i < this.longueur; i++) {
            if (plateauCarreau.get(i).estChampdeBataille()) {
                // lancement du combat dans le carreau qui est un champ de bataille
                plateauCarreau.get(i).lanceCombat();
            }
        }
    }


    public boolean estPartieTerminee() {
        boolean bool = false;
        if (plateauCarreau.get(0).estRouge() || plateauCarreau.get(longueur - 1).estBleu()) {
            bool = true;
        }
        return bool;
    }

    public Couleur getGagnant(){
        Couleur gagnant;
        if (plateauCarreau.get(0).estRouge()) {
            gagnant = Couleur.Rouge;
        }else {
            gagnant = Couleur.Bleu;
        }
        return gagnant;
    }

    public ArrayList<Carreau> getCarreaux() {
        return this.plateauCarreau;
    }

    public Carreau getDepartBleu() {
        return plateauCarreau.get(0);
    }

    public Carreau getDepartRouge() {
        return plateauCarreau.get(longueur-1);
    }

}

