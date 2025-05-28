/*
 * Test appium pertama 1111
 */
package com.juaracoding.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppTest {
        AndroidDriver driver;
        DesiredCapabilities capabilities;

        @BeforeTest
        public void setup() throws MalformedURLException {

                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:deviceName", "emulator-5554");
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:appPackage", "com.google.android.calculator");
                capabilities.setCapability("appium:appActivity",
                                "com.android.calculator2.Calculator");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.hideKeyboard();
        }

        @Test
        public void additionTest() throws InterruptedException {
                WebElement buttonClear = driver
                                .findElement(AppiumBy.id("com.google.android.calculator:id/clr"));
                WebElement button9 = driver.findElement(
                                AppiumBy.id("com.google.android.calculator:id/digit_9"));
                WebElement button5 = driver.findElement(
                                AppiumBy.id("com.google.android.calculator:id/digit_5"));
                WebElement buttonPlus = driver.findElement(
                                AppiumBy.id("com.google.android.calculator:id/op_add"));
                WebElement buttonEqual = driver
                                .findElement(AppiumBy.id("com.google.android.calculator:id/eq"));


                Thread.sleep(2000);
                buttonClear.click();
                Thread.sleep(2000);
                button9.click();
                Thread.sleep(2000);
                buttonPlus.click();
                Thread.sleep(2000);
                button5.click();
                Thread.sleep(2000);
                buttonEqual.click();
                Thread.sleep(2000);

                WebElement resultView = driver.findElement(
                                AppiumBy.id("com.google.android.calculator:id/result_final"));
                String expected = "14";
                String actual = resultView.getText();
                Assert.assertEquals(actual, expected);
                Reporter.log(actual);
        }
}

