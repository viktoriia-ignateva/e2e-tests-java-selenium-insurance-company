package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggingListener extends TestListenerAdapter {
    private static final Logger logger = LogManager.getLogger(LoggingListener.class);

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.error("Test Failed: " + tr.getName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.warn("Test Skipped: " + tr.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("Test Passed: " + tr.getName());
    }
}
