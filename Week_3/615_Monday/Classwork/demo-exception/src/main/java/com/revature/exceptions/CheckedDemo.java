package com.revature.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedDemo {

    public static void main(String[] args) {
        
        // FileReader FileReader = new FileReader("abc.txt");

        try {
            FileReader FileReader = new FileReader("abc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
