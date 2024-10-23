public interface Interface {
    <T extends Number> void withdraw(T amount);

    <T extends Number> void deposit(T amount);

    boolean accountStatu();

    float getAmount();
}
