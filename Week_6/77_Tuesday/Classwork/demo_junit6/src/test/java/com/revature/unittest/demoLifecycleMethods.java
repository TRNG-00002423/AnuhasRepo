package com.revature.unittest;


import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Junit6 Test Lifecycle Methods Demo")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class demoLifecycleMethods {

    // shared across test (set in @BeforeAll)
    private static String sharedResource;
    private static int testCounter;

    // Fresh for each test (set in @BeforeEach)
    private Calculator calculator;
    private StringBuilder testLog;

    // @BeforeAll - One-time class setup

    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll - One-time class setup - Setting up test class ONLY ONCE");
        
        // simulate expensive setup
        sharedResource = "Database Connection";
        testCounter = 0;

        // You Could :
        // 1. Start A Mock Server
        // 2. Open/ Initialize a Database Connection Pool
        // 3. Load Configuration Files / Large Test Data File
        // 4. Initialize Expensive/Heavy Resources

    }


    @BeforeEach
    void setUp(TestInfo testInfo) {
        testCounter++;
        System.out.println("@BeforeEach : Preparing test # "+ testCounter);

        // Create fresh instances for each test
        calculator = new Calculator();
        testLog = new StringBuilder();
        testLog.append("Test Started |");

        // This Is Where You Would :
        // 1. Create Fresh Object Instances
        // 2. Reset Mocks
        // 3. Prepare Test-Specific Data
        // 4. Start A Transaction
    }


    @Test
    @Order(1)
    @DisplayName("First Test")
    void testOne(){
        System.out.println("Running Test One...");
        testLog.append("Test One Executed");
        assertEquals(5, calculator.sum(2,3));
        assertNotNull(sharedResource);
    }

    @Test
    // @Order(3)
    @Order(2)
    @DisplayName("Second test - Calculator Is Fresh Again")
    void testTwo(){
        System.err.println("Running Test Two ...");
        testLog.append("Test Two Executed");

        // Even if test one modified calculator, we get a fresh one
        assertEquals(8, calculator.sum(5,3));
    }


    @Test
    // @Order(2)
    @Order(3)
    @DisplayName("Third test - Demonstrates Isolation")
    void testThree(){
        System.out.print("Running Test Three ...");
        testLog.append("Test Three Executed");

        // This Test is Completely Independent
        assertEquals(6, calculator.multiply(2,3));

        // testLog is fresh - doesn't have entries from previous tests
        assertTrue(testLog.toString().contains("Test Three"));
        assertFalse(testLog.toString().contains("Test One"));
    }

    //@AfterEach - pre-test cleanup
    void tearDown(TestInfo testinfo) {
        System.out.println("@AfterEach: cleaning up after : " + testinfo.getDisplayName());

        // Log Final State
        testLog.append("  |  Test Completed");
        System.out.println("Log : "+testLog.toString());

        // Clean Up Pre-Test Resources
        calculator = null;
        testLog = null;

        // Roll Back Transactions
        // Delete Test Data
        // Close File Handlers
        // Reset Any Modified State
    }

    // AfterAll
    @AfterAll
    static void tearDownClass(){
        System.out.println("@AfterAll : cleaning up test class ONCE");
        System.out.println("Total Tests Run : "+testCounter);

        // Release Shared Resources
        sharedResource = null;

        // This is where you would :
        // Stop Mock Servers
        // Close Database Connections
        // Clean Up Temp Files
        // Release Expensive Resources

    }

}
