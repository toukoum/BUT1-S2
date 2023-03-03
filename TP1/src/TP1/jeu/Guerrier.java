package TP1.jeu;

public abstract class Guerrier {

    private int force;
    private int pointsDeVie;

    public Guerrier() {
        setForce(10);
        setPointsDeVie(100);
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

    public void setForce(int force) {
        this.force = force;
    }

    public boolean estVivant() {
        // Vrai si le guerrier a encore des pointsDeVie (> 0)

        if (pointsDeVie > 0) {
            return true;
        } else {
            return false;
        }

    }


    public void attaquer(Guerrier guerrier, int degat) {
        guerrier.subirDegat(degat);
    }

    protected void subirDegat(int degat) {
        this.pointsDeVie -= degat;
    }

}
