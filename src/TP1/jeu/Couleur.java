package TP1.jeu;

import java.io.Serializable;
/**
 * @Class Couleur
 * <p>
 *     Enumération représentant les couleurs des joueurs
 *     Contient la méthode toString() qui permet d'afficher la couleur en console
 */

public enum Couleur implements Serializable {
    Bleu,
    Rouge,
    noGagnant;

    private Couleur() {
    }

    public String toString() {
        String couleur = "";
        if (this == Bleu) {
            couleur = "34";
        } else {
            couleur = "31";
        }

        return "\u001b[" + couleur + "m" + super.toString() + "\u001b[0m";
    }
}
