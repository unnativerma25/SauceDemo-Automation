package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.HomePage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(priority = 2)
    public void testSortDropdown() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.selectSortingOption("Price (low to high)");  // 🔹 Selecting sorting option


    }
    @Test(priority = 3)
    public void testAddProductToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(wait);
        homePage.goToCart(wait);
    }
}