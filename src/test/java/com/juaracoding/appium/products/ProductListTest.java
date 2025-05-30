package com.juaracoding.appium.products;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.juaracoding.appium.DriverSingleton;
import com.juaracoding.appium.screens.ProductListScreen;

import io.appium.java_client.android.AndroidDriver;

public class ProductListTest {
  AndroidDriver driver;
  ProductListScreen productListScreen;

  @BeforeClass
  public void setup() throws MalformedURLException {
    driver = DriverSingleton.createOrGetDriver();
    productListScreen = new ProductListScreen(driver);
  }

  @Test
  public void testStep01() throws InterruptedException {
    // productListScreen.addToCartProduct1();
    productListScreen.addToCartAndScroll(3);
  }

  @Test
  public void testStep02() throws InterruptedException {
    // String actual = productListScreen.getCartCount();
    // String expected = "1";
    // Assert.assertEquals(actual, expected);

  }
}
