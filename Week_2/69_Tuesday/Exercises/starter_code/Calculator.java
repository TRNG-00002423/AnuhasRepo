/**
 * Week 2 Exercise — Calculator with static methods and overloads.
 *
 * Division by zero strategy (TODO — choose and implement):
 *   Option A: print error message and return Double.NaN
 *   Option B: return 0.0 and document why (not ideal for production)
 *
 * Compile: javac Calculator.java
 * Run:     java Calculator
 */
public class Calculator {

    public static double add(double a, double b) {

        return a+b;
        // throw new UnsupportedOperationException("Implement add(a,b)");

    }

    /** Sum of three doubles — overloads add(a,b). */
    public static double add(double a, double b, double c) {

        // TODO: should call add twice or sum directly
        // double u = add(add(a,b),c);
        // return u;
        return add(add(a,b),c);
        // throw new UnsupportedOperationException("Implement add(a,b,c)");
    }

    public static double subtract(double a, double b) {

        return a-b;
        // throw new UnsupportedOperationException("Implement subtract");
    }

    public static double multiply(double a, double b) {

        return a*b;
        // throw new UnsupportedOperationException("Implement multiply");
    }

    public static double divide(double a, double b) {

        try {

            double result;
            result = a/b;
            return result;

        } catch (ArithmeticException e) {

            // Gracefully handle the division error
            System.out.println("Error: Cannot divide an integer by zero!");
            System.out.println("Exception message: " + e.getMessage());
        }

        // throw new UnsupportedOperationException("Implement divide with zero check");
    }

    public static void main(String[] args) {

        // TODO: demonstrate all methods including overload and divide-by-zero
        // System.out.println("Implement main");
        System.out.println("\n\n");
        System.out.println("The sum of 10.5 and 20.5 is :"+add(10.5,20.5));
        System.out.println("The sum of 10.5 and 20.5 and 30.5 is :"+add(10.5,20.5, 30.5));
        System.out.println("The subtract of 20.5 and 10.5 is :"+subtract(20.5,10.5));
        System.out.println("The product of 10.5 and 20.5 is :"+multiply(10.5,20.5));
        System.out.println("The quotient of 10.5 and 20.5 is :"+divide(10.5,20.5));
        System.out.println("\n\n");


    }
}
