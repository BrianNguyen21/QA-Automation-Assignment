# QA Automation Framework - Best Buy Add to Cart Workflow

## Project Setup and Execution Steps

### Prerequisites
- **Java JDK 11+**
- **Chrome Browser** (ChromeDriver managed automatically)
- **Internet Connection**

### Quick Start
```bash
# Navigate to project directory
cd QA-Automation-Assignment

# Run all tests
gradle test

# Run specific test class
gradle test --tests tests.AddToCartWorkflowTest

# Build project
gradle build
```

### Test Execution Options
```bash
# Run with specific browser (default: Chrome)
gradle test -Dbrowser=chrome

# Run add to cart workflow
gradle test --tests tests.AddToCartWorkflowTest
```


### Main Test: `verifyAddToCartWorkflow(String productName, int quantity)`

**Test Data:**
- **Laptop** (quantity: 2)
- **Tablet** (quantity: 3)

## Environment/Configuration Requirements

### Framework Stack
```
Selenium WebDriver 4.11.0
TestNG 7.8.0  
WebDriverManager 5.4.1
Java 17
Gradle 7.5
Chrome Browser
```

### Project Structure
```
Split SRC file into Main Java for the pages and test for testing the java files 
```

### Configuration Details

**Browser Settings:**
- Chrome with automation detection disabled
- Window maximized
- Fast loading optimizations

**Timeouts:**
- Implicit wait: 5 seconds
- Page load: 15 seconds  
- Element interactions: 200-500ms

**Logging:**
- Java logging utilities (java.util.logging)
- INFO level for test execution tracking
- Console output with test progress

**Retry Configuration:**
- Maximum retries: 2 per test
- Applied to: AddToCartWorkflowTest methods
- Retry on: Any test failure

### Dependencies (build.gradle)
```gradle
dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.11.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.4.1'
    testImplementation 'org.testng:testng:7.8.0'
}
```

### TestNG Configuration (testng.xml)
```xml
<suite name="BestBuyAutomationSuite" parallel="false">
    <test name="AddToCartWorkflowTests">
        <classes>
            <class name="tests.AddToCartWorkflowTest"/>
        </classes>
    </test>
</suite>
```
