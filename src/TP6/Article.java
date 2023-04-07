package TP6;

// raphael le plus fort
public class Article {
    private String intitule;
    private double prix;
    private int stock;

    private final int SEUIL = 100;

    public Article(String intitule, double prix, int stock) throws IntituleException, PrixException {

        setStock(stock);
        setIntitule(intitule);
        setPrix(prix);
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule)throws IntituleException{
        //enregistre l’intitule de l’article en faisant respecter les
        //spécifications (modifie la chaîne de caractères passée en paramètre) ; Provoque une
        //exception de type IntituleException si la chaîne de caractères en paramètre est
        //null ou vide

        if (intitule == null || intitule.isEmpty()) {
            throw new IntituleException("L'intitulé ne peut pas être null ou vide");
        }
        this.intitule = ArticleUtilitaire.capitalize(intitule);
    }


    public double getPrix() {
        return prix;
    }


    public double gePris(int quantite) {
        // retourne le prix unitaire si la quantité demandée est
        //inférieur à 100, retourne le prix unitaire avec une ristourne de 10% si la quantité
        //demandée est supérieur ou égal à 100. Créer une constante SEUIL égale à 100 pour
        //votre réalisation.
        if (quantite < SEUIL) {
            return prix;
        } else {
            return prix * 0.9;
        }
    }


    private void setPrix(double prix) throws PrixException{
        // enregistre le prix unitaire de l’article ; Provoque une
        //exception de type PrixException si le prix en paramètre est 0 ou inférieur à 0.

        this.prix = prix;
        if (prix <= 0) {
            throw new PrixException("Le prix ne peut pas être négatif ou égal à 0");
        } else {
            this.prix = prix;
        }
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean existQuantite(int quantite) {
        // retourne true si la quantité demandée est inférieur ou égal au stock, false sinon
        if (quantite <= stock) {
            return true;
        } else {
            return false;
        }
    }


    public void removeQuantite(int quantite) throws StockException{
        // enlève la quantité d’articles demandée en
        //paramètre du stock. Normalement cette méthode ne doit être appelée que si la
        //quantité existe dans le stock (en utilisant la méthode ci-avant). Pour plus de sécurité,
        //cette méthode provoque une une exception de type StockException si la quantité
        //en paramètre n’est pas présente dans le stock.
        if (existQuantite(quantite)) {
            stock -= quantite;
        } else {
            throw new StockException("La quantité demandée n'est pas présente dans le stock");
        }
    }


}
