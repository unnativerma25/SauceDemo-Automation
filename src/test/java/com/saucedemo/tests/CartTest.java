package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(priority = 3)
    public void testCartAndProceedToCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout(wait);
    }
}
