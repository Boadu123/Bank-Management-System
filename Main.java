import java.util.Scanner;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(" What can we help you with");

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
            System.out.println("You deposited" + amount);
        } else {
            System.out.println("Your deposit didn't go through");
        }
    }

    public void withdrawal(double amount){}

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
    public void withdrawal(double funds) {
        if(funds <= 0){
            System.out.println("Widrawal amount must be positive");
        }else if((balance -= funds) < minimumBalance){
            System.out.println("Insufficient balance ");
        }else{
            System.out.println("You have sucessfully debited the money");
        }
        

    }
}

class CurrentAccount extends BankAccount{
    double minimumBalance = -500.00;

    public CurrentAccount(String accountNumber, String accountName, double balance, double minimumBalance) {
        super(accountNumber, accountName, balance);
        this.minimumBalance = minimumBalance;
    }

    public void withdrawal(double funds){
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
    private double interestRate;
    private LocalDate creationDate;
    private LocalDate maturityDate;

    public FixedDeposit(String accountNumber, String accountName, double balance, double interestRate, int maturityMonths) {
        super(accountNumber, accountName, balance);
        this.interestRate = interestRate;
        this.creationDate = LocalDate.now();
        this.maturityDate = creationDate.plusMonths(maturityMonths);
    }

    public void withdrawal(double funds){
        if(LocalDate.now().isBefore(maturityDate)){
            System.out.println("You can't withdraw money until maturity date.");
        } else if(funds <= 0 || funds > balance){
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= funds;
            System.out.println("You have debited " + funds);
        }
    }

    public double accountBalance(){
        if(LocalDate.now().isBefore(maturityDate)){
            return balance;
        } else {
            return balance = balance + (balance * interestRate / 100);
        }
    }
    
    @Override
    public void deposit(double funds){
        System.out.println("Cannot deposit money after creation");
    }

    public void displayMaturityInfo(){
        System.out.println("Your interest rate is " + interestRate);
        System.out.println("You created the account on " + creationDate);
        System.out.println("Your maturity date is" + maturityDate);
    }
}

// Ajala Adeyemi, Ernest Opoku Danso, Kwabena Ofosu Boateng