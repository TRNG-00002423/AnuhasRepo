package com.rev.collection;


import java.util.PriorityQueue;
import java.util.Queue;


public class QueueDemo {

    public static void main(Stringp[] args) {

        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);


        System.out.println(pq);

    }
}