package EXAMEN;

public class CarteUtilitaire {
    
    



    /**
    permet d’afficher la carte sur le terminal.
    Cette méthode est utilisée dans la classe TestCarte

     @param carte
     */
    public static void printCarte(Carte carte) {

        // Afficher les menus
        // A COMPLETER
        for (MenuDeBase menu : carte.getMenus()) {
            System.out.println(menu.getDescription());
            System.out.println(menu.getPrixDeVente() + "euros");
            System.out.println();
        }

        
        // Afficher les entrées
        System.out.println("\nEntrées : ");
        for (Plat plat : carte.getEntrees()) {
            System.out.println(plat.getNom() + " " + plat.getPrixDeVente() + "€");
        }


        // Afficher les plats
        System.out.println("\nPlats principaux : ");
        for (Plat plat : carte.getPlatsPrincipaux()) {
            System.out.println(plat.getNom() + " " + plat.getPrixDeVente() + "€");
        }
        
        // Afficher les desserts
        System.out.println("\nDesserts : ");
        for (Plat plat : carte.getDesserts()) {
            System.out.println(plat.getNom() + " " + plat.getPrixDeVente() + "€");
        }
    }
    
    
    /**
     * 
     * Cette méthode renvoie l'entier le plus proche supérieur ou égal à l'argument
     * 
     * NE PAS MODIFIER
     * 
     * @param valeur
     * @return entier le plus proche supérieur ou égal à l'argument
     */
    public static double arrondi(double valeur) {
        return Math.ceil(valeur);
    }

    /**
     * Transforme la chaine de caractères passée en paramètre :
     * - Première lettre en majuscule
     * - Le reste en minuscule
     *
     * @param chaine de caractères
     *
     * @return chaine premier caractère majuscule suivi de minuscule
     */
    public static String capitalize(String chaine) {
        return chaine.substring(0,1).toUpperCase() + chaine.substring(1,chaine.length()).toLowerCase();
    }
}
