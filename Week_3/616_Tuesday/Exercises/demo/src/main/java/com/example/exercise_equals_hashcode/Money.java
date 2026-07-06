package com.example.exercise_equals_hashcode;

public class Money {

    private String currency;
    private long amountMinor;

    public Money() {
    }

    public Money(String currency, long amountMinor) {
        if (currency==null) {
            throw new IllegalArgumentException("Currency CANNOT be set to NULL.");
        }
        this.currency = currency;
        this.amountMinor = amountMinor;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmountMinor() {
        return amountMinor;
    }

    public void setAmountMinor(long amountMinor) {
        this.amountMinor = amountMinor;
    }

    

    @Override
    public String toString() {
        return "Money [currency=" + currency + ", amountMinor=" + amountMinor + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + (int) (amountMinor ^ (amountMinor >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (amountMinor != other.amountMinor)
            return false;
        return true;
    }

    
    

}
