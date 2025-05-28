package com.juaracoding.appium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  private static Properties props = new Properties();

  public static void loadProperties(String filePath) {
    try (FileInputStream fis = new FileInputStream(filePath)) {
      props.load(fis);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load config: " + filePath, e);
    }
  }

  public static String get(String key) {
    return props.getProperty(key);
  }
}
