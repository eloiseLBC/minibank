import java.util.Objects;

public class Compte {
    protected float currentAmount;

    // Constructor
    public Compte() {
    }

    // Constructor with parameter
    public Compte(double currentAmount) {
        this.currentAmount = (float) currentAmount;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(currentAmount);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Compte compte = (Compte) obj;
        return (this.currentAmount == compte.currentAmount);
    }

    // toString method
    @Override
    public String toString() {
        return "Amount = " + currentAmount;
    }

    // Get current amount of an account
    public float getAmount() {
        return this.currentAmount;
    }

    // Check if account is positive
    public boolean accountStatu() {
        return (this.currentAmount > 0);
    }

    // Deposit money on an account
    public synchronized <T extends Number> void deposit(T amount) {
        this.currentAmount += (float) amount.doubleValue();
    }

    // Withdraw money from an account
    public synchronized  <T extends Number> void withdraw(T amount) throws CustomException {
        float new_amount = this.currentAmount - (float) amount.doubleValue();
        if (new_amount < 0) {
            throw new CustomException("Solde négatif impossible");
        }
        this.currentAmount = new_amount;
    }
}
