package com.rev.oops2;

public abstract class Person {
    
    private String name;
    private int age;

    
    public Person() {
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // public void introduce() {
    //     System.out.println("Hello I Am A Person");
    // }

    public abstract void introduce();

    // public abstract void login();
}
