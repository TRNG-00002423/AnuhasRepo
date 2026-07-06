package com.example.demo_todolist;

import java.util.ArrayList;
import java.util.List;

public class ToDoListManager {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public String getTask(int index) {
        String task = "";
        try {
             task = tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return task;
    }

    public void completeTask(int index) {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public List<String> listTasks() {
        // String new_String = "";
        for (String item : tasks){
            System.out.println(item);
            // new_String += " ";
            // new_String += item;
            // new_String += "  \n";
        }
        return tasks;

    }

    public int size() {
        return tasks.size();
    }
}
