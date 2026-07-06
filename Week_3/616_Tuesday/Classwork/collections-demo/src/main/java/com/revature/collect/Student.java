package com.rev.collect;

public class Student implements Comparable<Student> {



    private int id;
    private String name;

    public Student() {}

    public Student(int id, String name) {

        this.id = id;
        this.name = name;
    }

     // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // toString Method
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Student o) {
        
        return Integer.compare(this.id, o.id);
    }

    
    

    
}