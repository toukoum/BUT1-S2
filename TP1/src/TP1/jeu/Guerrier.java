package TP1.jeu;

public abstract class Guerrier {

    private int force;
    private int pointsDeVie;

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

    protected void subirDegat(int degat) {
        this.pointsDeVie -= degat;
    }

}
