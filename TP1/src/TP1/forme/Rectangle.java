package TP1.forme;

public class Rectangle {
    private int largeur;
    private int longueur;

    Point origine;

    public Rectangle(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public Rectangle(int largeur, int longueur, int valX, int valY) {
        this.largeur = largeur;
        this.longueur = longueur;
        origine = new Point(valX, valY);
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public Point getOrigine() {
//        return origine;
        Point nouveauPoint = new Point(origine.getX(), origine.getY());
        return nouveauPoint;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public double getPerimetre() {
        return (this.largeur*2 + this.longueur*2);
    }

    public double getAire() {
        return (this.largeur * this.longueur);
    }

    public void deplaceOrigine(int dX, int dY) {
        origine.deplaceXY(dX, dY);

    }

}
