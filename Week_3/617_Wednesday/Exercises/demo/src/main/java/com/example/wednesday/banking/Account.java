package com.example.wednesday.banking;

public class Account {
    // TODO fields: id, balance
    static int nextId;
    private String id;
    private double balance;

    

    public Account(String id) {
        this.id = id;
    }

    public Account(double balance) {
        this.id = String.valueOf(nextId);
        this.balance = balance;
        nextId++;
    }

    public void deposit(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("A Negative Amount Cannot Be Depositted.");
        }
        this.balance +=amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount<0){
            throw new IllegalArgumentException("A Negative Amount Cannot Be Depositted.");
        }
        else if (amount > balance) {
            throw new InsufficientFundsException(amount-balance);
        }
        throw new UnsupportedOperationException("TODO");
    }

}

