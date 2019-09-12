package com.ThirdEye.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class Utility {
   static AppiumDriver<MobileElement> driver;
   static DesiredCapabilities capabilities;
    static URL appiumHost;


    public static AppiumDriver launchApp(String appiumHostUrl){
        try{  appiumHost = new URL(appiumHostUrl); }
        catch(Exception exception){exception.printStackTrace();}
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.example.qameetup");
        capabilities.setCapability("appActivity","com.example.qameetup.MainActivity");
        capabilities.setCapability("appActivity","com.example.qameetup.LoginActivity");
        capabilities.setCapability("appActivity","com.example.qameetup.SplashActivity");
        driver= new AppiumDriver<MobileElement>(appiumHost,capabilities);
        return  driver;

    }


    public static AppiumDriver launchAppiOS(String appiumHostUrl){
        try{  appiumHost = new URL(appiumHostUrl); }
        catch(Exception exception){exception.printStackTrace();}
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("platformVersion","12.2");
        capabilities.setCapability("deviceName","iPhone XR");
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"safari");
        /*capabilities.setCapability("udid","1B554923-D451-4900-A82F-A1E29CD424A7");*/

       /* driver= new AppiumDriver<MobileElement>(appiumHost,capabilities);*/
        driver = new IOSDriver<MobileElement>(appiumHost,capabilities);
        return  driver;

    }

    public static String getInfo(String fileName, String Key){
        String value = null;
        Properties prop = new Properties();
       try
       {
           FileInputStream file = new FileInputStream("./src/main/resources/"+fileName+".properties");
           prop.load(file);
           value = prop.getProperty(Key);
           return value;
       }
       catch (Exception e){e.printStackTrace(); return value;}

    }

    public static void main(String[] args) {
        System.out.println(getInfo("creds","username"));
    }
}
