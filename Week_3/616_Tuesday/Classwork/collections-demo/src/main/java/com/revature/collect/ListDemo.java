package com.rev.collect;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {

    public static void main(String[] args) {

        list<String> arrayList = new ArrayList<>();

        arrayList.add("Apple");
        arrayList.add("Bananna");
        arrayList.add(1, "Pineapple");

        List<String> linkedList=new LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Blue");
        linkedList.addFirst("Green");
        linkedList.addLast("Aqua");

        public void add(int index, E element) {
            linkedList.add(index, element);
        }

        E get(int index, E element) {
            linkedList.get(index, element);
            return element;
        }

        E set(int index, E element) {
            linkedList.set(index, element);
            return element;
        }

        // E remove(int index) {

        // }

        // int indexOf(Object o){

        // }


            
    }

}