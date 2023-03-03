package TP1.jeu;

public class ChefNain extends Nain{
    public ChefNain() { }

    @Override
    protected void subirDegat(int degat) {
        super.subirDegat(degat/2);
    }

}

