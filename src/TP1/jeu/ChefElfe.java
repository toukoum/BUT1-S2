package TP1.jeu;

public class ChefElfe extends Elfe {
    private final int ressourceEntrainement2 = 4;
    private final String defenseString3 = "d";

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
        return ressourceEntrainement2;
    }
    @Override
    public String getDefenseString() {
        return this.defenseString3;
    }

}
