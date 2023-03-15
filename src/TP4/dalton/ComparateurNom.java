package TP4.dalton;

import java.util.Comparator;

public class ComparateurNom implements Comparator<Dalton> {

    @Override
    public int compare(Dalton o1, Dalton o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
