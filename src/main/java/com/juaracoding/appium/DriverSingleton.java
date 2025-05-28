package com.juaracoding.appium;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

public class DriverSingleton {
  public static AndroidDriver driver;

  public static AndroidDriver createOrGetDriver() throws MalformedURLException {
    if (driver == null) {
      driver = AndroidDeviceManager.build();
    }

    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
