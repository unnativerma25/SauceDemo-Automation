package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private By productAddToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.id("shopping_cart_container");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCart)).click();
        String cartCount = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartCount, "1", "Product not added to cart!");
    }

    public void goToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
