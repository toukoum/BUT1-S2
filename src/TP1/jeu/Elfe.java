package TP1.jeu;
import java.io.Serializable;

public class Elfe extends Guerrier implements Serializable {
    private int ressourceEntrainement = 2;
    private final String defenseString2 = "c";

    public Elfe(Couleur couleur) {
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

    @Override
    public String getDefenseString() {
        return this.defenseString2;
    }




}
