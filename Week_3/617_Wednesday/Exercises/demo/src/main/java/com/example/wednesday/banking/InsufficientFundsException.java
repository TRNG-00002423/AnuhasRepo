package com.example.wednesday.banking;

/** Checked — include shortfall. */
public class InsufficientFundsException extends Exception {

    // private final double shortfall;

    public InsufficientFundsException(String message) {
        super(message);
        // this.shortfall = shortfall;
    }

    

    public InsufficientFundsException(double shortfall) {
        System.out.println("Attempted To Over Draft By : $"+shortfall);
    }


}
