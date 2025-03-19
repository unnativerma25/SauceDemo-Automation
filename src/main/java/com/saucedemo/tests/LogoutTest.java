package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test(priority = 5, dependsOnMethods = "com.saucedemo.tests.CheckoutTest.testCheckoutProcess")
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Logout Failed!");
    }
}
