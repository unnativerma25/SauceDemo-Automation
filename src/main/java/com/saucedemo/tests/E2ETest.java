//package com.saucedemo.tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class E2ETest {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @BeforeClass
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
//    }
//
//    @Test(priority = 1)
//    public void loginTest() throws InterruptedException {
//        WebElement username = driver.findElement(By.id("user-name"));
//        WebElement password = driver.findElement(By.id("password"));
//        WebElement loginButton = driver.findElement(By.id("login-button"));
//
//        username.sendKeys("standard_user");
//        password.sendKeys("secret_sauce");
//        loginButton.click();
//
//        // Wait for products page to load
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement productsTitle = driver.findElement(By.className("title"));
//        Assert.assertEquals(productsTitle.getText(), "Products");
//    }
//
//    @Test(priority = 2)
//    public void addToCartTest() throws InterruptedException {
//        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
//        addToCartButton.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
//        Assert.assertEquals(cartBadge.getText(), "1");
//    }
//
//    @Test(priority = 3)
//    public void goToCartAndVerifyTest() throws InterruptedException {
//        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
//        cartIcon.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sauce Labs Backpack']")));
//        Assert.assertTrue(cartItem.isDisplayed(), "Product is not in cart");
//    }
//
//    @Test(priority = 4)
//    public void checkoutTest() throws InterruptedException {
//        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
//        checkoutButton.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement firstName = driver.findElement(By.id("first-name"));
//        WebElement lastName = driver.findElement(By.id("last-name"));
//        WebElement postalCode = driver.findElement(By.id("postal-code"));
//        WebElement continueButton = driver.findElement(By.id("continue"));
//
//        firstName.sendKeys("Unnati");
//        lastName.sendKeys("Verma");
//        postalCode.sendKeys("123456");
//        continueButton.click();
//    }
//
//    @Test(priority = 5)
//    public void finishOrderTest() throws InterruptedException {
//        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
//        finishButton.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
//        Assert.assertEquals(confirmationMessage.getText(), "Thank you for your order!");
//    }
//
//    @Test(priority = 6)
//    public void logoutTest() throws InterruptedException {
//        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
//        menuButton.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
//        logoutButton.click();
//
//        Thread.sleep(2000);  // 2 seconds pause
//
//        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
//        Assert.assertTrue(loginButton.isDisplayed(), "Logout was not successful");
//    }
//
//    @AfterClass
//    public void teardown() {
//        driver.quit();
//    }
//}
