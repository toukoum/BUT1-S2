package TP2.telephone;

import java.util.ArrayList;

public class TestTelephone {

    public static void main(String[] args) {

        ArrayList<Processeur> processeurs = new ArrayList<>();
        processeurs.add(new Processeur("Octa-Core", 2.84));
        processeurs.add(new Processeur("Octa-Core", 3));

        ArrayList<Memoire> ram = new ArrayList<>();
        ram.add(new Memoire("LPDDR5 4G", 4));
        ram.add(new Memoire("LPDDR5 8G", 8));

        ArrayList<Memoire> stockage = new ArrayList<>();
        stockage.add(new Memoire("UFS Storage 3.1", 64));
        stockage.add(new Memoire("UFS Storage 3.1", 128));
        stockage.add(new Memoire("UFS Storage 3.1", 256));

        ArrayList<Ecran> ecran = new ArrayList<>();
        ecran.add(new Ecran("3 amoled", 5));
        ecran.add(new Ecran("3 amoled", 6));
        ecran.add(new Ecran("3 amoled", 7));



        Telephone telephone1 = new Telephone("Bas de gamme", processeurs.get(0), stockage.get(0), ecran.get(0));
        telephone1.addRam(ram.get(0));

        System.out.println(telephone1);


    }
}
