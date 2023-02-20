package tp1.universite;

public class Etudiant {
    private String nom;
    private String prenom;
    private String adresse = null;
    private String login;

    public Etudiant(String nom, String prenom, String login) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLogin() {
        return prenom + nom.charAt(0);
    }
    public String getNomComplet() {
        return this.nom + this.prenom;
    }

    public String getMail() {
        return login + ("@etu.univ-grenoble-alpes.fr");
    }


//    public static boolean existAdresse() {
//
//    }



    public void setNom(String nom) {
        this.nom = EtudiantUtilitaire.capitalize(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom = EtudiantUtilitaire.capitalize(prenom);
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }
}
