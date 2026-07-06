package com.example.wednesday.banking;

public class BankingDemo {
    public static void main(String[] args) {
        
        Bank bank = new Bank();

        
        try {
            bank.openAccount("1", 5000);
        } catch (InvalidAccountException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            bank.openAccount("2", 50000);
        } catch (InvalidAccountException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            bank.openAccount("2", 9000); 
        } catch (InvalidAccountException e) {
            e.printStackTrace();
        }

        try {
            bank.getAccount("1").deposit(-500);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (InvalidAccountException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}