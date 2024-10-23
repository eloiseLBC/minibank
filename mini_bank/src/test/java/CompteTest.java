import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;


public class CompteTest {
    private Compte compte;

    @BeforeEach
    void createInstance(){
        compte = new Compte();
    }

    @Test
    void depositTestInBound(){
        compte.deposit(100);
        Assertions.assertEquals(100, compte.currentAmount);
    }

    @Test
    void depositTestOutOfBound(){
        compte.deposit(100);
        Assertions.assertThrows(CustomException.class, () -> compte.withdraw(200));
    }

    @Test
    void withdrawTest(){
        compte.deposit(100);
        try {
            compte.withdraw(50.0);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(50.0, compte.currentAmount);
    }

    @Test
    void getAmountTest() {
        compte.deposit(100);
        float amount = compte.getAmount();
        Assertions.assertEquals(100, amount);
    }

    @Test
    void withdrawTestInteger() {
        compte.deposit(100);
        try {
            compte.withdraw(50);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(50, compte.currentAmount);
    }

    @Test
    void toStringTest() {
        Compte cpt = new Compte(5000);
        Assertions.assertEquals(cpt.toString(), "Amount = 5000.0");
    }

    @Test
    void negAccountTest(){
        Compte cpt = new Compte(-5000);
        Assertions.assertFalse(cpt.accountStatu());
    }

    @Test
    void posAccountTest(){
        Compte cpt = new Compte(5000);
        Assertions.assertTrue(cpt.accountStatu());
    }

    @Test
    void hashCodeTest(){
        int hashCode = compte.hashCode();
        Assertions.assertEquals(hashCode, compte.hashCode());
    }

    @Test
    void equalsYesTest(){
        Compte c1 = new Compte(100);
        Compte c2 = new Compte(100);
        Assertions.assertTrue(c1.equals(c2));
    }

    @Test
    void equalsNotTest(){
        Compte c1 = new Compte(100);
        Assertions.assertFalse(c1.equals(compte));
    }

    @Test
    void testEqualsNull(){
        Assertions.assertFalse(compte.equals(null));
    }
}
