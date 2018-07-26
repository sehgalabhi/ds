package com.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

    private Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);

    public static void main(String[] args) {
        new TestLogger().test();
    }

    private void test() {
        LOGGER.info("Hello World {} {}", 1, 2);
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);

        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
        logger.setLevel(Level.INFO);

        logger.warn("low value");
        logger.debug("low value");


    }
}
