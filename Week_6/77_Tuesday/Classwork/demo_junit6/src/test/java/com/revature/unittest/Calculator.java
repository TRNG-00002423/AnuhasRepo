package com.revature.unittest;

public class Calculator {

    /**
     * Returns the maximum of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the larger of the two numbers
     */
    public int max(int a, int b) {
        return a>b ? a : b;
    }

    /**
     * Returns the minimum of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the smaller of the two numbers
     */
    public int min(int a, int b) {
        return a<b ? a : b;
    }

    /**
     * Returns the sum of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Returns the difference of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the difference of a and b
     */
    public int difference(int a, int b) {
        return a - b;
    }
    
    /**
     * Returns the product of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Returns the quotient of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     * Returns the remainder of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the remainder of a and b
     * @throws ArithmeticException if b is zero
     */
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed.");
        }
        return a % b;
    }

    /**
     * Return the power of a number raised to an exponent.
     * @param base the base number
     * @param exponent the exponent
     * @return the result of base raised to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Negative exponent is not allowed.");
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * Returns the absolute value of an integer.
     * @param value the integer
     * @return the absolute value (always non-negative)
     */
    public int absolute(int value) {
        return value < 0 ? -value : value;
    }

    /**
     * Checks if a number is even.
     * @param number the integer being checked
     * @return true if number is even, false otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if a number is odd.
     * @param number the integer being checked
     * @return true if number is odd, false otherwise
     */
    public boolean isOdd(int number) {
        return !isEven(number);
    }

    /**
     * Checks if a nnumber is positive.
     * @param number the integer being checked
     * @return true if number is positive, false otherwise
     */
    public boolean isPositive(int number) {
        return number > 0;
    }

    
}