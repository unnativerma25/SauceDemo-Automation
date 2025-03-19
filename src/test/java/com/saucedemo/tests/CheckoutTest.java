package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test(priority = 4)
    public void testCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("John", "Doe", "12345", wait);
        checkoutPage.completeCheckout(wait);
    }
}
