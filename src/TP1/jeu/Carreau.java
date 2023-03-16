package TP1.jeu;

import java.io.Serializable;
import java.util.*;

public class Carreau implements Serializable {

    Queue<Guerrier> guerriersBleus = new LinkedList<>();
    Queue<Guerrier> guerriersRouges = new LinkedList<>();

    public static final Comparator<Guerrier> comparateurDefenseurs = new Comparator<Guerrier>(){
        @Override
        public int compare(Guerrier o1, Guerrier o2) {
            int result = o1.getDefenseString().compareTo(o2.getDefenseString());
            if (result == 0) {
                if (o1.getPointsDeVie() < o2.getPointsDeVie()) {
                    result = 1;
                } else if (o1.getPointsDeVie() == o2.getPointsDeVie()) {
                    result = 0;
                }else {
                    result = -1;
                }
            }
            return result;
        }
    };

    public Carreau() {
        setGuerriersBleus(guerriersBleus);
        setGuerriersRouges(guerriersRouges);
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

    public void lanceCombat() throws CoupDivinException {
        lanceCombatReel(guerriersBleus, guerriersRouges);
        lanceCombatReel(guerriersRouges, guerriersBleus);
    }

    public void lanceCombatReel(Queue<Guerrier> attaquants, Queue<Guerrier> defenseurs) throws CoupDivinException {
        // tri des défenseurs dans le bon ordre
        Collections.sort((List<Guerrier>)defenseurs, comparateurDefenseurs);
        for (Guerrier guerrier : defenseurs) {
            GuerrierUtilitaire.afficherGuerrierLite(guerrier);
            System.out.println();
        }
        //tous les attaquants doivent attaquer
        for (int i = 0; i < attaquants.size(); i++) {

            int degat = PlateauUtilitaire.De3(attaquants.peek().getForce());

            // Pour le COUP DIVIN
            int forceAttaquant = attaquants.peek().getForce();
            double degatMax = 0.8*(3*forceAttaquant);
            if (degat > degatMax) {
                System.out.print("    \u001b[30mCOMBAT : \u001b[0m");
                GuerrierUtilitaire.afficherGuerrierLite(attaquants.peek());
                System.out.println(" vient de tuer tous les guerriers actuellement sur sa case");
                this.retirerGuerrierDeffenseurs(defenseurs);
                throw new CoupDivinException("    \u001b[33mCOUP DIVIN: \u001b[0mINCROYABLE !!");
            }

            // verif s'il n'y a plus de guerrier à tuer chez les bleus
            if (!defenseurs.isEmpty()) {
                attaquants.peek().attaquer(defenseurs.peek(), degat);
                PlateauUtilitaire.afficheAttaque(attaquants.peek(), defenseurs.peek(), degat);
                // vérif de savoir si le guerrier rouge attaqué est mort
                if (!defenseurs.peek().estVivant()) {
                    // si il est mort, on le supprime de la Queue
                    PlateauUtilitaire.afficheMort(attaquants.peek(), defenseurs.poll());
                    if (defenseurs.isEmpty()) {
                        break;
                    }
                }
            }
            // ajoute le guerrier qui vient d'attaquer à la fin de la Queue en le supprimant de la première place de la Queue
            attaquants.offer(attaquants.poll());
        }

    }

    private void retirerGuerrierDeffenseurs(Queue<Guerrier> defenseurs) {
        if (defenseurs.peek().getCouleur().compareTo(Couleur.Bleu) == 0) {
            this.retirerGuerrierBleu();
        }else {
            this.retirerGuerrierRouge();
        }
    }

    public Queue<Guerrier> getGuerriers(Chateau chateau) {
        if (chateau.estBleu()) {
            return guerriersBleus;
        }else {
            return guerriersRouges;
        }
    }
}
