package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(priority = 4)
    public void testCartAndProceedToCheckout() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout(wait);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
