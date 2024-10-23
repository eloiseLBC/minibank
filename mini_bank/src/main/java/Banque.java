import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Banque {
    private static Banque instance;
    private final Set<Client> clients = new HashSet<>();

    // Constructor
    Banque() {}

    // Singleton
    public static Banque getInstance() {
        if (instance == null) {
            instance = new Banque();
        }
        return instance;
    }

    // Add client
    public void ajouterClient(Client client) {
        clients.add(client);
    }

    // Add account
    public void ajouterCompte(Client client, Compte compte) {
        if (client.isPro()) {
            if (compte instanceof CompteEpargne && client.hasCompteEpargne()) {
                System.out.println("Le client PRO ne peut avoir qu'un seul compte épargne.");
            } else {
                client.ajouterCompte(compte);
                System.out.println("Compte ajouté au client PRO.");
            }
        } else {
            if (client.getComptes().size() >= 2) {
                System.out.println("Le client standard ne peut avoir que deux comptes.");
            } else {
                client.ajouterCompte(compte);  // Ajout du compte dans la liste de comptes du client
                System.out.println("Compte ajouté au client standard.");
            }
        }
    }

    // Get clients
    public Set<Client> getClients() {
        for (Client client : clients) {
            System.out.println(client);
        }
        return clients;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }
}
