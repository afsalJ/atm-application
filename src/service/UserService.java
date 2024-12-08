package service;

import java.util.Scanner;

public class UserService {
    private BankService bankService;
    private Double INITIAL_AMOUNT = 6000d;

    Scanner sc;
    public UserService(){
        sc = new Scanner(System.in);
        bankService = new BankService(INITIAL_AMOUNT);
        
        while(true){
            System.out.print("Operation: ");
            String operation = sc.nextLine().trim();
            if(operation.equalsIgnoreCase("Deposit")){
                deposit();
            } else if(operation.equalsIgnoreCase("Withdraw")){
                withdraw();
            } else if(operation.equalsIgnoreCase("balance inquiry")){
                balanceInquiry();
            } else if(operation.equalsIgnoreCase("mini statement")){
                getMiniStatement();
            } else{
                System.out.print("You sure want to exit(yes/no): ");
                String isSureExit = sc.nextLine().trim();

                if(isSureExit.equalsIgnoreCase("yes")){
                    return;
                }
            }
            System.out.println("\n");
        }
        
    }

    public void deposit(){
        System.out.print("Amount: ");
        Double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println(bankService.deposit(amount));
    }

    public void withdraw(){
        System.out.print("Amount: ");
        Double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println(bankService.withdraw(amount));
    }

    public void balanceInquiry(){
        System.out.println(bankService.balanceInquiry());
    }

    public void getMiniStatement(){
        System.out.println(bankService.getMiniStatement());
    }
}
