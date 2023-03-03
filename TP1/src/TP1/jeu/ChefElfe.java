package TP1.jeu;

public class ChefElfe extends Elfe {
    public ChefElfe() { }

    @Override
    public void setForce(int force) {
        super.setForce(2 * force);
    }
}
