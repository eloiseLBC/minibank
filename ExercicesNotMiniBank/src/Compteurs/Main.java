package Compteurs;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Runnable tache1 = new Compteur1();
        Runnable tache2 = new Compteur2();
        Thread thread1 = new Thread(tache1, "Thread 1");
        Thread thread2 = new Thread(tache2, "Thread 2");
        thread1.start();
        // Attendre que thread1 s'arrête avant de lancer thread2
        thread1.join();
        thread2.start();
    }

    public static class Compteur1 implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<=1000; i++){
                System.out.println(i);
            }
        }
    }

    public static class Compteur2 implements Runnable{
        @Override
        public void run() {
            for(int i=1000; i >= 0; i--){
                System.out.println(i);
            }
        }
    }
}
