package TP1.jeu;

public class Nain extends Guerrier{

    private int ressourceEntrainement = 1;
    public Nain(Couleur couleur) {
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
