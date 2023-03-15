package TP4.tabledemultiplication;

public class Multiplication {
    private int terme1;
    private int terme2;
    private Integer reponseUtilisateur = null;

    private boolean firstTry = true;

    public Multiplication(int terme1, int terme2) {
        this.terme1 = terme1;
        this.terme2 = terme2+10;
    }

    public void setReponseUtilisateur(Integer reponseUtilisateur) throws ErreurMultiplicationException {
        this.reponseUtilisateur = reponseUtilisateur;
        if (!isReponseJuste()) {
            firstTry = false;
            throw new ErreurMultiplicationException();
        }
    }

    public boolean isReponseJuste() {
        return (terme1*terme2==reponseUtilisateur);
    }
    public boolean isReponseJuste2() {return ((terme1*terme2==reponseUtilisateur) && firstTry);}

    @Override
    public String toString() {
        return (terme1 + " * " + terme2 + " = ");
    }
}
