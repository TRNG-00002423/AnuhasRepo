package com.revature;

public class Greeter {



    public String hello(String name) {

        if(name.isEmpty()) {
            throw new IllegalArgumentException("The input cannot be left blank !");
        }

        return "Hello "+name;
        
    }


}
