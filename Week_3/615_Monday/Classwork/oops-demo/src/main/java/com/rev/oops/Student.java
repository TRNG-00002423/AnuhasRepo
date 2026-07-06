package com.rev.oops;

import java.util.Objects;

public class Student {

    private String name;
    private int age;
    // private double cgpa;
    double cgpa;

    static String university = "ABC University";
    static int counter = 0;

    public Student() {
    }

    public Student(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        counter = counter + 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCgpa(double cgpa) {
        if(cgpa>=0 && cgpa<=4.0) {
            this.cgpa = cgpa;
        }
        
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", cgpa=" + cgpa + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;

        Student other = (Student)obj;

        return age==other.age && Double.compare(cgpa, other.cgpa)==0 && name.equals(other.name);
    }

    // @Override
    public int hashCode(Object obj) {
        
        return Objects.hash(name, age, cgpa);
    }

    public void enrolCourse(String courseName) {
        System.out.println("Enrolled in : "+courseName);
    }


    

    

}
