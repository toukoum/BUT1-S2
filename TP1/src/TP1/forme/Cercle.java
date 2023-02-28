package TP1.forme;

public class Cercle {

    private int rayon;

    Point centre;

    public Cercle(int monRayon) {
        this.rayon = monRayon;
    }

    public Cercle(int monRayon, Point centre) {
        this.rayon = monRayon;
        this.centre = centre;
    }

    public int getRayon() {
        return rayon;
    }

    public Point getCentre() {
        return centre;
    }

    public void setRayon(int nouveauRayon) {
        this.rayon = rayon;
    }

    public double getPerimetre() {
        return (2 * Math.PI * rayon);
    }

    public double getAire() {
        return (Math.PI * (Math.pow(rayon, 2)));
    }

    public void deplaceCentre(int dX, int dY) {
        centre.deplaceXY(dX, dY);
    }

}
