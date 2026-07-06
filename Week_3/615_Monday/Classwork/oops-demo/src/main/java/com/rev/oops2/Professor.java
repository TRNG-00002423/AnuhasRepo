package com.rev.oops2;

public class Professor extends Person{

    double salary;

    public Professor() {
    }

    public Professor(double salary) {
        this.salary = salary;
    }

    public Professor(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void introduce() {
        System.out.println("Hello I Am A Professor");
    }

    

}
