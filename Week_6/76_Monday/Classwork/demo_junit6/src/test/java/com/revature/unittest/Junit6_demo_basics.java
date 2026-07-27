package com.revature.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.unittest.Calculator;


// @DisplayName is a JUnit 5 annotation that allows you to provide a custom name for your test class or test method. 
// This name will be displayed in the test reports and can make your tests more readable and understandable.
// TLDR : Provides human-readable test names in reports
@DisplayName("Calculator Basic Tests - JUnit6 Fundamentals")
public class Junit6_demo_basics {


    // The System Under Test (SUT) 
    // is the class that we are testing. In this case, it is the Calculator class.
    private final Calculator calculator = new Calculator();

    // Basic Test Structure in JUnit 6
    // 1. Arrange: Set up the necessary preconditions and inputs.
    // 2. Act: Execute the method under test with the arranged inputs.
    // 3. Assert: Verify that the action of the method under test behaves as expected


    // Basic Test Structure

    @Test
    @DisplayName("Adding Two Positive Numbers Returns Correct Sum")
    void add_twoPositiveNumbers_returnsCorrectSum() {
        // Arrange - Set up the TEST DATA --> necessary preconditions and inputs.
        int a = 5;
        int b = 10;

        // Act - Execute the method under test --> with the arranged inputs.
        int result = calculator.sum(a, b);

        // Assert - Verify Outcome --> that the action of the method under test behaves as expected.
        assertEquals(15, result, "5 + 10 should equal 15");
    }


    @Test
    @DisplayName("Subtracting Two Positive Numbers Returns Correct Difference")
    void subtract_twoPositiveNumbers_returnsCorrectDifference() {
        // Arrange - Set up the TEST DATA
        // int a = 10;
        // int b = 5;

        // Act - Execute the method under test
        // int result = calculator.difference(a, b);

        // Assert - Verify Outcome
        // assertEquals(5, result, "10 - 5 should equal 5");

        // Simple One Liner when Logic Is Straightforward
        assertEquals(5, calculator.difference(10, 5), "10 - 5 should equal 5");
    }

    // Testing Edge Cases
    @Test
    @DisplayName("Adding Zero to a Number Returns the Original Number")
    void add_zero_toNumber_returnsOriginalNumber() {
        // Simple One Liner when Logic Is Straightforward
        assertEquals(10, calculator.sum(10, 0), "10 + 0 should equal 10");
        assertEquals(10, calculator.sum(0, 10), "0 + 10 should equal 10");
    }

    @Test
    @DisplayName("Multiplying by Zero Returns Zero")
    void multiply_byZero_returnsZero() {
        // Simple One Liner when Logic Is Straightforward
        assertEquals(0, calculator.multiply(100, 0), "10 * 0 should equal 0");
        assertEquals(0, calculator.multiply(0, 100), "0 * 100 should equal 0");
    }

    @Test
    @DisplayName("Negative Numbers are Handled Correctly in Addition")
    void add_negativeNumbers_returnsCorrectSum() {
        // Simple One Liner when Logic Is Straightforward
        assertEquals(-5, calculator.sum(-10, 5), "-10 + 5 should equal -5");
        assertEquals(-15, calculator.sum(-10, -5), "-10 + -5 should equal -15");
        assertEquals(5, calculator.sum(10, -5), "10 + -5 should equal 5");
    }

    // Boolean Assertions
    @Test
    @DisplayName("Even Number Detection Works Correctly")
    void isEven_evenNumber_returnsTrue() {
        // Simple One Liner when Logic Is Straightforward
        assertEquals(true, calculator.isEven(2), "2 is an even number");
        assertEquals(true, calculator.isEven(0), "0 is an even number");
        assertEquals(true, calculator.isEven(-4), "-4 is an even number");

        assertEquals(false, calculator.isEven(1), "1 is not an even number");
        assertEquals(false, calculator.isEven(7), "7 is not an even number");
        assertEquals(false, calculator.isEven(-3), "-3 is not an even number");
    }


    @Test
    @DisplayName("Positive Number Detection Works Correctly")
    void isPositive_positiveNumber_returnsTrue() {
        // Simple One Liner when Logic Is Straightforward
        assertEquals(true, calculator.isPositive(1), "1 is a positive number");
        assertEquals(true, calculator.isPositive(100), "100 is a positive number");

        assertEquals(false, calculator.isPositive(0), "0 is not a positive number");
        assertEquals(false, calculator.isPositive(-1), "-1 is not a positive number");
    }

    // methodName_scenario_expectedBehavior
    // methodName_condition_expectedResult

    @Test
    void max_firstLargerThanSecond_returnsFirst() {
        assertEquals(10, calculator.max(10, 5), "max(10, 5) should return 10");
    }

    @Test
    void max_secondLargerThanFirst_returnsSecond() {
        assertEquals(20, calculator.max(10, 20), "max(10, 20) should return 20");
    }

    @Test
    void max_bothEqual_returnsEither() {
        assertEquals(15, calculator.max(15, 15), "max(15, 15) should return 15");
    }

    
    // Other Common Patterns :

    // should_expectedBehavior_when_scenario
    // given_precondition_when_action_then_result

    // should_expectedBehavior_when_condition
    // given_precondition_when_action_then_expectedResult


    
    // @Test
    // @DisplayName("Multiplying Two Positive Numbers Returns Correct Product")
    // void multiply_twoPositiveNumbers_returnsCorrectProduct() {
    //     // Simple One Liner when Logic Is Straightforward
    //     assertEquals(50, calculator.multiply(10, 5), "10 * 5 should equal 50");
    // }

}
