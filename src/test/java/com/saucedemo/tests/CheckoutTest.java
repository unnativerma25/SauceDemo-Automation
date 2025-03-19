package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test(priority = 5)
    public void testCheckoutProcess() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("John", "Doe", "12345", wait);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkoutPage.completeCheckout(wait);
    }
}
