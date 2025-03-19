package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.OrderConfirmationPage;
import org.testng.Assert;
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

    @Test(priority = 6, dependsOnMethods = "testCheckoutProcess")
    public void testOrderConfirmation() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertTrue(orderConfirmationPage.isOrderSuccessful(), "❌ Order was not placed successfully!");
        System.out.println("✅ Order placed successfully and confirmation verified!");
    }
}
