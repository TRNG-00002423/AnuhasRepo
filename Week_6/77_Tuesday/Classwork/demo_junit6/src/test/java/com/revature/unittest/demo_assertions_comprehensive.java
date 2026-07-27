package com.revature.unittest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Junit6 Comprehensive Assertions Demo")
public class demo_assertions_comprehensive {

    @Test
    @DisplayName("assertEquals - Comparing Values")
    void demonstrate_assertEquals() {

        // Example 1 : Primitive Comparison
        assertEquals(4, 2+2);
        assertEquals(4, 2+2, "Basic Math Should Work");

        // Example 2 : Variable Comparison
        int expected = 10;
        int actual = 5 + 5;
        assertEquals(expected, actual, "Expected and actual values should be equal");

        // Example 3 : Floating Point Comparison
        double expectedDouble = 0.3;
        double actualDouble = 0.1 + 0.2;
        assertEquals(expectedDouble, actualDouble, 0.0001, "Floating point comparison with delta should be accurate");

        // Example 4 : String Comparison
        String expectedString = "Hello, World!";
        String actualString = "Hello, " + "World!";
        assertEquals(expectedString, actualString, "Strings should match exactly");

        // Example 5 : Array Comparison
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertEquals(expectedArray.length, actualArray.length, "Arrays should have the same length");
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], actualArray[i], "Array elements should match at index "+ i);
        }

        // Example 6A : Object Comparison
        Integer expectedInteger = Integer.valueOf(100);
        Integer actualInteger = Integer.valueOf(100);
        assertEquals(expectedInteger, actualInteger, "Integer objects should be equal");

        // Example 6B : Object Comparison with Custom Objects
        class Person {
            String name;
            Person(String name) {
                this.name = name;
            }

        }

        Person expectedPerson = new Person("Alice");
        Person actualPerson = new Person("Alice");
        assertEquals(expectedPerson.name, actualPerson.name, "Person names should match");


        // Example 7 : Null Comparison
        String nullString = null;
        assertEquals(null, nullString, "Both should be null");  

        // Example 8 : Boolean Comparison
        boolean expectedBoolean = true;
        boolean actualBoolean = (5 > 3);
        assertEquals(expectedBoolean, actualBoolean, "Boolean values should match");

        // Example 9 : Comparing Collections
        java.util.List<Integer> expectedList = java.util.Arrays.asList(1, 2, 3);
        java.util.List<Integer> actualList = java.util.Arrays.asList(1, 2, 3);
        assertEquals(expectedList, actualList, "Lists should be equal");

        // Example 10 : Comparing Maps
        java.util.Map<String, Integer> expectedMap = new java.util.HashMap<>();
        expectedMap.put("one", 1);
        expectedMap.put("two", 2);
        java.util.Map<String, Integer> actualMap = new java.util.HashMap<>();
        actualMap.put("one", 1);
        actualMap.put("two", 2);
        assertEquals(expectedMap, actualMap, "Maps should be equal");

        // Example 11 : Comparing Sets
        java.util.Set<String> expectedSet = new java.util.HashSet<>();
        expectedSet.add("A");
        expectedSet.add("B");
        java.util.Set<String> actualSet = new java.util.HashSet<>();
        actualSet.add("B");
        actualSet.add("A");
        assertEquals(expectedSet, actualSet, "Sets should be equal regardless of order");
        
    }


    @Test
    @DisplayName("assertEquals - With Delta - Floating Point Comparison")
    void demonstrate_floatingPointComparisonWithDelta() {

        // Example 1 : Direct Calculation
        double result = 0.1 + 0.2; // This is not exactly 0.3 due to IEEE 754!

        // BAD : this might fail due to floating point precision issues
        // assertEquals(0.3, result) --> DO NOT DO THIS !

        // GOOD : Use delta (tolerance) for floating point precision
        assertEquals(0.3, result, 0.0001, "Floating point comparison with delta should be accurate");


        // Example 2 : Using Variables for Expected and Actual Values
        double expected = 0.3;
        double actual = 0.1 + 0.2;
        double delta = 0.0001; // Allowable difference
        assertEquals(expected, actual, delta, "Floating point comparison with delta should be accurate");

        // Example 3 : PI Comparison
        double piApproximation = 22.0 / 7.0; // Approximation
        assertEquals(Math.PI, piApproximation, 0.00001, "PI approximation should be within delta of actual PI value");
        assertEquals(piApproximation, Math.PI, 0.01);
    }

    @Test
    @DisplayName("assertNotEquals - Ensuring Values Are Different")
    void demonstrate_assertNotEquals() {
        // Example 1 : Primitive Comparison
        assertNotEquals(5, 10, "5 and 10 should not be equal");
        assertNotEquals("hello", "world");
        assertNotEquals(1,2);
        assertNotEquals(null, "something");
    }


    // Boolean Assertions
    @Test
    @DisplayName("assertTrue and assertFalse - Validating Boolean Conditions")
    void demonstrate_assertTrue_assertFalse() {
        // Example 1 : assertTrue
        assertTrue(5 > 3, "5 is greater than 3");
        assertTrue("hello".startsWith("h"), "String should start with 'h'");
        assertTrue(10 % 2 == 0, "10 is an even number");
        assertTrue(List.of(1, 2, 3).contains(2), "List should contain the number 2");

        // Example 2 : assertFalse
        assertFalse(5 < 3, "5 is not less than 3");
        assertFalse("hello".startsWith("w"), "String should not start with 'w'");
        assertFalse("Hello".isEmpty(), "String should not be empty");
        assertFalse(10 % 2 != 0, "10 is not an odd number");
        assertFalse(List.of(1, 2, 3).contains(4), "List should not contain the number 4");

    }


    @Test
    @DisplayName("Why specific assertions beat assertTrue")
    void demonstrate_specificVSGeneric(){

        int result = 7;

        // LESS INFORMATIVE : "Expected : <true> but was : <false>"
        // assertTrue(result==5);

        // MORE INFORMATIVE : "Expected : <5> but was : <7>"
        assertEquals(5, result, "Specific assertion provides better feedback");
    }


    // Null Assertions
    @Test
    @DisplayName("assertNull and assertNotNull - Validating Null Conditions")
    void demonstrate_nullAssertions() {
        String nullString = null;
        String nonNullString = "I am not null";

        assertNull(nullString, "This string should be null");
        assertNotNull(nonNullString, "This string should not be null");

        // Real World Example : Database Query Result
        // assertNull(repository.findById(-1), "Non-existent ID should return null from the repository");
        // assertNotNull(repository.findById(1), "Existing ID should return an object from the repository");
        // String dbResult = fetchFromDatabase("SELECT name FROM users WHERE id=1");
        // assertNotNull(dbResult, "Database query should return a non-null result");
    }

    // Reference Assertions
    @Test
    @DisplayName("assertSame / assertNotSame - Reference Comparisons")
    void demonstrate_referenceAssertions() {
        String str1 = "hello";
        String str2 = str1;                 // Same Reference
        String str3 = "hello";
        String str4 = new String("hello");  // Different object, same content

        // Same Refrence :
        // assertSame checks if both references point to the same object
        assertSame(str1, str2, "str1 and str2 should reference the same object");
        assertSame(str1, str3, "str1 and str3 should reference the same object");
        assertSame(str2, str3, "str2 and str3 should reference the same object");

        // Different Refrences, Equal Content :
        // assertNotSame checks if both references point to different objects
        assertNotSame(str1, str4, "str1 and str4 should not reference the same object");
        assertNotSame(str2, str4, "str2 and str4 should not reference the same object");
        assertNotSame(str3, str4, "str3 and str4 should not reference the same object");

        // Use assertSame w/ singletons, caching, object identity
        // Use assertEquals with testing value equality
    }


    // @Test
    // @DisplayName("assertTimeout - Performance Constratints - Ensuring Code Completes Within a Time Limit"){
    //     void demonstrateTimeOut() {
    //         // Example 1 : Simple Timeout
    //         assertTimeout(Duration.ofMillis(100), () -> {
    //             // Simulate some work that should complete within 100 milliseconds
    //             Thread.sleep(50);
    //         }, "The operation should complete within 100 milliseconds");

    //         // Example 2 : Timeout with Exception
    //         assertTimeout(Duration.ofSeconds(1), () -> {
    //             // Simulate some work that should complete within 1 second
    //             Thread.sleep(500);
    //         }, "The operation should complete within 1 second");
    //     }

    //     // Operation must complete within the time limit
    //     String result = assertTimeout(Duration.ofSeconds(500), () -> {
    //         // Simulate Quick Operation
    //         Thread.sleep(100); // Simulate some work
    //         return "Completed";
    //     }, "The operation should complete within 500 seconds");

    //     assertEquals("Completed", result, "The result should be 'Completed'");
    // }


    // @Test
    // @DisplayName("assertTimeoutPreemptively - Preemptive Timeout - Ensuring Code Completes Within a Time Limit"){
    //     void demonstratePreemptiveTimeOut() {
    //         // Example 1 : Simple Preemptive Timeout
    //         assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
    //             // Simulate some work that should complete within 100 milliseconds
    //             Thread.sleep(50);
    //         }, "The operation should complete within 100 milliseconds");

    //         // Example 2 : Preemptive Timeout with Exception
    //         assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
    //             // Simulate some work that should complete within 1 second
    //             Thread.sleep(500);
    //         }, "The operation should complete within 1 second");
    //     }

    //     // Operation must complete within the time limit
    //     String result = assertTimeoutPreemptively(Duration.ofSeconds(500), () -> {
    //         // Simulate Quick Operation
    //         Thread.sleep(100); // Simulate some work
    //         return "Completed";
    //     }, "The operation should complete within 500 seconds");

    //     assertEquals("Completed", result, "The result should be 'Completed'");
    // }

}
