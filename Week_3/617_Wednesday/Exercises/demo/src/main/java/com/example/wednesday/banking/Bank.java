package com.example.wednesday.banking;

import java.util.Map;

public class Bank {
    // TODO HashMap<String, Account>
    private Map<String, Account> accounts;


    public void openAccount(String id, double initialDeposit) throws InvalidAccountException {
        if(id == null || id == "") {
            throw new InvalidAccountException("INVALID ACCOUNT : ID CANNOT BE EMPTY");
        }
        if (this.accounts.containsKey(id)){
            throw new InvalidAccountException("An account with this id already exists.");
        }
        Account account = new Account(id);
        account.deposit(initialDeposit);
        this.accounts.put(id, account);

    }

    public Account getAccount(String id) throws InvalidAccountException {
        if(id == null || "".equals(id)) {
            throw new InvalidAccountException("INVALID ACCOUNT : ID CANNOT BE EMPTY");
        }
        Account account = accounts.get(id);

        if (account == null) {
            throw new InvalidAccountException("INVALID ACCOUNT");
        }
        return account;
    }

    public void transfer(String fromId, String toId, double amount)
            throws InvalidAccountException, InsufficientFundsException {
                Account Sender = this.getAccount(fromId);
                Account Receiver = this.getAccount(toId);
                Sender.withdraw(amount);
                Receiver.deposit(amount);
    }

}
