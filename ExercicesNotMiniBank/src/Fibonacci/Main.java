package Fibonacci;
import java.util.Scanner;


public class Main {
    public static void fibonacci(int n){
        int f0 = 0;
        int f1 = 1;
        System.out.println("Suite de Fibonacci: ");
        for (int i = 0; i < n; i++) {
            int sum = f0 + f1;
            f0 = f1;
            f1 = sum;
        }
        System.out.println("Le " + n + "ème élément de la suite de Fibonacci est : " + f0);
    }

    public static void entiers(int n){
        boolean isPrime = true;
        for (int i = n; i > 0; i--) {
            if (n % i == 0 && i != n && i != 1) {
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            System.out.println("L'entier " + n + " est un nombre premier.");
        } else {
            System.out.println("L'entier " + n + " n'est pas un nombre premier.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel entier choisissez vous ? ");
        int n = sc.nextInt();
        System.out.println("Fibonacci ou entiers ? ");
        int choix = sc.nextInt();
        if(choix == 1){
            fibonacci(n);
        } else {
            entiers(n);
        }
        sc.close();
    }
}
