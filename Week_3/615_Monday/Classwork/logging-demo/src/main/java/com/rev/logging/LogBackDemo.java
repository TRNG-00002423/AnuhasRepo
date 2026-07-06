package com.rev.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackDemo {

    // 1. Get A Logger
    private static final Logger logger = LoggerFactory.getLogger(LogBackDemo.class);
        
    public static void main(String[] args) {
        
        // 2. Log A Simple Message
        logger.info("Application started ...");

        try{
            int result = 100/0;
        } catch(ArithmeticException e) {
            logger.error("An Arithmetic Exception Occured"+e);
        } finally {
            logger.info("Exception handled ...");
        }
        logger.trace("Extremely Detailed Info -- Severity -- Low");
        logger.debug("Debugging Details -- Severity -- Lowest");
        logger.info("Application Exited ...  -- Severity -- Medium");
        logger.warn("warning Messages ...  -- High");
        logger.error("Error Message ... -- HIGHEST");
            

    }
}