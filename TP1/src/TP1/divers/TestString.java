package TP1.divers;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        String maChaine;


        System.out.println("Veuilleez entrez un String :");
        maChaine = lecteur.nextLine();
        System.out.println(maChaine);

        //1.
        System.out.println("nombre char :" + maChaine.length());

        //2.
        System.out.println("maj : " + maChaine.toUpperCase());

        //3.
        System.out.println("Veuilleez entrez un String (2) :");
        String maChaine2 = lecteur.nextLine();

        System.out.print("indentique ? : ");
        if (maChaine.equals(maChaine2)) {
            System.out.println("OUI !");

        }
        else {
            System.out.println("NON !");
        }

        //4.
        maChaine2 = maChaine.toLowerCase();

        System.out.print("minuscule (chaine 1) ? : ");

        if (maChaine.compareTo(maChaine2) == 0) {
            System.out.println("OUI !");

        }
        else {
            System.out.println("NON !");
        }

        //5.
        maChaine = maChaine.strip();
        System.out.println("Sans espace :" + maChaine);


        //6.
        System.out.println("palindrome ?");
        StringBuilder sb=new StringBuilder(maChaine);
        sb.reverse();
        String rev=sb.toString();
        if(maChaine.equals(rev)){
            System.out.println("OUI !");
        }else{
            System.out.println("NON !");
        }
    }



}
