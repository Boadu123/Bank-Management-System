import java.util.Scanner;
import java.util.UUID;

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
                System.out.println("Do you want to know your balance ");
                System.out.println("1. YES ");
                System.out.println("2. NO ");

                int YesOrNo = scanner.nextInt();

                if(YesOrNo == 1){
                    savingsAccount.accountBalance();
                }else if(YesOrNo == 2){
                    System.out.println("Thank you for using our service.");
                } else{
                    System.out.println("Thank you for using our service.");
                }
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
                System.out.println("Do you want to know your balance ");
                System.out.println("1. YES ");
                System.out.println("2. NO ");

                int YesOrNo = scanner.nextInt();

                if(YesOrNo == 1){
                    currentAccount.accountBalance();
                }else if(YesOrNo == 2){
                    System.out.println("Thank you for using our service.");
                } else{
                    System.out.println("Thank you for using our service.");
                }
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




// Ajala Adeyemi, Ernest Opoku Danso, Kwabena Ofosu Boateng