// import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(" What type of account do you want to open");
    }
}

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
            System.out.println("You deposited" + balance);
        }
        System.out.println("Your deposit didn't go through");

    }

    public void widrawal(double amount){

    }

    public double accountBalance() {
        return balance;
    }

    public void showInfo() {
        System.out.println("Your account number is " + accountNumber);
        System.out.println("Your account name is " + accountName);
        System.out.println("Your account balance is " + balance);
    }
}

class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
    private double minimumBalance = 50.00;
    @Override
    public void widrawal(double funds) {
        if(funds <= 0){
            System.out.println("Widrawal amount must be positive");
        }else if((balance -= funds) < minimumBalance){
            System.out.println("Insufficient balance ");
        }else{
            System.out.println("You have sucessfully redraw the money");
        }
        

    }
}

class CurrentAccount extends BankAccount{
    double minimumBalance = -500.00;

    public CurrentAccount(String accountNumber, String accountName, double balance, double minimumBalance) {
        super(accountNumber, accountName, balance);
        this.minimumBalance = minimumBalance;
    }

    public void widrawal(double funds){
        if(funds <= 0){
            System.out.println("Widrawal amount must be positive");
        }else if((balance -= funds) < minimumBalance){
            System.out.println("Insufficient balance ");
        }else{
            balance -= funds;
            System.out.println("You have sucessfully redraw " + funds);
        }
    }
    
}

class FixedDeposit extends BankAccount{
    int maturityYears = 5;

    public FixedDeposit(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
}