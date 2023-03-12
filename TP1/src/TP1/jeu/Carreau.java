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
        return guerriersRouges;}

    public void setGuerriersBleus(Queue<Guerrier> guerriersBleus) {
        this.guerriersBleus = guerriersBleus;
    }

    public void setGuerriersRouges(Queue<Guerrier> guerriersRouges) {
        this.guerriersRouges = guerriersRouges;
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

    public void retirerGuerrierRouge(){guerriersRouges.clear();
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

        for (int i = 0; i < guerriersBleus.size(); i++) {
            // parcours de la Queue de guerrier bleu afin qu'ils attaques chacun leur tour
            int degat;
            degat = GuerrierUtilitaire.De3(getGuerriersBleus().peek().getForce());

            // guerrier bleu attaque guerrier rouge
            if (!guerriersRouges.isEmpty()) {
                // Dans le cas ou il n'y a plus de guerrier à tuer chez les rouge
                guerriersBleus.peek().attaquer(guerriersRouges.peek(), degat);

                // vérif de savoir si le guerrier rouge attaqué est mort
                if (!guerriersRouges.peek().estVivant()) {
                    // si il est mort, on le supprime de la Queue
                    guerriersRouges.poll();
                }
            }

            // ajoute le guerrier qui vient d'attaquer à la fin de la Queue en le supprimant de la première place de la Queue
            guerriersBleus.offer(guerriersBleus.poll());


        }

        for (int i = 0; i < guerriersRouges.size(); i++) {
            // parcours de la Queue de guerrier rouge afin qu'ils attaques chacun leur tour
            int degat;
            degat = GuerrierUtilitaire.De3(getGuerriersRouges().peek().getForce());

            // guerrier bleu attaque guerrier rouge
            if (!guerriersBleus.isEmpty()) {
                // Dans le cas ou il n'y a plus de guerrier à tuer chez les bleus
                guerriersRouges.peek().attaquer(guerriersBleus.peek(), degat);

                // vérif de savoir si le guerrier rouge attaqué est mort
                if (!guerriersBleus.peek().estVivant()) {
                    // si il est mort, on le supprime de la Queue
                    guerriersBleus.poll();
                }
            }

            // ajoute le guerrier qui vient d'attaquer à la fin de la Queue en le supprimant de la première place de la Queue
            guerriersRouges.offer(guerriersRouges.poll());



        }
    }
}
