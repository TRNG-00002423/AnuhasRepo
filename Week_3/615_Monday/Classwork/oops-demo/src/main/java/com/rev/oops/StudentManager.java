package com.rev.oops;


public class StudentManager {

    public static void main(String[] args) {

        System.out.println("\n\n");
        
        // Without Constructors :
        // Student s1 = new Student();

        // s1.name = "Audy";
        // s1.age = 24;
        // s1.cgpa = 3.8;

        // Student s2 = new Student();
        // s2.name = "Utsav";
        // s2.age = 25;
        // s2.cgpa = 3.9;

        // Implemented Constructors
        Student s1 = new Student("Audy", 24, 3.8);
        Student s2 = new Student("Utsav", 26, 3.9);

        // Implemented Static Class Variables
        // System.out.println(Student.university);
        // System.out.println(s1.university);

        // System.out.println(Student.counter);
        // System.out.println(s1.counter);
        
        // Implemented Getter & Setter Methods & Encapsulation through private access modifiers
        s2.cgpa = 100;

        System.out.println(s2.getClass());

        // Implemented over-riding toString method
        System.out.println(s1);
        System.out.println(s2);

        // Implemented over-riding equals method
        Student s3 = new Student("Cody", 25, 3.9);
        Student s4 = new Student("Cody", 25, 3.9);
        // System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        // Implemented enrollCourse method
        s2.enrolCourse("Java");
        
        System.out.println("\n\n");


    }

}
