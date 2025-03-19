package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.tests.LoginTest;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(priority = 2, dependsOnMethods = "com.saucedemo.tests.LoginTest.testLogin")
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(driver);

        homePage.addProductToCart();
        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(), "Product not found in Cart!");
    }
}
