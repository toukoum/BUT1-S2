package TP1.jeu;

import java.util.LinkedList;
import java.util.Queue;

public class Carreau {

    Queue<Guerrier> guerriersBleus = new LinkedList<>();
    Queue<Guerrier> guerriersRouges = new LinkedList<>();

    public Carreau() {
        setGuerriersBleus(guerriersBleus);
        setGuerriersRouges(guerriersRouges);
    }

    public Queue<Guerrier> getGuerriersBleus() {
        return guerriersBleus;
    }

    public Queue<Guerrier> getGuerriersRouges() {
        return guerriersRouges;
    }

    public void setGuerriersBleus(Queue<Guerrier> guerriersBleus) {
        if (!this.guerriersBleus.isEmpty()) {
            for (Guerrier guerrier : guerriersBleus) {
                this.guerriersBleus.offer(guerrier);
            }
        }else {
            this.guerriersBleus = guerriersBleus;
        }
    }

    public void setGuerriersRouges(Queue<Guerrier> guerriersRouges) {
        if (!this.guerriersRouges.isEmpty()) {
            for (Guerrier guerrier : guerriersRouges) {
                this.guerriersRouges.offer(guerrier);
            }
        }else {
            this.guerriersRouges = guerriersRouges;
        }
    }

    public void ajoutGuerriersBleu(Guerrier guerrier) {
        guerriersBleus.add(guerrier);
    }


    public void ajoutGuerrierRouge(Guerrier guerrier) {
        guerriersRouges.add(guerrier);
    }

    public void retirerGuerrierBleu() {
        guerriersBleus.clear();
    }

    public void retirerGuerrierRouge() {
        guerriersRouges.clear();
    }

    public void supprimerGuerrier(Guerrier guerrier) {
        guerriersRouges.clear();
        guerriersBleus.clear();
    }

    public boolean estRouge() {
        return guerriersRouges.size() != 0;
    }

    public boolean estBleu() {
        return guerriersBleus.size() != 0;
    }


    public boolean estChampdeBataille() {
        return estBleu() && estRouge();
    }

    public void lanceCombat() {
        lanceCombat2(guerriersBleus, guerriersRouges);
        lanceCombat2(guerriersRouges, guerriersBleus);
    }

    public void lanceCombat2(Queue<Guerrier> attaquants, Queue<Guerrier> defenseurs) {
        //tous les attaquants doivent attaquer
        for (int i = 0; i < attaquants.size(); i++) {
            int degat = GuerrierUtilitaire.De3(getGuerriersRouges().peek().getForce());

            // verif s'il n'y a plus de guerrier à tuer chez les bleus
            if (!defenseurs.isEmpty()) {
                attaquants.peek().attaquer(defenseurs.peek(), degat);

                System.out.print("    COMBAT : ");
                GuerrierUtilitaire.afficherGuerrierLite(attaquants.peek());
                System.out.print("nique la gueule à ");
                GuerrierUtilitaire.afficherGuerrierLite(defenseurs.peek());
                System.out.println(" (dégât donné : " + degat + " => dégât subi :" + defenseurs.peek().getDegatReel() + ")");
                // vérif de savoir si le guerrier rouge attaqué est mort
                if (!defenseurs.peek().estVivant()) {
                    // si il est mort, on le supprime de la Queue
                    System.out.print("    MORT : " );
                    GuerrierUtilitaire.afficherGuerrierLite(attaquants.peek());
                    System.out.print("KILL ");
                    GuerrierUtilitaire.afficherGuerrierLite(defenseurs.peek());
                    defenseurs.poll();
                }
            }

            // ajoute le guerrier qui vient d'attaquer à la fin de la Queue en le supprimant de la première place de la Queue
            attaquants.offer(attaquants.poll());
        }

    }
}
