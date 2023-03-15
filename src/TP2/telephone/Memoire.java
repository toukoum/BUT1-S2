package TP2.telephone;

public class Memoire {

    private String type;
    private int nombreGiga;

    public Memoire(String type, int nombreGiga) {
        this.type = type;
        this.nombreGiga = nombreGiga;
    }

    public String getType() {
        return type;
    }

    public int getNombreGiga() {
        return nombreGiga;
    }
}
