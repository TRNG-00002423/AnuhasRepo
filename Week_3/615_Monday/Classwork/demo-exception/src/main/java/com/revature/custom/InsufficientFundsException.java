package com.revature.custom;

public class InsufficientFundsException extends Exception{

    private double shortFall;

    public InsufficientFundsException(double shortFall){
        super("Withdrawl failed ! You are short by : "+shortFall);
        this.shortFall=shortFall;
    }

    public double getShortFall(){
        return shortFall;
    }

}
