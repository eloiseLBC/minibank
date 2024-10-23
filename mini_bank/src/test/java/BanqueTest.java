import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BanqueTest {
    private Banque banque;

    @BeforeEach
    void getInstance(){
        banque = new Banque();
    }

    @Test
    void testHashCode(){
        Assertions.assertEquals(banque.hashCode(), banque.hashCode());
    }

    @Test
    void addClient() {
        Client c1 = new Client();
        banque.ajouterClient(c1);
        Assertions.assertTrue(banque.getClients().contains(c1));
    }

    @Test
    void testInstance() {
        int hashcodeFirstBanque = banque.hashCode();
        Banque banque1 = new Banque();
        Assertions.assertEquals(hashcodeFirstBanque, banque1.hashCode());
    }

    @Test
    void testAddOneAccountNotPro() {
        Client c1 = new Client("Le Blanc", "Eloïse", "Bordeaux", "+33652750562");
        Compte cpt1 = new Compte(100);
        banque.ajouterClient(c1);
        banque.ajouterCompte(c1, cpt1);
        Assertions.assertEquals(1, banque.getClients().size());
    }

    @Test
    void testAddThreeAccountNotPro() {
        Client c1 = new Client("Le Blanc", "Eloïse", "Bordeaux", "+33652750562");
        Compte cpt1 = new Compte(100);
        Compte cpt2 = new Compte(50);
        Compte cpt3 = new Compte(951);
        banque.ajouterClient(c1);
        banque.ajouterCompte(c1, cpt1);
        banque.ajouterCompte(c1, cpt2);
        banque.ajouterCompte(c1, cpt3);
        Assertions.assertEquals(2, c1.getComptes().size());
    }

    @Test
    void testAddAccountPro() {
        ClientPro cp1 = new ClientPro("name", "surname","address", "phoneNumber", "siret");
        banque.ajouterClient(cp1);
        Assertions.assertEquals(1, banque.getClients().size());
    }
}
