package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    private final WebDriverWait wait;
    private WebDriver driver;
    private By productAddToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.id("shopping_cart_container");
    private By dropdownSort = By.className("product_sort_container"); // Dropdown for sorting products




    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
    }


    public void selectSortingOption(String optionText) throws InterruptedException {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSort));
        Select select = new Select(dropdown);

        // Check if the dropdown is already selected
        String selectedOption = select.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        if (!selectedOption.equals(optionText)) {
            select.selectByVisibleText(optionText);
            System.out.println("✅ Selected option: " + optionText);
        } else {
            System.out.println("ℹ️ Option already selected: " + selectedOption);
        }
    }



    public void addProductToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCart)).click();
        String cartCount = driver.findElement(cartIcon).getText();
        Assert.assertEquals(cartCount, "1", "Product not added to cart!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}