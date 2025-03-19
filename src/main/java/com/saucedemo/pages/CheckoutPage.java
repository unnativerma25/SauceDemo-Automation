package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage {
    private WebDriver driver;
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By successMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutDetails(String fName, String lName, String zip, WebDriverWait wait) throws InterruptedException {
        driver.findElement(firstName).sendKeys(fName);
        Thread.sleep(1000);
        driver.findElement(lastName).sendKeys(lName);
        Thread.sleep(1000);
        driver.findElement(postalCode).sendKeys(zip);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void completeCheckout(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "Checkout failed!");
    }
}
