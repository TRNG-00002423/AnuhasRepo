package com.rev.collect;


public class MapDemo {

    public static void main(String[] args) {

        Map<String, Double> score = new HashMap<>();

        scores.put("John", 90.2);
        scores.put("Audy", 90.2);
        scores.put("Cutis", 89.3);
        scores.put("John", 89.3);           // key John is updated to new value / latest value
        scores.put("Other2", 89.3);
        
        System.out.println(scores);

        // Allows you to iterate over a map using an Entry set or a Key set

        

        for(Map.Entry<String, Double> entry: scores.entrySet()) {

            System.out.println(entry.getKey()+ "scored - "+entry.getValue());

        }

        

    }
}