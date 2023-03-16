package TP1.jeu;

import java.io.Serializable;

public class ChefNain extends Nain implements Serializable {

    private final int ressourceEntrainement1 = 3;
    private final String defenseString5 = "a";
    public ChefNain(Couleur couleur) {
        super(couleur);
        setCouleur(couleur);
    }

    @Override
    protected void subirDegat(int degat) {
        super.subirDegat(degat/2);
    }


    @Override
    public int getRessourceEntrainement() {
        return ressourceEntrainement1;
    }

    @Override
    public String getDefenseString() {
        return this.defenseString5;
    }
}

