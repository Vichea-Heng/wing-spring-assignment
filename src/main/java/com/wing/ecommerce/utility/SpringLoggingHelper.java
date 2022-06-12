package com.wing.ecommerce.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLoggingHelper {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    public void helperMethod(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
    }
}
