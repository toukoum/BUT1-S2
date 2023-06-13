package EXAMEN;

public class exc extends Exception {
    // attribut privé
    private int ex;
    // constructeur
    exc(int nb) {
        ex = nb;
    }
    // pour print
    public String toString() {
        return "Votre nb est en dessous de 10 : " + ex + " < 0";
    }
}
