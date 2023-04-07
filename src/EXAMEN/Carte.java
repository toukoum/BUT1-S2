package EXAMEN;

import java.util.ArrayList;

public class Carte {
    ArrayList<Plat> plats = new ArrayList<>();
    ArrayList<MenuDeBase> menus = new ArrayList<>();
    ArrayList<Plat> entrees = new ArrayList<>();
    ArrayList<Plat> platsPrincipaux = new ArrayList<>();
    ArrayList<Plat> desserts = new ArrayList<>();



    public Carte() {}

    public void addEntree(Plat entree) {
        plats.add(entree);
        entrees.add(entree);
    }

    public void addPlatPrincipal(Plat platPrincipal) {
        plats.add(platPrincipal);
        platsPrincipaux.add(platPrincipal);
    }

    public void addDessert(Plat dessert) {
        plats.add(dessert);
        desserts.add(dessert);
    }

    /*
        * La méthode addMenu() ajoute un menu à la carte
        * @param menu le menu à ajouter
        * @return void
     */
    public void addMenu(MenuDeBase menu) {
        menus.add(menu);
    }


    /**
     * @return la liste des entrées
     */
    public ArrayList<Plat> getEntrees() {
        return entrees;

    }

    /**
     * @return la liste des plats principaux
     */
    public ArrayList<Plat> getPlatsPrincipaux() {
        return platsPrincipaux;

    }


    /**
     * @return la liste des desserts
     */
    public ArrayList<Plat> getDesserts() {
        return desserts;
    }


    /**
     * @return la liste des menus
     */
    public ArrayList<MenuDeBase> getMenus() {
        return menus;

    }

}
