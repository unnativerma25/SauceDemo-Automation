package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test(priority = 4, dependsOnMethods = "com.saucedemo.tests.CartTest.testCartFunctionality")
    public void testCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterDetails("Unnati", "Verma", "123456");
        checkoutPage.completeOrder();

        OrderConfirmationPage confirmationPage = new OrderConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.isOrderSuccessful(), "Order Not Successful!");
    }
}
