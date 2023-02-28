package TP1.forme;

public class Point {
    private int x = 0;
    private int y = 0;

    public Point() {
        return;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        setX(x);
        setX(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int valX) {
        if (x<0) {
            this.x = 0;
        } else {
            this.x = x; // l’attribut this.x prend la valeur du paramètre x
        }
    }

    public void setY(int valY) {
        if (y<0) {
            this.y = 0;
        } else {
            this.y = y; // l’attribut this.x prend la valeur du paramètre x
        }
    }

    public void deplaceXY(int dX, int dY) {
        this.x += dX;
        this.y += dY;
        setX(x);
        setY(y);
    }
}
