package com.example.exercise_equals_hashcode;


import java.util.HashSet;
import java.util.Set;

public class MoneyDemo {

    public static void main(String[] args) {

        Money m1 = new Money("CAD", 142L);

        Money m2 = new Money("UAE", 27L);

        Money m3 = new Money("MXN", 1747L);

        Money m4 = m3;

        Set<Money> MoneySet = new HashSet<>();

        MoneySet.add(m1);
        MoneySet.add(m2);
        MoneySet.add(m3);
        MoneySet.add(m4);

        System.out.println("Equals Example : m1.equals(m2) --> "+m1.equals(m2));

        System.out.println("== Example : m1==m2 --> "+(m1==m2));

        System.out.println("");

        System.out.println("");

        


        
    }

}
