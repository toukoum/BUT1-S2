package jeu;

public class Guerrier {

    private int force = 10;
    private int pointsDeVie = 100;

    public Guerrier() {
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public boolean estVivant() {
        // Vrai si le guerrier a encore des pointsDeVie (> 0)

        if (pointsDeVie > 0) {
            return true;
        } else {
            return false;
        }

    }


    public void attaquer(Guerrier guerrier) {
        guerrier.subirDegat(this.force*GuerrierUtilitaire.De3(1));
    }

    public void subirDegat(int degat) {
        this.pointsDeVie -= degat;
    }

}
