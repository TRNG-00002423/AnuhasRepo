package com.revature.custom;

public class BankAccount {


    private double balance;


    public BankAccount(double balance) {
        this.balance = balance;
    }

    
    public void withdraw(double amount) throws InsufficientFundsException { // 2000

        if(amount>balance) {
            double shortFall=amount-balance;
            throw new InsufficientFundsException(shortFall);
        }
        // balance = balance - amount;
        balance -= amount;
        System.out.println("Withdrawl Successful");
    

    }


    



}
