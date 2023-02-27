package TP1.universite;

public class TestEtudiant {

    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("DUPONT", "pierre");
        Etudiant etudiant2 = new Etudiant("martin", "francis");

        etudiant2.setAdresse("2 Place Doyen Gosse");

        etudiant1.addNote(12);
        etudiant1.addNote(1);
        etudiant1.addNote(19);

        Groupe groupeA = new Groupe("A");
        etudiant1.setGroupe(groupeA);

        EtudiantUtilitaire.affiche(etudiant1);
        EtudiantUtilitaire.affiche(etudiant2);


    }
}
