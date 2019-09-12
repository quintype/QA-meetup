package com.ThirdEye.Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidApp {
    public AppiumDriver<MobileElement> driver;
    String userNameField = "com.example.qameetup:id/activity_login_tet_username";
    String passwordField = "com.example.qameetup:id/activity_login_tet_password";
    String invalidPasswordElement = "com.example.qameetup:id/textinput_error";
    String loginButton = "com.example.qameetup:id/activity_login_cv_login";
    String welcomeTextElementClass = "android.widget.TextView";
    WebDriverWait wait;

    public AndroidApp(AppiumDriver<MobileElement> driver)
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

    public void clearPassword(){
        driver.findElement(By.id(passwordField)).clear();
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

    public MobileElement getWelcomTextElement(){
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(welcomeTextElementClass)));
        return driver.findElement(By.className(welcomeTextElementClass));
    }




}
