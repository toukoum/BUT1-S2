package TP4.collection;

import java.util.ArrayList;

public class CollectionUtilitaire {
    public static void afficheCollection(String s, ArrayList<Integer> premiereListeDEntiers) {
        System.out.print(s + " => ");
        for (Integer i : premiereListeDEntiers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
