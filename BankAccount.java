abstract class BankAccount implements BankOperations{
    private String accountNumber;
    private String accountName;
    protected double balance;

    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You deposited" + amount);
        } else {
            System.out.println("Your deposit didn't go through");
        }
    }

    public void deposit(double amount, String note) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You deposited " + amount + ". Note: " + note);
        } else {
            System.out.println("Deposit failed. Amount must be greater than 0.");
        }
    }
    

    public void withdrawal(double amount){}

    public double accountBalance() {
        System.out.println("Your balance is " + balance);
        return balance;
    }

    public double accountBalance(String currency) {
        System.out.println("Your balance in " + currency + " is: " + balance);
        return balance;
    }
    

    public void withdrawal(double amount, String note) {
        System.out.println("Attempting to withdraw " + amount + " for: " + note);
        withdrawal(amount);
    }
    

    public void showInfo() {
        System.out.println("Your account number is " + accountNumber);
        System.out.println("Your account name is " + accountName);
        System.out.println("Your account balance is " + balance);
    }
}

