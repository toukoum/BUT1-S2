package TP1.jeu;

public class Nain extends Guerrier{
    public Nain() { }


    @Override
    protected void subirDegat(int degat) {
        super.subirDegat(degat/2);
    }
}
