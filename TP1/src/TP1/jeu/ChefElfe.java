package TP1.jeu;

public class ChefElfe extends Elfe {
    private final int ressourceEntrainement = 4;

    public ChefElfe(Couleur couleur) {
        super(couleur);
        setCouleur(couleur);
    }

    @Override
    public int getForce() {
        return super.getForce()*2;
    }
    @Override
    public int getRessourceEntrainement() {
        return ressourceEntrainement;
    }

}
