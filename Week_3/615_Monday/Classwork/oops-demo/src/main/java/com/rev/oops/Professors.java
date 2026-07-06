package com.rev.oops;

public class Professors {

    private String name;
    private int age;
    private double salary;

    // constructors

    public Professors() {
    }

    public Professors(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    // equals
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }


    // toString
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }


    // hashCode()
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    
}
