package com.rev.arrays;

public class ArraysDemo {

    public static void main(String[] args) {

        // int[] myArray = new int[5];

        String [] courses = {
            "Java", "Databases", 
            "Operating System"
        };


        for(int i=0;i<courses.length; i++)
            System.out.println(courses[i]);
        

        for(String course:courses)
            System.out.println(course);
        
            
        String[] names = {"Curtis", "Juan", "Audy"};
        int[] ages = {24,22,23};
    }
}
