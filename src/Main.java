import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

class ATM{
    private List<String> transactionHistory;
    private double balance;
    private Scanner sc;

    public ATM(){
        balance = 0.0;
        transactionHistory = new ArrayList<>();
        sc=new Scanner(System.in);
    }

    public void balanceEnquiry(){
        System.out.println("Your Current balance is : "+balance);
        System.out.println("----------------------------------------------------");

    }

    public void depositMoney(){
        System.out.print("Enter Amount to deposit: ");
        int deposit = sc.nextInt();
        transactionHistory.add("Deposited Rs. "+deposit);
        balance = balance + deposit;
        System.out.println("Deposit Successfull");
        System.out.println("Your current account balance is: "+balance);
        System.out.println("----------------------------------------------------");


    }
    public void withdrawMoney(){
        System.out.print("Enter Amount to withdraw: ");
        int withdraw = sc.nextInt();
        transactionHistory.add("Withdraw Rs. "+withdraw);
        balance = balance - withdraw;
        System.out.println("Withdrawal Successfull");
        System.out.println("Your current account balance is: "+balance);
        System.out.println("----------------------------------------------------");

    }
    public void viewTransactionHistory(){
        for (String transaction :transactionHistory
             ) {
            System.out.println(transaction);
            System.out.println("----------------------------------------------------");

        }
    }

    public void optionsMenu(){
        while(true){
        System.out.println("Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : Transaction History");
        System.out.println("Type 5 : Exit");
        System.out.print("Enter your choice: ");
        int option=sc.nextInt();
        switch (option){
            case 1:
                balanceEnquiry();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                viewTransactionHistory();
                break;
            case 5:
                System.out.println("Thank you for using the ATM");
                exit(0);
            default:
                System.out.println("Invalid option.");

        }

        }
    }

    public void userAuthentication(){
        boolean authenticate = false;
        while(!authenticate){
        System.out.print("Enter your Account no: ");
        int accountNo=sc.nextInt();
        System.out.print("Enter your Pin no: ");
        int pinNo=sc.nextInt();
        if(accountNo==1234567 && pinNo==123){
            System.out.println("Access granted");
            System.out.println("----Welcome to sbi bank----");
            authenticate=true;
        }else{
            System.out.println("Invalid Account or Pin no !!");
        }
        }
    }
}



public class Main {
    public static void main(String[] args) {
        ATM sbi = new ATM();
        sbi.userAuthentication();
        sbi.optionsMenu();

    }
}