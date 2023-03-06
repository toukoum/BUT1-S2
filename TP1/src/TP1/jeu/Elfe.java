package TP1.jeu;

public class Elfe extends Guerrier {
    private final int ressourceEntrainement = 2;

    public Elfe() { }


    @Override
    public int getForce() {
        return super.getForce()*2;
    }

    @Override
    public int ressourceEntrainement() {
        return ressourceEntrainement;
    }
}
