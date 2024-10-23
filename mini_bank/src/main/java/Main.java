public class Main {
    public static void main(String[] args) throws InterruptedException {
        Banque banque = Banque.getInstance();
        Client c1 = new Client("Le Blanc", "Eloïse", "Bordeaux", "0652750562");
        Client c2 = new Client("Le Blanc", "Eloïse", "Bordeaux", "0652750562");
        Client c3 = new Client("Rio", "Tokyo", "Berlin", "0555555555");
        ClientPro cPro1 = new ClientPro("Proust", "Lou", "Bordeaux", "0650341795", "123456789");
        Compte cpt1 = new Compte(0);
        CompteEpargne cpt2 = new CompteEpargne(741.3, 5.5);
        CompteEpargne cpt3 = new CompteEpargne(741.3, 5.5);
        Compte cpt4 = new Compte(200);
//        System.out.println(c1.getName());
//        System.out.println(cPro1.getName());
//        System.out.println(c1.isPro());
//        System.out.println(cPro1.isPro());
//        System.out.println(cpt1.getAmount());
//        System.out.println(cpt2.getAmount());
//        System.out.println(c1.equals(c2));
//        System.out.println(c1.equals(c3));
//        System.out.println(cpt1);
//        System.out.println(cpt2);
//        System.out.println(cpt1.accountStatu());
//        System.out.println(cpt2.accountStatu());
        cpt1.deposit((float) 2000);
        cpt2.deposit((float) 1025);
//        System.out.println(cpt1.getAmount());
//        System.out.println(cpt2.getAmount());
//        System.out.println(cpt2.accountStatu());
//        System.out.println(cpt1.hashCode());
        banque.ajouterClient(c1);
        banque.ajouterClient(cPro1);
        banque.ajouterCompte(cPro1, cpt2);
        banque.ajouterCompte(cPro1, cpt3);
        banque.ajouterCompte(c1, cpt1);
        banque.ajouterCompte(c1, cpt4);
        banque.ajouterCompte(c1, cpt2);
//        System.out.println(banque.getClients());
//        try {
//            cpt2.withdraw(78979879);
//        } catch (CustomException e) {
//            System.out.println("Exception : " + e.getMessage());
//        }
        Runnable withdraw1 = new Threads(cpt1, "withdraw", 1000);
        Runnable deposit1 = new Threads(cpt1, "deposit", 1000);
        Thread thread1 = new Thread(withdraw1, "Retrait 1");
        Thread thread2 = new Thread(withdraw1, "Retrait 2");
        Thread thread3 = new Thread(deposit1, "Dépôt 1");
        Thread thread4 = new Thread(deposit1, "Dépôt 2");
        Thread thread5 = new Thread(deposit1, "Dépôt 3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread5.join();
        System.out.println(cpt1);
    }
}
