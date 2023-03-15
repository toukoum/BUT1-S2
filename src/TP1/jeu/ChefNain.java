package TP1.jeu;

public class ChefNain extends Nain{

    private final int ressourceEntrainement = 3;
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
        return ressourceEntrainement;
    }
}

