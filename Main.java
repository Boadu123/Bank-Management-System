import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Which accounts do you want to create: 1.Savings Account 3.Fixed Deposit Account");
        System.out.println(" 1.Savings Account");
        System.out.println(" 2.Current Account ");
        System.out.println(" 3.Fixed Deposit Account ");

        int account = scanner.nextInt();
        scanner.nextLine();

        if( account == 1){
            System.out.print("Enter full name ");
            String accountName = scanner.nextLine();

            System.out.print("Enter initial amount to deposit ");
            double initialDeposit = scanner.nextDouble();

            String accountNumber = UUID.randomUUID().toString().substring(0, 8);

            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountName, initialDeposit);

            System.out.println("You have successfully created a savings account");
            savingsAccount.showInfo();

            System.out.println("Do you want to withdraw money from your account");
            System.out.println("1.YES ");
            System.out.println("2.NO ");
            int answer = scanner.nextInt();

            if( answer == 1 ){
                System.out.println("How much are you redrawing ");
                double amount = scanner.nextInt();
                savingsAccount.withdrawal(amount);
            }else if( answer == 2){
                System.out.println("Thank you for using our service.");
            } else{
                System.out.println("Thank you for using our service ");
            }

        } else if( account == 2){
            System.out.println("Enter your full name ");
            String accountName = scanner.nextLine();

            System.out.println("Enter your initial amount for deposit ");
            double minimumBalance = scanner.nextDouble();

            String accountNumber = UUID.randomUUID().toString().substring(0, 8);

            CurrentAccount currentAccount = new CurrentAccount(accountNumber, accountName, minimumBalance);

            System.out.println("You have successfully created a current account ");
            currentAccount.showInfo();

            System.out.println("Do you want to withdraw money from your account");
            System.out.println("1.YES ");
            System.out.println("2.NO ");
            int answer = scanner.nextInt();

            if( answer == 1 ){
                System.out.println("How much are you redrawing ");
                double amount = scanner.nextInt();
                currentAccount.withdrawal(amount);
            }else if( answer == 2){
                System.out.println("Thank you for using our service.");
            } else{
                System.out.println("Thank you for using our service ");
            }

        } else if( account == 3){
            System.out.println("Enter your full name ");
            String accountName = scanner.nextLine();

            System.out.println("Enter your initial amount for the account");
            double minimumBalance = scanner.nextDouble();

            int interestRate = 25;
            int maturityMonths = 120;

            String accountNumber = UUID.randomUUID().toString().substring(0, 8);

            FixedDeposit fixedDeposit = new FixedDeposit(accountNumber, accountName, minimumBalance, interestRate, maturityMonths);

            fixedDeposit.showInfo();
                        
            System.out.println("You have successfully created a fixed Deposit account for 10 years");

            
        }

        scanner.close();
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
            System.out.println("You have sucessfully debited " + funds);
        }
    }

}

class CurrentAccount extends BankAccount{
    double minimumBalance = 100.00;
    double overdraft = -500.00;

    public CurrentAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }

    public void withdrawal(double funds){
        if(funds <= 0){
            System.out.println("Widrawal amount must be positive");
        }else if((balance -= funds) < overdraft){
            System.out.println("Insufficient balance ");
        }else{
            balance -= funds;
            System.out.println("You have successfully debited " + funds);
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
            System.out.println("You have successfully debited " + funds);
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