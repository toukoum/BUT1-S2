package TP1.jeu;

import java.util.LinkedList;
import java.util.Queue;

public class Chateau {
    private final int RESSOURCE_INITIAL = 3;
    private final int RESSOURCE_AJOUTER_PAR_TOUR = 1;

    private int ressources;

    Queue<Guerrier> listeGuerrierNovice = new LinkedList<>();
    Queue<Guerrier> listeGuerrierEntrainer = new LinkedList<>();


    private Couleur couleur;


    public Chateau(Couleur couleur) {
        this.couleur = couleur;
    }


    public void ajoutGuerrierNovice(Guerrier guerrier) {
        listeGuerrierNovice.add(guerrier);
    }

    public Queue<Guerrier> getGuerrierNovice() {
        return listeGuerrierNovice;
    }


   public Queue<Guerrier> entrainer() {
        // Méthode qui a partir de la collection Queue listeGuerrierNovice entraîne, en utilisant au maximum les ressources, les guerriers dans l'ordre
        // et les ajoutes à une autre collections listeGuerrierentrain
       // retourne listeGuerrierentrainer


        while (this.ressources > 4) {
            if (listeGuerrierNovice.element().ressourceEntrainement() == 4) {
                ressources-=4;
                listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
            }
            if (listeGuerrierNovice.element().ressourceEntrainement() == 3) {
                ressources-=3;
                listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
            }
            if (listeGuerrierNovice.element().ressourceEntrainement() == 2) {
                ressources-=2;
                listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
            }
            if (listeGuerrierNovice.element().ressourceEntrainement() == 1) {
                ressources-=1;
                listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
            }
        }
        while (this.ressources > 3) {
           if (listeGuerrierNovice.element().ressourceEntrainement() == 3) {
               ressources-=3;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
           if (listeGuerrierNovice.element().ressourceEntrainement() == 2) {
               ressources-=2;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
           if (listeGuerrierNovice.element().ressourceEntrainement() == 1) {
               ressources-=1;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
        }

        while (this.ressources > 2) {
           if (listeGuerrierNovice.element().ressourceEntrainement() == 2) {
               ressources-=2;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
           if (listeGuerrierNovice.element().ressourceEntrainement() == 1) {
               ressources-=1;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
        }

        while (this.ressources > 1) {
           if (listeGuerrierNovice.element().ressourceEntrainement() == 1) {
               ressources-=1;
               listeGuerrierEntrainer.add(listeGuerrierNovice.poll());
           }
        }

        return listeGuerrierEntrainer;
    }

    private void incrementeRessources() {
        this.ressources ++;
    }


    public Couleur getCouleur() {
        return this.couleur;
    }

    public boolean estBleu() {
        return this.couleur == Couleur.Bleu;
    }

    public boolean estRouge() {
        return this.couleur == Couleur.Rouge;
    }

}
