import java.time.LocalDate;

class FixedDeposit extends BankAccount{
    private double interestRate;
    private LocalDate creationDate;
    private LocalDate maturityDate;

    public FixedDeposit(String accountNumber, String accountName, double balance, double interestRate, int maturityMonths) {
        super(accountNumber, accountName, balance);
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
