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
        lanceCombatReel(guerriersBleus, guerriersRouges);
        lanceCombatReel(guerriersRouges, guerriersBleus);
    }

    public void lanceCombatReel(Queue<Guerrier> attaquants, Queue<Guerrier> defenseurs) {
        //tous les attaquants doivent attaquer
        for (int i = 0; i < attaquants.size(); i++) {

            int degat = PlateauUtilitaire.De3(attaquants.peek().getForce());

            // Pour le coup divin
            int forceAttaquant = attaquants.peek().getForce();
            int degatMax = 3*forceAttaquant;

            if (degat > degatMax) {
                try {
                    throw new CoupDivinException();
                } catch (CoupDivinException e) {
                    throw new RuntimeException(e);
                }
            }

            // verif s'il n'y a plus de guerrier à tuer chez les bleus
            if (!defenseurs.isEmpty()) {
                attaquants.peek().attaquer(defenseurs.peek(), degat);
                PlateauUtilitaire.afficheAttaque(attaquants.peek(), defenseurs.peek(), degat);
                // vérif de savoir si le guerrier rouge attaqué est mort
                if (!defenseurs.peek().estVivant()) {
                    // si il est mort, on le supprime de la Queue
                    PlateauUtilitaire.afficheMort(defenseurs.peek());
                    defenseurs.poll();
                    if (defenseurs.isEmpty()) {
                        break;
                    }
                }
            }
            // ajoute le guerrier qui vient d'attaquer à la fin de la Queue en le supprimant de la première place de la Queue
            attaquants.offer(attaquants.poll());
        }

    }
}
