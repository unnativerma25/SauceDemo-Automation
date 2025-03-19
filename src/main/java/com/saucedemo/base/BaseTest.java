package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver;  //  Use static driver for the same session
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setup() throws InterruptedException {
        if (driver == null) {  //  Ensures driver is initialized only once
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(1000);
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
            driver = null;  //  Reset driver after all tests are done
        }
    }
}
