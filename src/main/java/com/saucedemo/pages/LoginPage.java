package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By inventoryContainer = By.id("inventory_container");
    private By errorMessage = By.xpath("//h3[@data-test='error']"); //  Error message locator

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Assertion for successful login
    public void verifySuccessfulLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
        Assert.assertTrue(driver.findElement(inventoryContainer).isDisplayed(), "❌ Login failed!");
    }

    //  Assertion for invalid login
    public void verifyInvalidLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actualError = driver.findElement(errorMessage).getText();
        Assert.assertTrue(actualError.contains("Epic sadface"), "❌ Expected error message not found!");
    }
}
