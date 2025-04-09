public interface BankOperations {
    void deposit(double amount);
    void withdrawal(double amount);
    double accountBalance();
    void showInfo();
}