package TP4.dalton;

import java.util.Comparator;

public class ComparateurTaille implements Comparator<Dalton> {

    @Override
    public int compare(Dalton o1, Dalton o2) {
        return o1.getTaille().compareTo(o2.getTaille());
    }
}
