package TP1.universite;

/**
 * La classe Etudiant représente la notion d'étudiant (login, nom, prénom
 et adresse).
 * ATTENTION des contraintes sur la notion d’étudiant :
 * – un étudiant doit toujours avoir un login en minuscule
 * – un étudiant doit toujours avoir un nom et un prénom avec
 * le premier caractère en majuscule et les autres en minuscule.**/

public class Etudiant {
    private String nom;
    private String prenom;
    private String adresse = null;
    private String login;

    Groupe groupe = null;

    private double[] notes = new double[5];

    private int nbreNotes = 0;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        setLogin();
        setNom(nom);
        setPrenom(prenom);
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

    public double[] getNotes() { return notes; }

    public String getLogin() {
        return login;
    }

    public int getNbreNotes() {return nbreNotes;}
    public String getNomComplet() {
        return this.prenom + ' ' + this.nom;
    }

    public String getMail() {
        return login + ("@etu.univ-grenoble-alpes.fr");
    }

    /**
     * Vérifier l'existence d'un adresse pour l'étudiant
     *
     * @return Vrai si l'étudiant à une adresse, Faux sinon
     */
    public boolean existAdresse() {
        return (adresse != null && !(adresse.isEmpty()));
    }

    public boolean existGroupe() {
        return (groupe != null);
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void addNote(double note) {

        if (nbreNotes < 5) {
            notes[nbreNotes] = note;
            nbreNotes += 1;
        }
    }

    public double getMoyenne() {
        double somme = 0;
        for (int i = 0; i < nbreNotes ; i++) {
            somme += notes[i];
        }

        return (somme / nbreNotes);

    }


    public void setNom(String nom) {
        this.nom = EtudiantUtilitaire.capitalize(nom);
        setLogin();
    }

    public void setPrenom(String prenom) {
        this.prenom = EtudiantUtilitaire.capitalize(prenom);
        setLogin();
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private void setLogin() {
        this.login = prenom.toLowerCase() + nom.substring(0, 1).toLowerCase();
    }
}
