package com.rev.collect;

import java.util.ArrayList;
import java.util.List;


public class SortingDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Kaitlyn");
        names.add("Anuha");
        names.add("Utsav");
        names.add("Benson");
        names.add("Eugene");
        
        System.out.println(names);


        // sort
        Collection.sort(names);

        // sort in reverse order
        
        // Collection.sort(names, Colections.reverseOrder());
        System.out.println(names);



        
    }
}