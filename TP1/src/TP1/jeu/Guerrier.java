package TP1.jeu;

public abstract class Guerrier {

    private int force;
    private int pointsDeVie;
    private final int FORCE_BASE = 10;
    private final int RESSOURCE_BASE = 1;
    private final int PV_MAX_BASE = 100;

    private Couleur couleur;

    private Chateau chateau;

    public Guerrier(Couleur couleur) {
        setForce(FORCE_BASE);
        setPointsDeVie(PV_MAX_BASE);
        setCouleur(couleur);
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
        return (this.pointsDeVie > 0);
    }


    public void attaquer(Guerrier guerrier, int degat) {
        guerrier.subirDegat(degat);
    }

    protected void subirDegat(int degat) {
        this.pointsDeVie -= degat;
    }


    public void setPointDeVie(int pointDeVie) {
        this.pointsDeVie = pointDeVie;
    }

    public void setCouleur(Couleur couleur){this.couleur = couleur;
    }

    public Chateau getChateau() {
        return chateau;
    }

    public boolean existeChateau() {
        return (this.chateau != null);
    }

    public boolean estBleu() {
        if (existeChateau()) {
            return this.chateau.estBleu();
        } else {
            return false;
        }
    }

    public boolean estRouge() {
        if (existeChateau()) {
            return this.chateau.estRouge();
        } else {
            return false;
        }

    }

    public Couleur getCouleur() {
        return couleur;
    }


    public int getRessourceEntrainement() {
        return RESSOURCE_BASE;
    }

}