package TP4.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {
    /*public static void main(String[] args) {
        // Création d'une liste d'entiers
        ArrayList<Integer> premiereListeDEntiers = new ArrayList<>();
        premiereListeDEntiers.add(5);
        premiereListeDEntiers.add(1);
        premiereListeDEntiers.add(10);
        premiereListeDEntiers.add(3);
        premiereListeDEntiers.add(20);
        premiereListeDEntiers.add(5);


        // Création d'une deuxième liste d'entiers
        ArrayList<Integer> deuxiemeListeDEntiers = new ArrayList<>(premiereListeDEntiers);

        // Création d'une troisieme liste d'entiers
        ArrayList<Integer> troisiemeListeDEntiers = new ArrayList<>(premiereListeDEntiers);


        // Affichage de la première liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la première liste d'entiers", premiereListeDEntiers);

        // Enlever les entiers inferieurs à 10 dans la première liste d'entiers en utilisant un for
        for (int i = 0; i < premiereListeDEntiers.size(); i++) {
            if (premiereListeDEntiers.get(i) < 10) {
                premiereListeDEntiers.remove(i);
            }
        }

        // A COMPLETER
        // Affichage de la liste première d'entiers après filtre
        CollectionUtilitaire.afficheCollection("Affichage de la liste première d'entiers après filtre", premiereListeDEntiers);


        // Affichage de la deuxième liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers", deuxiemeListeDEntiers);

        // Enlever les entiers inferieurs à 10 dans la deuxième liste d'entiers en utilisant un WHILE
        int i = 0;
        while (i < deuxiemeListeDEntiers.size()) {
            if (deuxiemeListeDEntiers.get(i) < 10) {
                deuxiemeListeDEntiers.remove(i);
            }
            i++;
        }

        // Affichage de la deuxième liste d'entiers après filtre
        CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers après filtre", deuxiemeListeDEntiers);



        // Affichage de la troisieme liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la troisième liste d'entiers", troisiemeListeDEntiers);

        Iterator<Integer> it = troisiemeListeDEntiers.iterator();
        // Enlever les entiers inferieurs à 10 dans la deuxième liste d'entiers en utilisant un WHILE
        while (it.hasNext()) {
            int value = it.next();
            if (value < 10) {
                it.remove();
            }
        }


        // Affichage de la deuxième liste d'entiers après filtre
    //}*/

    public static void main(String[] args) {
        // Création d'une liste d'entiers
        ArrayList<Integer> premiereListeDEntiers = new ArrayList<>();
        premiereListeDEntiers.add(5);
        premiereListeDEntiers.add(1);
        premiereListeDEntiers.add(10);
        premiereListeDEntiers.add(3);
        premiereListeDEntiers.add(20);
        premiereListeDEntiers.add(5);


// Création d'une deuxième liste d'entiers
        ArrayList<Integer> deuxiemeListeDEntiers = new ArrayList<>(premiereListeDEntiers);
        ArrayList<Integer> troisiemeListeDEntiers = new ArrayList<>(premiereListeDEntiers);



// Affichage de la première liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la première liste d'entiers", premiereListeDEntiers);

// Enlever les entiers inferieurs à 10 dans la première liste d'entiers en utilisant un FOR
        for (int i = 0; i < premiereListeDEntiers.size(); i++) {
            if (premiereListeDEntiers.get(i) < 10) {
                premiereListeDEntiers.remove(i);
            }
        }

// Affichage de la liste première d'entiers après filtre
        CollectionUtilitaire.afficheCollection("Affichage de la liste première d'entiers après filtre", premiereListeDEntiers);


// Affichage de la deuxième liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers", deuxiemeListeDEntiers);
// Enlever les entiers inferieurs à 10 dans la deuxième liste d'entiers en utilisant un WHILE

        int i = 0;

        while (i < deuxiemeListeDEntiers.size()) {
            if (deuxiemeListeDEntiers.get(i) < 10) {
                deuxiemeListeDEntiers.remove(i);
            }
            i++;
        }
// Affichage de la deuxième liste d'entiers après filtre
        CollectionUtilitaire.afficheCollection("Affichage de la deuxième liste d'entiers après filtre", deuxiemeListeDEntiers);


        // Affichage de la deuxième liste d'entiers
        CollectionUtilitaire.afficheCollection("Affichage de la troisième liste d'entiers", troisiemeListeDEntiers);
// Enlever les entiers inferieurs à 10 dans la deuxième liste d'entiers en utilisant un WHILE


        for (Iterator it = troisiemeListeDEntiers.iterator(); it.hasNext(); ) {
            if ((int)it.next() < 10) {
                it.remove();
            }
        }

        CollectionUtilitaire.afficheCollection("Affichage de la troisième liste d'entiers après filtre", troisiemeListeDEntiers);



    }

}
