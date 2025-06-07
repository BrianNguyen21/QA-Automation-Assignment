package base;

import org.testng.annotations.*;
import utils.DriverManager;
import utils.LoggerUtil;

public class BaseTest {
    
    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        LoggerUtil.info("Starting test setup with browser: " + browser);
        DriverManager.setDriver(browser);
        LoggerUtil.info("Test setup completed successfully");
    }
    
    @AfterMethod
    public void tearDown() {
        LoggerUtil.info("Starting test teardown");
        DriverManager.quitDriver();
        LoggerUtil.info("Test teardown completed");
    }
    
    @AfterSuite
    public void suiteTearDown() {
        LoggerUtil.info("Test suite execution completed");
        LoggerUtil.closeHandlers();
    }
} 