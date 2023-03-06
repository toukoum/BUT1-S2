package TP1.jeu;

public class ChefNain extends Nain{

    private final int ressourceEntrainement = 3;
    public ChefNain() { }

    @Override
    protected void subirDegat(int degat) {
        super.subirDegat(degat/2);
    }


    @Override
    public int ressourceEntrainement() {
        return ressourceEntrainement;
    }
}

