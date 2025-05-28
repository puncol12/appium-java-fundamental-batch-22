package com.juaracoding.appium.listeners;

import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.time.Duration;
// import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import com.juaracoding.appium.AndroidDeviceManager;
import com.juaracoding.appium.DriverSingleton;
import com.juaracoding.appium.utils.MailSender;
import io.appium.java_client.android.AndroidDriver;

// import com.juaracoding.test.DriverSingleton;

public class Hook implements IExecutionListener {
    public static AndroidDriver driver;

  @Override
  public void onExecutionStart() {
    System.err.println("TestNG is commencing execution");
    try {
     driver = DriverSingleton.createOrGetDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
     driver.hideKeyboard();   
    } catch (MalformedURLException e) {
       
        e.printStackTrace();
    }
    
  }

    @Override
    public void onExecutionFinish() {
        System.err.println("TestNG is finished execution");
        DriverSingleton.quitDriver();
        MailSender.send();
    }
}
