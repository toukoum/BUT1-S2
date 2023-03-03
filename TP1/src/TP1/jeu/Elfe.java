package TP1.jeu;

public class Elfe extends Guerrier {
    public Elfe() { }

    @Override
    public void setForce(int force) {
        super.setForce(2 * force);
    }
}
