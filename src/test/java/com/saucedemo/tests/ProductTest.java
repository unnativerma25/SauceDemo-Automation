package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.HomePage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(priority = 2)
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(wait);
        homePage.goToCart(wait);
    }
}
