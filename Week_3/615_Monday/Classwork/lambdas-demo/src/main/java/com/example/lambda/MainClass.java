package com.example.lambda;

public class MainClass {
    public static void main(String[] args) {
        AdditionImpl additionImpl = new AdditionImpl();
        System.out.println(additionImpl.add(10, 20));

        Addition sum = (a,b)->a+b;
        int result = sum.add(10,20);

        // lambda - 3 parts :
            // Parameter
            // Aarow
            // Body

        // Parameter Aarow Body
        
        
    }
}