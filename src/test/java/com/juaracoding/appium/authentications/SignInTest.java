package com.juaracoding.appium.authentications;

import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.juaracoding.appium.DriverSingleton;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SignInTest {
AndroidDriver driver;

@BeforeClass
public void setup() throws MalformedURLException {
    driver = DriverSingleton.createOrGetDriver();

}

@Test
public void signInShouldBeSuccess() throws InterruptedException {
    WebElement usernameField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
    usernameField.sendKeys("standard_user");
    WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
    passwordField.sendKeys("secret_sauce");
    WebElement loginButton = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
    loginButton.click();
    Thread.sleep(2000);
}
}
