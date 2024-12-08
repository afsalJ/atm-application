package service;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import utils.DoubleUtils;

public class BankService {

    private Double balance;
    private Queue<String> miniStatement;
    private Integer TRANSACTION_LIMIT = 5;

    public BankService(Double initialAmount){
        this.balance = initialAmount;
        miniStatement = new ArrayDeque<>();
    }

    public String deposit(Double amount){
        if(amount>0){
            balance += amount;
            String statement = (miniStatement.size()+1)+") Deposit: "+DoubleUtils.format(amount)+" Rs Balance: "+DoubleUtils.format(balance)+" RS.\n";
            if(miniStatement.size()==TRANSACTION_LIMIT){
                miniStatement.remove();
            }
            miniStatement.add(statement);
            return "Transaction successfull. New Balance:  "+DoubleUtils.format(balance)+" RS.";    
        }else{
            return "unsuccessfull transaction";
        }
    }

    public String withdraw(Double amount){
        if(amount>0 && balance>=amount){
            balance -=amount;
            String statement = (miniStatement.size()+1)+") Withdraw: "+DoubleUtils.format(amount)+" Rs Balance: "+DoubleUtils.format(balance)+" Rs.\n";
            if(miniStatement.size()==TRANSACTION_LIMIT){
                miniStatement.remove();
            }
            miniStatement.add(statement);
            return "Transaction successfull. New Balance:  "+DoubleUtils.format(balance)+" RS.";
        }else{
            return "unsuccessfull transaction";
        }
    }

    public String balanceInquiry(){
        return "Balance: "+DoubleUtils.format(balance)+" Rs"; 
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
