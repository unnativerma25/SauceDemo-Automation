package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By checkoutButton = By.id("checkout");
    private By cartItem = By.className("cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
