package EXAMEN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class tri {

    public static void main(String[] args) {
//        System.out.println(insertion());
        ArrayList<Integer> liste = insertion();
        
        System.out.println(verifTri(liste));

    }


    public static ArrayList<Integer> triBulle(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Collections.shuffle(list);

        System.out.println(list);

        for (int j = 0; j < list.size(); j++) {
            int min = list.get(j);
            int ind_min = j;

            for (int i = j+1; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                    ind_min = i;
                }
            }
            int temp = list.get(j);
            list.set(j, min);
            list.set(ind_min, temp);

        }


        return list;
    }



    public static ArrayList<Integer> bulleUpgrade(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Collections.shuffle(list);

        System.out.println(list);


        int j = 0;
        boolean swap = true;

        while (swap){
            swap = false;
            int i = list.size()-1;

            while (i > j) {
                if (list.get(i) < list.get(i - 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    swap = true;
                }
                i--;
            }
            j++;
        }

        return list;
    }


    public static ArrayList<Integer> insertion(){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Collections.shuffle(list);

        System.out.println(list);


        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1) > key) {
                list.set(j, list.get(j - 1));
                j--;
            }

            list.set(j, key);

        }
        return list;

    }


    public static boolean verifTri(ArrayList<Integer> liste) {

        int i = 1;

        while (i < liste.size() && liste.get(i - 1) < liste.get(i)) {
            i++;
        }

        return (i == liste.size());

    }
}
