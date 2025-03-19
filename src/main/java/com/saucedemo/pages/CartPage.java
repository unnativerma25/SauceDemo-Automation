package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;
    private By checkoutButton = By.id("checkout");
    private By cartItem = By.className("cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout(WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(cartItem).isDisplayed(), "No item found in cart!");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
