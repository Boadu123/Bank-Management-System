class BankAccount {
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

    public void withdrawal(double amount){}

    public double accountBalance() {
        System.out.println("Your balance is " + balance);
        return balance;
    }

    public void showInfo() {
        System.out.println("Your account number is " + accountNumber);
        System.out.println("Your account name is " + accountName);
        System.out.println("Your account balance is " + balance);
    }
}

