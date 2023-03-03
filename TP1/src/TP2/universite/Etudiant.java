package TP2.universite;
import TP2.contrainte.ContrainteUtilitaire;
import TP2.contrainte.Note;

import java.util.ArrayList;

/**
 * @Class Etudiant
 * <p>
 * Créer une personne de type étudiant, classe fille de la classe Personne
 * Redéfinition de méthode et surcharge.
 */
public class Etudiant extends Personne {
    private String adresseParents;
    private ArrayList<Note> listeNotes = new ArrayList<>();

    public Etudiant(String login, String nom, String prenom, String adresse, String adresseParents) {
        super(login, nom, prenom, adresse);
        this.adresseParents = adresseParents;
    }

    public Etudiant(String login, String nom, String prenom) {
        super(login, nom, prenom);
    }


    public ArrayList<Note> getListeNotes() {
        return listeNotes;
    }


//    REDEFINITION ------------------------------------------

    /**
     * Méthode de redéfinition de la méthode getAdresse de la classe Personne
     *
     * @return Une chaîne de caractères correspondant à
     * l’adresse principale suivi de l’adresse des parents. Si une seule des deux existe, la
     * méthode ne retourne qu’une adresse soit principale, soit celle des parents.
     */
    @Override
    public String getAdresse() {
        String constructionAdresse = "";
        if (existAdresse()) {
            if (super.existAdresse()) {
                constructionAdresse += super.getAdresse();
            }
            if (adresseParents != null && !(adresseParents.isEmpty())) {
                constructionAdresse += " (Adresse des darons : " + adresseParents + ")";
            }
        }

        return constructionAdresse;

    }


    /**
     * Méthode de redéfinition de la méthode getMail de la classe Personne
     *
     * @return Une chaîne de caractères correspondant à
     * "prenom.nom@etu.univ-grenoble-alpes.fr" (rajoute le "etu." si c'est un étudiant)
     */
    @Override
    public String getMail() {
        return getPrenom() + "." + getNom() + "@etu.univ-grenoble-alpes.fr";
    }


    /**
     * Méthode de redéfinition de la méthode existeAdresse de la classe Personne
     *
     * @return Retourne vrai si l’étudiant à au moins une adresse. (soit un personnel, soit une de ces parents, soit
     * les deux.
     */
    @Override
    public boolean existAdresse() {
        return (((super.existAdresse()) || (adresseParents != null && !(adresseParents.isEmpty()))));
    }


//    SURCHARGE------------------------------------------

    /**
     * Méthode de SURCHARGE de la méthode setAdresse de la classe Personne
     *
     * @void Un étudiant à maintenant deux adresses, la sienne personnelle (héritée de Personne)
     * et celle de ses parents (spécifié dans Etudiant).
     * Cette méthode permet de mettre à jour les deux informations.
     */
    public void setAdresse(String adresse, String adresseParents) {
        super.setAdresse(adresse);
        this.adresseParents = adresseParents;
    }


    public void addNote() {
        Note note = ContrainteUtilitaire.saisirNote(0, 20);
        listeNotes.add(note);
    }


    public double calculMoyenne() {
        int somme = 0;

        for (int i = 0; i < listeNotes.size(); i++) {
            somme += listeNotes.get(i).getValeur();
        }

        return somme/listeNotes.size();
    }
}
