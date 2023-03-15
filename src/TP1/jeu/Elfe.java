package TP1.jeu;

public class Elfe extends Guerrier {
    private int ressourceEntrainement = 2;

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



}
