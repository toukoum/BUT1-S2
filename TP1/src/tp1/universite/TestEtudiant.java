package tp1.universite;

public class TestEtudiant {

    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("DUPONTP", "pierre", "DUPONT");
        Etudiant etudiant2 = new Etudiant("martinf", "francis", "martin");

        etudiant2.setAdresse("2 Place Doyen Gosse");
        etudiant1.setNom(etudiant1.getNom());
        etudiant1.setPrenom(etudiant1.getPrenom());
        etudiant1.setLogin(etudiant1.getLogin());
        etudiant2.setNom(etudiant2.getNom());
        etudiant2.setPrenom(etudiant2.getPrenom());
        etudiant2.setLogin(etudiant2.getLogin());

        EtudiantUtilitaire.affiche(etudiant1);
        EtudiantUtilitaire.affiche(etudiant2);
    }
}
