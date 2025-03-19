package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(priority = 3, dependsOnMethods = "com.saucedemo.tests.ProductTest.testAddProductToCart")
    public void testCartFunctionality() {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout page not opened!");
    }
}
