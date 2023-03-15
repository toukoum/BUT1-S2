package TP3.billeterie;

public class Trajet {
    private String depart;
    private String arrivee;
    private int distance;

    public Trajet(String depart, String arrivee, int distance) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.distance = distance;
        setDepart(depart);
        setArrivee(arrivee);
        setDistance(distance);
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart.toUpperCase();
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee.toUpperCase();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        if (distance < 5) {
            this.distance = 5;
        } else if (distance > 2000) {
            this.distance = 2000;
        }
        else {
            this.distance = distance;
        }
    }

    @Override
    public String toString() {
        return "Trajet : " +
                depart + " -> "
                + arrivee + " (" + distance + " km)";
    }
}
