import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ClientTest {
    private Client client;

    @BeforeEach
    public void getInstance() {
        client = new Client();
    }

    @Test
    void testIsPro(){
        Assertions.assertFalse(client.isPro());
    }

    @Test
    void testHashCode(){
        Assertions.assertEquals(client.hashCode(), client.hashCode());
    }

    @Test
    void testToString(){
        String toStringMessage = "name = Le Blanc, surname = Eloïse, address = Bordeaux, phoneNumber = +33652750562";
        Client client = new Client("Le Blanc", "Eloïse", "Bordeaux", "+33652750562");
        Assertions.assertEquals(toStringMessage, client.toString());
    }

    @Test
    void testGetName() {
        Client c = new Client("Le Blanc", "Eloïse", "Bordeaux", "+33652750562");
        Assertions.assertEquals("Le Blanc", c.getName());
    }

    @Test
    void testEquals(){
        Client c1 = new Client("Le Blanc", "Eloïse", "Bordeaux", "0652750562");
        Client c2 = new Client("Le Blanc", "Eloïse", "Bordeaux", "0652750562");
        Assertions.assertTrue(c1.equals(c2));
    }

    @Test
    void testEqualsNull(){
        Assertions.assertFalse(client.equals(null));
    }

    @Test
    void testEqualsFalse() {
        Client c1 = new Client("Le Blanc", "Eloïse", "Bordeaux", "0652750562");
        Assertions.assertFalse(c1.equals(client));
    }

    @Test
    void testAddCount() {
        Compte compte = new Compte(100);
        client.ajouterCompte(compte);
        List<Compte> lstCpt = client.getComptes();
        List cpt = List.of(compte);
        Assertions.assertEquals(lstCpt, cpt);
    }

    @Test
    void testHasEpargne(){
        Compte compte = new Compte(100);
        client.ajouterCompte(compte);
        Assertions.assertFalse(client.hasCompteEpargne());
    }
}
