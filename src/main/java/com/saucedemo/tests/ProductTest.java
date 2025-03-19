package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(priority = 2)
    public void addProductToCartTest() {
        HomePage homePage = new HomePage(driver);  // Same driver reuse hoga
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in!"); // Ensure user is logged in

        homePage.addProductToCart();

        Assert.assertTrue(homePage.isProductAdded(), "Product was not added to cart!");
    }
}
