package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Retry twice

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            LoggerUtil.info("Retrying test: " + result.getMethod().getMethodName() +
                    " - Attempt " + (retryCount + 1) + " of " + (maxRetryCount + 1));
            return true;
        }
        return false;
    }
}