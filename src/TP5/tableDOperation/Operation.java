package TP5.tableDOperation;

public abstract class Operation {
    public boolean firstTry = true;
    private double terme1;
    private double terme2;
    private Double reponseUtilisateur = null;

    public Operation(double terme1, double terme2) {
        this.terme1 = terme1;
        this.terme2 = terme2;
    }

    public boolean existeReponseUtilisateur() {
        return reponseUtilisateur != null;
    }

    public void setReponseUtilisateur(double reponseUtilisateur) throws ErreurOperationException {
        this.reponseUtilisateur = reponseUtilisateur;
        if (!isReponseJuste()) {
            firstTry = false;
            throw new ErreurOperationException("La réponse est fausse, veuillez réessayer.");
        }
    }

    public boolean isReponseJuste() {
        return existeReponseUtilisateur() && (reponseUtilisateur == calculResultat());
    }

    public abstract double calculResultat();

    //get terme1
    public double getTerme1() {
        return terme1;
    }

    //get terme2
    public double getTerme2() {
        return terme2;
    }


    public boolean getFirstTry() {
        return firstTry;
    }

    public void setReponseUtilisateurErreur(double reponse) {
        this.reponseUtilisateur = reponse;
    }
}
