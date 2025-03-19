package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private WebDriver driver;

    private By successMessage = By.className("complete-header");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccessful() {
        return driver.findElement(successMessage).getText().equals("Thank you for your order!");
    }
}
