class CurrentAccount extends BankAccount{
    double minimumBalance = 100.00;
    double overdraft = -500.00;

    public CurrentAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }

    public void withdrawal(double funds){
        if(funds <= 0){
            System.out.println("Widrawal amount must be positive");
        }else if((balance - funds) < overdraft){
            System.out.println("Insufficient balance ");
        }else{
            balance -= funds;
            System.out.println("You have successfully debited " + funds);
        }
    }
    
}