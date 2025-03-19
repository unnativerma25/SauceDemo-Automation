package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver; // Single WebDriver instance

    @BeforeSuite  // Runs once before all tests
    public void setup() {
        if (driver == null) {  // Ensures only one instance of driver
//            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.saucedemo.com/");
        }
    }

    @AfterSuite  // Runs once after all tests
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
