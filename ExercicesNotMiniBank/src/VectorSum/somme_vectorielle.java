package VectorSum;

import java.util.Arrays;
import java.util.Scanner;

public class somme_vectorielle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------- Minimum de la somme vectorielle ----------------");
        System.out.println("Which length for tables ? ");
        int len = sc.nextInt();
        int [] tableau1 = new int[len];
        int [] tableau2 = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println("Value " + (i+1) + " of 1st table : ");
            tableau1[i] = sc.nextInt();
            System.out.println("Value " + (i+1) + " of 2nd table : ");
            tableau2[i] = sc.nextInt();
        }
        System.out.println("Table 1 : " + Arrays.toString(tableau1));
        System.out.println("Table 2 : " + Arrays.toString(tableau2));
        int [] tab_somme = new int[len];
        for (int i = 0; i < len; i++) {
            tab_somme[i] = tableau1[i] + tableau2[i];
        }
        Arrays.sort(tab_somme);
        System.out.println(tab_somme[0]);
    }

}
