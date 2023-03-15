package TP2.universite;

/**
 * @Class Personne
 *
 * Créer une personne de type générale, classe mère
 */

public abstract class Personne {
    private String nom;
    private String prenom;
    private String adresse = null;
    private String login;

    public Personne(String login, String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        setNom(nom);
        setPrenom(prenom);
    }

    public Personne(String login, String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.adresse = adresse;
        setNom(nom);
        setPrenom(prenom);
    }


//    GETTER ------------------------------------------

    /**
     * Getter
     *
     * méthode pour la plupart redéfini dans la classe Etudiant
     */
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
        return login;
    }

    public String getNomComplet() {
        return this.prenom + ' ' + this.nom;
    }

    public abstract String getMail();


//    METHODE ------------------------------------------
    /**
     * Vérifier l'existence d'un adresse pour l'étudiant
     *
     * @return Vrai si l'étudiant à une adresse, Faux sinon
     */
    public boolean existAdresse() {
        return (adresse != null && !(adresse.isEmpty()));
    }



//    SETTER ------------------------------------------

    /**
     * Setter
     *
     * méthode pour la plupart redéfini dans la classe Etudiant
     */
    public void setNom(String nom) {
        this.nom = UniversiteUtilitaire.capitalize(nom);
        setLogin();
    }

    public void setPrenom(String prenom) {
        this.prenom = UniversiteUtilitaire.capitalize(prenom);
        setLogin();
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private void setLogin() {
        this.login = nom.toLowerCase() + prenom.substring(0, 1).toLowerCase();
    }
}
