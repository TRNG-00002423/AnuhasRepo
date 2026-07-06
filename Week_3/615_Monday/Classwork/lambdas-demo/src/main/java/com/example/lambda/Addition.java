package com.example.lambda;

// import java.io.Serializable;

@FunctionalInterface // SAM
public interface Addition {

// public interface Addition extends Serializable{

    int add(int a, int b);
    // int sub(int a, int b);

    // Serializable, Clonable, Remote
    
    default void printInfo() {
        System.out.println("Default Methods ...");
    }
    default void printInfo1() {
        System.out.println("Default Methods ...");
    }
    default void printInfoStack() {
        System.out.println("Default Methods ...");
    }

}
