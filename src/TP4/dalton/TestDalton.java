package TP4.dalton;

import java.util.Comparator;
import java.util.TreeSet;

public class TestDalton{

    public static final Comparator<Dalton> comparateurNomSolution2 = new Comparator<Dalton>(){
        @Override
        public int compare(Dalton o1, Dalton o2) {
            return o1.getNom().compareTo(o2.getNom());
        }
    };

    public static void main(String[] args) {
        // Création des Daltons
        Dalton joe = new Dalton("Joe", Taille.PETIT);
        Dalton jack = new Dalton("Jack", Taille.MOYEN);
        Dalton william = new Dalton("William", Taille.MOYEN);
        Dalton averell = new Dalton("Averell", Taille.GRAND);


        // Faire un ensemble triés des daltons sur l'ordre naturel (compareTo)
        TreeSet<Dalton> lesDaltons = new TreeSet<>();
        lesDaltons.add(averell);
        lesDaltons.add(joe);
        lesDaltons.add(william);
        lesDaltons.add(jack);


        // Affichage
        afficheCollection("Les daltons triés par ordre naturel (compareTo) :", lesDaltons);


        // Faire un ensemble triés des daltons avec le comparateur de Taille (solution 1)
        TreeSet<Dalton> lesDaltonsTaille = new TreeSet<Dalton>(new ComparateurTaille());
        lesDaltonsTaille.addAll(lesDaltons);


        // Affichage
        // ATTENTION 2 daltons avec la même taille donc vu que les doublons ne sont pas autorisés dans un Set (ensemble)
        // Un des daltons ne sera pas conservé
        afficheCollection("\nLes daltons triés par taille :", lesDaltonsTaille);


        // Faire un ensemble triés des daltons avec le comparateur de Nom (solution1)
        TreeSet<Dalton> lesDaltonsNom = new TreeSet<>(new ComparateurNom());
        lesDaltonsNom.addAll(lesDaltons);

        // Affichage
        afficheCollection("\nLes daltons triés par nom (1):", lesDaltonsNom);


        // Faire un ensemble triés des daltons avec le comparateur de Nom (solution2)
        TreeSet<Dalton> lesDaltonsNom2 = new TreeSet<>(comparateurNomSolution2);
        lesDaltonsNom2.addAll(lesDaltons);

        // Affichage
        afficheCollection("\nLes daltons triés par nom (2) :", lesDaltonsNom2);
    }

    private static void afficheCollection(String s, TreeSet<Dalton> lesDaltons) {
        System.out.println(s);
        for (Dalton dalton : lesDaltons) {
            System.out.println("   -> " + dalton.getNom() + "(" + dalton.getTaille() + ")");
        }
    }
}
