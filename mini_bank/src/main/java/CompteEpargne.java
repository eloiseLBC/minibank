import java.util.Objects;

public class CompteEpargne extends Compte {
    float interet;

    public CompteEpargne(double currentAmount, double interet){
        this.currentAmount = (float)currentAmount;
        this.interet = (float)interet;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), interet);
    }

    public boolean equalsWithInteret(Object obj, float interet){
        if (!this.equals(obj)) return false;
        return this.interet == interet;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", Interet: " + interet);
        return sb.toString();
    }
}
