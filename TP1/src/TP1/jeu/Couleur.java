package TP1.jeu;

public enum Couleur {
    Bleu,
    Rouge;

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
