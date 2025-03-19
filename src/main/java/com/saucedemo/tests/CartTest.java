package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(priority = 3)
    public void verifyCartItems() {
        CartPage cartPage = new CartPage(driver); // Same session me run hoga
        cartPage.isProductInCart();
        Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart is empty after adding products!");
    }
}
