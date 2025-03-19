package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By inventoryContainer = By.id("inventory_container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password, WebDriverWait wait) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
        Assert.assertTrue(driver.findElement(inventoryContainer).isDisplayed(), "Login Failed!");
    }
}
