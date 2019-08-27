package com.ThirdEye.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Utility {
   static AppiumDriver<MobileElement> driver;
   static DesiredCapabilities capabilities;
    static URL appiumHost;


    public static AppiumDriver launchApp(String appiumHostUrl){
        try{  appiumHost = new URL(appiumHostUrl); }
        catch(Exception exception){}
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver= new AppiumDriver<MobileElement>(appiumHost,capabilities);
        return  driver;

    }
}
