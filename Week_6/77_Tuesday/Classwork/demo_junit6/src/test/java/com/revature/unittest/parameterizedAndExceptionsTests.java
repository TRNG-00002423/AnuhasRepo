package com.revature.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

// import org.junit.jupiter.api.Assertions.assertTrue;

import com.revature.unittest.Calculator;


public class parameterizedAndExceptionsTests {

    // Parameterized Tests - Data-Driven Testing
    // @ParameterizedTest replaces @Test for data-driven tests
    // Various Sources : @ValueSource, @CsvSource, @MethodSource, @EnumSource
    // Write Logic Once, Run With Many Inputs
    // Required Dependency : junit-jupiter-params

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("ValueSource Examples")
    class ValueSourceExamples{

        @ParameterizedTest
        @ValueSource(ints = {2, 4, 6, 8, 0, -2, 100})
        @DisplayName("Even Numbers should be identified correctly")
        void isEven_evenNumbers_returnsTrue(int number){
            assertTrue(calculator.isEven(number), number + "should be even");
        }

        @ParameterizedTest
        @ValueSource(strings = {"hello", "world", "JUnit6", "Testing"})
        @DisplayName("Strings can be parameterized too")
        void stringLength_variousStrings_calculated(String input){
            assertTrue(input.length()>0);
        }
    }


    @Nested
    @DisplayName("Null and Empty Source Examples")
    class NullEmptyExamples {

        @ParameterizedTest
        @NullSource
        @DisplayName("Null Input Handling")
        void handleNull_nullInput_handled(String input){
            assertNull(input);
        }

        @ParameterizedTest
        @EmptySource
        @DisplayName("Empty String Handling")
        void handleEmpty_emptyInput_handled(String input) {
            assertTrue(input.isEmpty());
        }

        @ParameterizedTest
        @NullAndEmptySource
        // @ValueSource(strings = {null, "", " ", "\t", "\n"})
        @ValueSource(strings = {"", " ", "\t", "\n"})
        @DisplayName("Blank Strings Shuld Be Rejected")
        void validateInput_blankInputs_rejected(String input){
            // Combine Source For Comprehensive Blank Checking

            assertTrue(input == null || input.isEmpty() || input.trim().isEmpty());
        }
    }

    @Nested
    @DisplayName("@CsvSource Examples")
    class CsvSourceExamples{
        
        @ParameterizedTest
        @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, 1, 0",
            "100, 200, 300",
            "-5, -10, -15"
        })

        @DisplayName("Addition with various inputs")
        void add_variousInputs_correctResult(int a, int b, int expected){
            assertEquals(expected, calculator.sum(a,b));
        }


        @ParameterizedTest(name= "{0}+{1}={2}") // Csutom Display Name
        @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "10, 20, 30"
        })

        @DisplayName("Addition With Custom Display Names")
        void add_withCustomDisplayName(int a, int b, int expected){
            assertEquals(expected, calculator.sum(a,b));
        }

        @ParameterizedTest
        @CsvSource(value = {
            "hello | 5",
            "world | 5",
            "JUnit | 5",
            "testing | 7"
        }, delimiter = '|') // Custom Delimiter


        @DisplayName("String Length With Pipe Delimiter")
        void stringLength_customDelimiter(String input, int expectedLength){
            assertEquals(expectedLength, input.length());
        }
    
    }



    @Nested
    @DisplayName("@MethodSource Examples")
    class MethodSourceExamples {
        
        @ParameterizedTest
        @MethodSource("provideNumbersForAbsoluteValue");
        @DisplayName("Absolute Value Calculation")
        void absoluteValue_variousNumbers_correctResult(int input, int expected){
                assertEquals(expected, calculator.absolute(input));
        }


        // Provider method must be static and return Stream<Arguments>
        static Stream<Arguments> provideNumbersForAbsoluteValue(){
            return Stream.of(
                Arguments.of(5,5),
                Arguments.of(-5,5),
                Arguments.of(0,0),
                Arguments.of(-100,100),
                Arguments.of(Integer.MIN_VALUE+1, Integer.MAX_VALUE) // Edge Case
            )
        }

        @ParameterizedTest
        @MethodSource("provideMinMaxTestCases")
        @DisplayName("Min/Max operations")
        void minMax_variousCases_correctResult(int a, int b, int expectedMin, int expectedMax) {

            assertAll(
                ()->assertEquals(expectedMin, calculator.min(a,b)),
                ()->assertEquals(expectedMax, calculator.max(a,b))
            );
        }


        static Stream<Arguments> provideMinMaxTestCases(){
            return Stream.of(
                Arguments.of(1,5,1,5),
                Arguments.of(5,1,1,5),
                Arguments.of(-5,5,-5,5),
                Arguments.of(8,0,8,0),
                Arguments.of(-10,-5,-10,-5)
            )
        }

    }



            // first, define an enum for testing
        enum Operation{
            ADD, SUBTRACT, MULTIPLY
        }

        
        @Nested
        @DisplayName("@EnumSource Examples")
        class EnumSourceExamples{

            @ParameterizedTest
            @EnumSource(Operation.class)
            @DisplayName("All Operations Should Be Valid")
            void operation_allValues_valid(Operation op){
                assertNotNull(op);
                assertNotNull(op.name());
            }
            
        }





        @Nested
        @DisplayName("Exception Testing Demo")
        class Exceptions{

            // assertThrows is the primary tool - returns the exception for inspection
            // Always Verify Exception Type
            // Verify Exception MESSAGE When It Contains Useful Info
            // assertDoesNotThrow explicitly documents "this should NOT thorw"

            Calculator calculator = new Calculator();


            @Test
            @DisplayName("Division by zero throws ArithmeticException")
            void divide_byZero_throwsArithmeticException(){
                // Basic Usage - Just Verify The Exception Type

                assertThrows(ArithmeticException.class), ()->{
                    calculator.divide(10,0);
                }
            }


            @Test
            @DisplayName("Capture exception and verify message")
            void divide_byZero_exceptionHasCorrectMessage(){
                ArithmeticException exception = assertThrows(
                    ArithmeticException.class,
                    ()->calculator.divide(10, 0)
                );

                // Now verify the messgae
                // assertEquals("Cannot Divide By Zero" exception.getMessage());

                // Case-Sensitive Tests (.toLowerCase --> Eliminates Case Sensitivity)
                assertEquals("Cannot Divide By Zero" exception.getMessage.toLowerCase());

            }


            @Test
            @DisplayName("Valid Division does not throw exception")
            void divide_validInputs_noException(){
                // Explicityly verify no exception is thrown
                assertDoesNotThrow()->{
                    calculator.divide(10,2);
                }
            }
        }

        

}
