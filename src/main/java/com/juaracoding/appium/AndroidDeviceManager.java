package com.juaracoding.appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.juaracoding.appium.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

public class AndroidDeviceManager {
    static AndroidDriver driver;
    static DesiredCapabilities capabilities;

    public static AndroidDriver build() throws MalformedURLException {
        ConfigReader.loadProperties("config.properties");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", ConfigReader.get("appium.device.name"));
        capabilities.setCapability("appium:automationName",
                ConfigReader.get("appium.automationName"));
        capabilities.setCapability("appium:appPackage", ConfigReader.get("appium.appPackage"));
        capabilities.setCapability("appium:appActivity", ConfigReader.get("appium.appActivity"));

        return new AndroidDriver(
                new URL(ConfigReader.get("appium.host") + ":" + ConfigReader.get("appium.port")),
                capabilities);
    }
}
