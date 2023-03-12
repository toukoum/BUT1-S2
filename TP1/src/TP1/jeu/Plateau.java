package TP1.jeu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Plateau {
    private int longueur;
    private Chateau chateau;
    private Guerrier guerriers;
    private ArrayList<Carreau> plateauCarreau = new ArrayList<>();

    public Plateau(int longueur) {
        this.longueur = longueur;
        setPlateauCarreau();

    }

    public void setPlateauCarreau() {
        //Création d'un ArrayList de Carreau
        for (int i = 0; i < this.longueur; i++) {
            plateauCarreau.add(new Carreau());
        }
    }

    public ArrayList<Carreau> getPlateauCarreau() {
        return plateauCarreau;
    }

    public void ajoutGuerriers(Chateau chateau, Guerrier guerrier) {
        if (chateau.estBleu()) {
            plateauCarreau.get(0).ajoutGuerriersBleu(guerrier);
        }else {
            plateauCarreau.get(plateauCarreau.size()-1).ajoutGuerrierRouge(guerrier);
        }

    }

    public void deplaceGuerrier() {
        if (!estPartieTerminee() && !estChampDeBataille()) {
            // Parcours du plateau de droite à gauche pour déplacer les Queue de guerrier bleu vers la droite
            for (int i = longueur-1; i >= 0; i--) {
                if (plateauCarreau.get(i).estBleu()) {
                    Queue<Guerrier> queueCopie = new LinkedList<>();

                    for (Guerrier guerrier : plateauCarreau.get(i).guerriersBleus) {
                        queueCopie.add(guerrier);
                    }
                    plateauCarreau.get(i + 1).setGuerriersBleus(queueCopie);
                    plateauCarreau.get(i).retirerGuerrierBleu();
                }
            }

            // Parcours du plateau de gauche à droite pour déplacer les Queue de guerrier Rouge vers la gauche
            for (int i = 0; i < longueur; i++) {
                if (plateauCarreau.get(i).estRouge()) {
                    Queue<Guerrier> queueCopie2 = new LinkedList<>();

                    for (Guerrier guerrier : plateauCarreau.get(i).guerriersRouges) {
                        queueCopie2.add(guerrier);
                    }
                    plateauCarreau.get(i - 1).setGuerriersRouges(queueCopie2);
                    plateauCarreau.get(i).retirerGuerrierRouge();
                }
            }

        }else if (estPartieTerminee()){
            System.out.println("Partie terminée !! ");
            System.out.println("Le grand Gagnant est :" + getGagnant().toString());
        }else {
            lanceCombat();
        }


    }

    public void lanceCombat() {
        //Parcours de tous le plateau, lance le combat sur la bonne case !
        for (int i = 0; i < this.longueur; i++) {
            if (plateauCarreau.get(i).estChampdeBataille()) {
                // lancement du combat dans le carreau qui est un champ de bataille
                System.out.println("lancement du combat sur la case " + i);
                plateauCarreau.get(i).lanceCombat();
            }
        }
    }

    public boolean estChampDeBataille() {
        boolean bool = false;
        for (Carreau carreau : plateauCarreau) {
            if (carreau.estChampdeBataille()) {
                bool = true;
            }
        }
        return bool;
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

    public int getDepartBleu() {
        return 0;
    }

    public int getDepartRouge() {
        return longueur;
    }

}

