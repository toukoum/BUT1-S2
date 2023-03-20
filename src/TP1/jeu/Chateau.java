package TP1.jeu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @Class Chateau
 * <p>
 *     Classe représentant un chateau du jeu
 *     Un chateau peut contenir des guerriers novices et des guerriers entrainés
 *     Contient la méthode entrainer() qui permet d'entrainer les guerriers novices en utilisant les ressources disponibles
 */
public class Chateau implements Serializable {
    private final int RESSOURCE_INITIAL = 3;
    private final int RESSOURCE_AJOUTER_PAR_TOUR = 1;

    private int ressources;

    Queue<Guerrier> listeGuerrierNovice = new LinkedList<>();
    Queue<Guerrier> listeGuerrierEntrainer = new LinkedList<>();


    private Couleur couleur;


    public Chateau(Couleur couleur) {
        ressources = RESSOURCE_INITIAL;
        this.couleur = couleur;
    }


    public void ajoutGuerrierNovice(Guerrier guerrier) {
        listeGuerrierNovice.add(guerrier);
    }


    public Queue<Guerrier> entrainer() {
        // Méthode qui entraîne les guerriers novices en utilisant les ressources disponibles, et ajoute les guerriers entraînés à la listeGuerrierEntrainer.
        // Elle retourne la listeGuerrierEntrainer contenant les guerriers entraînés.


        // Parcours de tous les guerriers novices dans la file d'attente
        while (!listeGuerrierNovice.isEmpty()) {
            Guerrier guerrier = listeGuerrierNovice.peek();

            // Vérification si les ressources disponibles sont suffisantes pour entraîner le guerrier novice
            if (ressources >= guerrier.getRessourceEntrainement()) {
                // On retire le guerrier de la file d'attente des guerriers novices et on l'ajoute à la liste des guerriers entraînés.
                listeGuerrierEntrainer.add(listeGuerrierNovice.poll());

                // Mise à jour des ressources disponibles
                ressources -= guerrier.getRessourceEntrainement();
            } else {
                // Si les ressources ne sont pas suffisantes pour entraîner le guerrier novice, on sort de la boucle
                break;
            }
        }
        // Retourne la liste des guerriers entraînés

        return listeGuerrierEntrainer;
    }





    public void incrementeRessources() {
        this.ressources += RESSOURCE_AJOUTER_PAR_TOUR;
    }


    public Couleur getCouleur() {
        return this.couleur;
    }

    public boolean estBleu() {
        return this.couleur == Couleur.Bleu;
    }

    public int getRessource() {
        return ressources;
    }

    public void enleveGuerrierEntrainer() {
        listeGuerrierEntrainer.clear();
    }
}
