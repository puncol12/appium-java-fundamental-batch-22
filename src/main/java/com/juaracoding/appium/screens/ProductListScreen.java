package com.juaracoding.appium.screens;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductListScreen {
  private AndroidDriver driver;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
  private List<WebElement> cartButtons;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
  private WebElement title;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"][1]")
  private WebElement cartButton1;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
  private WebElement cartCount;

  @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]")
  private WebElement scrollView;

  public ProductListScreen(AndroidDriver androidDriver) {
    driver = androidDriver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  public String getTitle() {
    return title.getText();
  }

  public String getCartCount() {
    return cartCount.getText();
  }

  public void addToCartProduct1() {
    cartButton1.click();
  }

  public void scroll() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("elementId", scrollView);
    params.put("direction", "down");
    params.put("percent", 1);
    params.put("speed", 1000);

    js.executeScript("mobile: scrollGesture", params);
  }

  public void addToCartProducts() throws InterruptedException {
    for (WebElement cartButton : cartButtons) {
      cartButton.click();
      Thread.sleep(1000);
    }
  }

  public void addToCartAndScroll(int limit) throws InterruptedException {
    for (int i = 1; i <= limit; i++) {
      addToCartProducts();
      Thread.sleep(1000);
      scroll();
      Thread.sleep(1000);
    }
  }
}
