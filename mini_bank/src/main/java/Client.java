import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    protected String name;
    protected String surname;
    protected String address;
    protected String phoneNumber;
    private List<Compte> comptes = new ArrayList<>();  // Liste des comptes du client

    // Constructor
    public Client() {
    }

    // Constructor with parameters
    public Client(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public boolean hasCompteEpargne() {
        for (Compte compte : comptes) {
            if (compte instanceof CompteEpargne) {
                return true;
            }
        }
        return false;
    }

    public boolean isPro() {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Client c = (Client) obj;
        return (this.name != null && this.name.equals(c.name))
                && (this.surname != null && this.surname.equals(c.surname))
                && (this.address != null && this.address.equals(c.address))
                && (this.phoneNumber != null && this.phoneNumber.equals(c.phoneNumber));
    }

    @Override
    public String toString() {
        return "name = " +
                name +
                ", surname = " +
                surname +
                ", address = " +
                address +
                ", phoneNumber = " +
                phoneNumber;
    }

    public String getName() {
        return name;
    }
}
