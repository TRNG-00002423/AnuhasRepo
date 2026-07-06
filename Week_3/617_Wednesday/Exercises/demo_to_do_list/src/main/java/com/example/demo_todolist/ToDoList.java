package com.example.demo_todolist;

public class ToDoList {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        ToDoListManager TDLM = new ToDoListManager();
        TDLM.addTask("Do Dishes");
        TDLM.addTask("Clean Sink");
        TDLM.addTask("Put Away Groceries");

        System.out.println("The Number Of Tasks Remaining : "+TDLM.size());

        TDLM.listTasks();
        // System.out.println(TDLM.listTasks());

        TDLM.completeTask(0);
        System.out.println("\n");

        System.out.println("The Number Of Tasks Remaining : "+TDLM.size());

        TDLM.listTasks();
        // System.out.println(TDLM.listTasks());
    }
    
}


