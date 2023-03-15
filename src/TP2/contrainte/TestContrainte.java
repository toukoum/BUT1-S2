package TP2.contrainte;

public class TestContrainte {

    public static void main(String[] args) {
        ReelContraint test1 = new ReelContraint(1, 4);
        ReelContraint test2 = ContrainteUtilitaire.saisir(1, 4);

        System.out.println(test1);
        System.out.println(test2);


        Note note1 = new Note();
        Note note2 = new Note(70);
        Note note3 = new Note(-70);
        Note note4 = new Note(7);

        System.out.println(note1);
        System.out.println(note2);
        System.out.println(note3);
        System.out.println(note4);

        note1 = ContrainteUtilitaire.saisirNote(5, 10);
        System.out.println();
        System.out.println(note1);
    }

}
