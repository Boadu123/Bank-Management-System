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
