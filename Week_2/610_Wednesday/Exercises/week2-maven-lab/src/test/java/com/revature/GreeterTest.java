package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GreeterTest {

    @Test
    void testHappyPath() {

        Greeter greeter = new Greeter();

        String expectedResult="Hello Anuha";

        String actualResult = greeter.hello("Anuha");

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void testExceptionForBlank() {

        Greeter greeter = new Greeter();

        String expectedResult="The input cannot be left blank !";


        String actualResult = "";

        boolean throwsAnException = false;

        try {
            actualResult = greeter.hello("");
        } catch (IllegalArgumentException e) {
            throwsAnException = true;
        }
        

        Assertions.assertTrue(throwsAnException);

    }

}
