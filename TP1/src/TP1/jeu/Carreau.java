package TP1.jeu;

import java.util.LinkedList;
import java.util.Queue;

public class Carreau {

    Queue<Guerrier> guerriersBleus = new LinkedList<>();
    Queue<Guerrier> guerriersRouges = new LinkedList<>();

    public Carreau() {
    }

    public Queue<Guerrier> getGuerriersBleus() {
        return guerriersBleus;
    }

    public Queue<Guerrier> getGuerriersRouges() {
        return guerriersRouges;}


    public void ajoutGuerriersBleus(Guerrier guerrier) {
        guerriersBleus.add(guerrier);
    }

    public void ajoutGuerrierRouge(Guerrier guerrier) {
        guerriersRouges.add(guerrier);
    }

    public Guerrier retirerGuerrierBleu() {
        return guerriersBleus.remove();
    }

    public Guerrier retirerGuerrierRouge() {
        return guerriersRouges.remove();
    }

    public void supprimerGuerrier(Guerrier guerrier) {
        guerriersRouges.clear();
        guerriersBleus.clear();
    }

    public boolean estRouge() {
        return guerriersRouges.size() != 0;
    }

    public boolean estBleu() {
        return guerriersBleus.size() != 0;
    }


    public boolean estChampdeBataille() {
        return estBleu() && estRouge();
    }

    public void lanceCombat() {
        throw new RuntimeException();
    }



}
