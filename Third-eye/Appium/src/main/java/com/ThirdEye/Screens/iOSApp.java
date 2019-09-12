package com.ThirdEye.Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iOSApp {

    public AppiumDriver<MobileElement> driver;
    String userNameField = "";
    String passwordField = "";
    String invalidEmailElement = "";
    String invalidPasswordElement = "";
    String loginButton = "";
    WebDriverWait wait;


    public iOSApp(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
    }
    public void enterUserName(String userName){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(userNameField)));
        driver.findElement(By.id(userNameField)).sendKeys(userName);

    }
    public void enterPassword(String password){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(passwordField)));
        driver.findElement(By.id(passwordField)).sendKeys(password);
    }

    public void clickOnLogin()
    {
        driver.findElement(By.id(loginButton)).click();
    }

    public MobileElement  getPassWordValidationElement(){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(invalidPasswordElement)));
        return driver.findElement(By.id(invalidPasswordElement));

    }
}
