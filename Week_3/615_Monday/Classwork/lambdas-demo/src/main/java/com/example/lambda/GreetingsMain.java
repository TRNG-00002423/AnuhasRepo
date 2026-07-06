package com.example.lambda;

public class GreetingsMain {

    public static void main(String[] args) {
        
        // Greeting greet = () -> System.out.print("Greeting");
        // greet.sayHello();
        

        Greeting greet = name-> {
            String nameCaps = name.toUpperCase();
            return "Greetings " + nameCaps;
        };


        // Greeting greet =name->"Greetings "+name.toUpperCase();
        
        System.out.println(greet.sayHello("Jasdhir"));
        // System.out.println(greet.sayHello());

    }

}
