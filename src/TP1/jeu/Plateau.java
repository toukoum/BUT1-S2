package TP1.jeu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @Class Plateau
 * <p>
 *     Classe représentant le plateau de jeu
 *     Un plateau contient un ArrayList de Carreau de longueur longueur
 *     Contient la méthode deplaceGuerrier() qui permet de déplacer un guerrier sur le plateau
 */

public class Plateau implements Serializable {
    private int longueur;
    private ArrayList<Carreau> plateauCarreau = new ArrayList<>();

    private int nbTour = 1;

    public Plateau(int longueur) {
        this.longueur = longueur;
        setPlateauCarreau();

    }

    public void setPlateauCarreau() {
        //Création d'un ArrayList de Carreau, représentation d'un plateau
        for (int i = 0; i < this.longueur; i++) {
            plateauCarreau.add(new Carreau());
        }
    }

    public ArrayList<Carreau> getPlateauCarreau() {
        return plateauCarreau;
    }

    public void ajoutGuerriers(Chateau chateau, Guerrier guerrier) {
        // méthode pour ajouter un Guerrier sur le plateau, soit sur plateauCarreau
        if (chateau.estBleu()) {
            plateauCarreau.get(0).ajoutGuerriersBleu(guerrier);
        }else {
            plateauCarreau.get(plateauCarreau.size()-1).ajoutGuerrierRouge(guerrier);
        }
    }



    public void deplaceGuerrier() {

        // parcours de droite à gauche pour déplacer les bleus
        for (int i = longueur - 1; i >= 0; i--) {

            // si le carreau est un champ de bataille, on lance le combat
            if (plateauCarreau.get(i).estChampdeBataille()) {
                lanceCombatFromPlateau();
            } else if (plateauCarreau.get(i).estBleu()) {
                // sinon si le carreau est bleu, on déplace les guerriers sur le carreau suivant
                Queue<Guerrier> queueCopie = new LinkedList<>(plateauCarreau.get(i).guerriersBleus);
                plateauCarreau.get(i + 1).setGuerriersBleus(queueCopie);
                plateauCarreau.get(i).retirerGuerrierBleu();
            }
        }

        // parcours de gauche à droite pour déplacer les rouges
        for (int i = 0; i < longueur; i++) {
            // si le carreau est un champ de bataille, on ne fait rien car le combat a déjà été lancé
            if (plateauCarreau.get(i).estChampdeBataille()) {}
            else if(plateauCarreau.get(i).estRouge()) {
                // sinon si le carreau est rouge, on déplace les guerriers sur le carreau suivant
                Queue<Guerrier> queueCopie = new LinkedList<>(plateauCarreau.get(i).guerriersRouges);
                plateauCarreau.get(i - 1).setGuerriersRouges(queueCopie);
                plateauCarreau.get(i).retirerGuerrierRouge();
            }
        }

    }



    public void lanceCombatFromPlateau() {
        //Parcours de tous le plateau, lance le combat sur le bon carreau
        for (int i = 0; i < this.longueur; i++) {
            if (plateauCarreau.get(i).estChampdeBataille()) {
                // lancement du combat dans le carreau qui est un champ de bataille
                try {
                    plateauCarreau.get(i).lanceCombat();

                } catch (CoupDivinException e) {
                    System.out.println(e.getMessage());

                }
            }
        }
    }


    public boolean estPartieTerminee() {
        // verifie qu'il n'y ait pas de guerrier rouge ou de guerrier bleu sur les cases du chateau adverse
        boolean bool = false;
        if (plateauCarreau.get(0).estRouge() || plateauCarreau.get(longueur - 1).estBleu()) {
            bool = true;
        }
        return bool;
    }

    public Couleur getGagnant(){
        // retourne le gagnant de la partie, si il n'y a pas de gagnant, retourne noGagnant (Partie non terminée)
        Couleur gagnant;
        if (plateauCarreau.get(0).estRouge()) {
            gagnant = Couleur.Rouge;
        } else if (plateauCarreau.get(plateauCarreau.size()-1).estBleu()) {
            gagnant = Couleur.Bleu;
        }else {
            gagnant = Couleur.noGagnant;
        }
        return gagnant;
    }


    public void lanceTremblement(int carreauTremblement, Chateau chateau) {
         // Lance un tremblement de terre sur le carreau spécifié, infligeant des dégâts aléatoires (10 lancés)
         // à tous les guerriers du château donné sur ce carreau. Les guerriers morts sont retirés de la liste de defenseurs

        int degat = PlateauUtilitaire.De3(10);

        // Pour chaque guerrier du château donné sur le carreau spécifié
        for (Guerrier guerrier : plateauCarreau.get(carreauTremblement).getGuerriers(chateau)) {
            guerrier.subirDegat(degat);
            PlateauUtilitaire.afficheTremblement(guerrier);

            // Si le guerrier est mort, le retirer de la liste des guerriers du château sur ce carreau
            if (!guerrier.estVivant()) {
                plateauCarreau.get(carreauTremblement).getGuerriers(chateau).poll();
                PlateauUtilitaire.afficheTremblementMort(guerrier);

            }
        }
    }

    public int getNbTour() {
        return nbTour;
    }

    public void incrementeNbTour() {
        nbTour +=1;
    }


}

