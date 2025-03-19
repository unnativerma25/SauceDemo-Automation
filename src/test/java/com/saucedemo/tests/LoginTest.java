package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce", wait);
    }
}
