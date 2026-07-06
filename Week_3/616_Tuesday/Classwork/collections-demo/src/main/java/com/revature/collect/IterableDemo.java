package com.revature.collect;

import java.util.ArrayList;
import java.util.List;

public class IterableDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add(23);
        list.add("Kotlin");
        list.add("Maven");
        list.add(23.23);


        System.out.println(list.size());


        // for(int i=0; i<list.size(); i++) {

        // }


        Iterator<String> listIterator=list.iterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("-------------------------------------");
        // for(String a:collection)


        // for(String element: list)
        // for(Object element: list)


    }
}