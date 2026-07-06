/**
 * Pair exercise — build sorted array, pick target, time both searches.
 * TODO: complete main after SearchLib is implemented.
 */

import java.util.Random;

public class SearchBenchmark {

    public static void main(String[] args) {
        // TODO: size N, fill sorted even integers, pick target, time SearchLib.linearSearch vs binarySearch
        System.out.println("Implement benchmark");

        int n_one = 1000000;
        int[] first_n = buildSortedEvens(n_one);
        Random rand = new Random();
        int maxLimit = n_one;
        int target = rand.nextInt(maxLimit/2)*2;

        long startTimeLinear = System.currentTimeMillis();
        int linearSearchIndex = SearchLib.linearSearch(first_n, target);
        long endTimeLinear = System.currentTimeMillis();

        long elapsedTimeLinear = endTimeLinear - startTimeLinear;

        long startTimeBinary = System.currentTimeMillis();
        int binarySearchIndex = SearchLib.binarySearch(first_n, target);
        long endTimeBinary = System.currentTimeMillis();

        long elapsedTimeBinary = endTimeBinary - startTimeBinary;


        int n_two = 5000000;
        int[] second_n = buildSortedEvens(n_two);
        maxLimit = n_two;
        int new_target = rand.nextInt(maxLimit/2)*2;

        long startTimeLinear_two = System.currentTimeMillis();
        int linearSearchIndex_two = SearchLib.linearSearch(second_n, new_target);
        long endTimeLinear_two = System.currentTimeMillis();

        long elapsedTimeLinear_two = endTimeLinear_two - startTimeLinear_two;

        long startTimeBinary_two = System.currentTimeMillis();
        int binarySearchIndex_two = SearchLib.binarySearch(second_n, new_target);
        long endTimeBinary_two = System.currentTimeMillis();

        long elapsedTimeBinary_two = endTimeBinary_two - startTimeBinary_two;

        System.out.println("      Round 1 (N = ___)");
        System.out.println("| Algorithm | Time (ms) | Notes |");
        System.out.println("|-----------|-----------|-------|");
        System.out.println("| Linear |"+linearSearchIndex+"|     |");
        System.out.println("| Binary |"+binarySearchIndex+" | |");
        System.out.println("");
        System.out.println("");

        System.out.println("      Round 2 (N = ___)");
        System.out.println("| Algorithm | Time (ms) | Notes |");
        System.out.println("|-----------|-----------|-------|");
        System.out.println("| Linear |"+linearSearchIndex_two+"|     |");
        System.out.println("| Binary |"+binarySearchIndex_two+" | |");
        System.out.println("");



    }

    static int[] buildSortedEvens(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
}
