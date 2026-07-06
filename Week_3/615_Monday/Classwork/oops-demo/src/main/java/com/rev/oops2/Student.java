package com.rev.oops2;

public class Student extends Person implements Loginable{

    double cgpa;

    public Student() {
    }

    public Student(double cgpa) {
        this.cgpa = cgpa;
    }

    public Student(String name, int age, double cgpa) {
        super(name, age);
        this.cgpa = cgpa;
    }

    void enrollCourse(String courseName) {
        System.out.println(courseName);
    }

    void enrollCourse(String courseName, int semester) {
        System.out.println(courseName+"  "+semester);
    }

    @Override
    public void introduce() {
        System.out.println("Hello I Am A Student");
    }

    // @Override 
    // void login() {
    //     throw new UnsupportedOperationException("Unimplemented method 'login'");
    // }   
     
    @Override 
    public void login() {
        System.out.println("Login Student");
    }   
    
}
