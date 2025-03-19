package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By firstProduct = By.cssSelector(".inventory_item button");
    private By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(firstProduct).click();
    }

    public boolean isProductAdded() {
        return driver.findElement(cartIcon).getText().equals("1");
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(cartIcon).isDisplayed();
    }
}
