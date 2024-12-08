package service;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BankService {

    private Double balance;
    private Queue<String> miniStatement;
    private Integer TRANSACTION_LIMIT = 5;

    public BankService(Double initialAmount){
        this.balance = initialAmount;
        miniStatement = new ArrayDeque<>();
    }

    public String deposit(Integer amount){
        if(amount>0){
            balance += amount;
            String statement = "Deposit: "+amount+" Rs Balance: "+balance+" RS.\n";
            if(miniStatement.size()==TRANSACTION_LIMIT){
                miniStatement.remove();
            }
            miniStatement.add(statement);
            return "Transaction successfull. New Balance:  "+balance+" RS.";    
        }else{
            return "unsuccessfull transaction";
        }
    }

    public String withdraw(Integer amount){
        if(amount>0 && balance>=amount){
            balance -=amount;
            String statement = "Withdraw: "+amount+" Rs Balance: "+balance+" Rs.\n";
            if(miniStatement.size()==TRANSACTION_LIMIT){
                miniStatement.remove();
            }
            miniStatement.add(statement);
            return "Transaction successfull. New Balance:  "+balance+" RS.";
        }else{
            return "unsuccessfull transaction";
        }
    }

    public String balanceInquiry(){
        return "Balance: "+balance+" Rs"; 
    }

    public String getMiniStatement(){
        Iterator<String> iterator = miniStatement.iterator();
        String statements = "";
        while(iterator.hasNext()){
            statements += iterator.next();
        }
        return statements;
    }
    
}
