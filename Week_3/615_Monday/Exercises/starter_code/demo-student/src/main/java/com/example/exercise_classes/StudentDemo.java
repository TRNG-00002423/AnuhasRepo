package com.example.exercise_classes;

public class StudentDemo {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // TODO: create 3 Student instances, print enrollment count,
        // demonstrate equals vs == with two references to same id scenario if possible
    
        
        Student s1 = new Student("Bob", "Biology");
        Student s2 = new Student("Bob", "Biology");
        // Student s2 = new Student["Dan", "Math"];
        Student s3 = new Student("Max", "Bio");
        Student s4 = s1;

        System.out.println("Enrollment Count :"+(Student.getEnrollmentCount()));
        System.out.println("Student s1 == Student s4 :"+(s1==s4));
        System.out.println("Student s1 Equals Student s2 :"+(s1.equals(s2)));
    }
}