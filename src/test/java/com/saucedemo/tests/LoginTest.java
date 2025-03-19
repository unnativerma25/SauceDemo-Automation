package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.verifySuccessfulLogin(); // ✅ Assert successful login
        System.out.println("✅ Valid login test passed!");
    }

    @Test(priority = 1)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");
        loginPage.verifyInvalidLogin(); // ❌ Assert invalid login
        System.out.println("✅ Invalid login test passed!");

    }
}
