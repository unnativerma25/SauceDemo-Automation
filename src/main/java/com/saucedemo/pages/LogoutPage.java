package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutPage {
    private WebDriver driver;
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Logout failed!");
    }
}
