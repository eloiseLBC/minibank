import java.util.Objects;

public class ClientPro extends Client{
    private final String siret;

    // Constructor with parameters
    public ClientPro(String name, String surname, String address, String phoneNumber, String siret) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.siret = siret;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), siret);
    }

    // equals method
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        ClientPro cPro = (ClientPro)obj;
        return (Objects.equals(this.siret, cPro.siret));
    }

    // toString method
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", Siret = " + siret);
        return sb.toString();
    }

    // Check if an account is professional or not
    public boolean isPro(){
        return true;
    }

}
