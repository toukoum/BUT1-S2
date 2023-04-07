package EXAMEN;

public class MenuDeBase {
    private String nom;
    private Plat entree;
    private Plat platPrincipal;
    private Plat dessert;


    /*
     * Constructeur de la classe MenuDeBase
     * @param nom le nom du menu
     * @param entree l'entrée du menu
     * @param platPrincipal le plat principal du menu
     */
    public MenuDeBase(String nom, Plat entree, Plat platPrincipal) {
        this.nom = nom;
        this.entree = entree;
        this.platPrincipal = platPrincipal;
    }


    public String getNom() {
        return nom;
    }

    public Plat getEntree() {
        return entree;
    }

    public Plat getPlatPrincipal() {
        return platPrincipal;
    }

    protected double getPrixDeVenteAvantRemise() {
        return entree.getPrixDeVente() + platPrincipal.getPrixDeVente();
    }


    /*
     * méthode qui calcul un remise sur le prix avant remise
     * @return le prix de vente du menu
     */
    public double getPrixDeVente() {
        return CarteUtilitaire.arrondi(getPrixDeVenteAvantRemise() * 0.8);
    }


    /*La méthode getDescription() de la classe MenuDeBase retourne une chaîne de caractères représentant
       le menu : son nom et les noms des plats le constituant

     */
    public String getDescription(){
        return "Menu " + nom + " : " + entree.getNom() + " - " + platPrincipal.getNom();
    }


}
