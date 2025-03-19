package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test(priority = 5)
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout(wait);
    }
}
