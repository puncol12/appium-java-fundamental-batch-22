package com.juaracoding.appium.screens;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {

    private AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginButton;

    public LoginScreen(AndroidDriver androidDriver) {
        driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

}
