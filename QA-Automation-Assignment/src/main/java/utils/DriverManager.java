package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.logging.Logger;

public class DriverManager {
    private static final Logger logger = Logger.getLogger(DriverManager.class.getName());
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public static void setDriver(String browserName) {
        logger.info("Setting up WebDriver for browser: " + browserName);
        
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        driver.set(new ChromeDriver(chromeOptions));
        
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        
        logger.info("WebDriver setup completed successfully");
    }
    
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public static void quitDriver() {
        if (driver.get() != null) {
            logger.info("Closing WebDriver");
            driver.get().quit();
            driver.remove();
        }
    }
} 