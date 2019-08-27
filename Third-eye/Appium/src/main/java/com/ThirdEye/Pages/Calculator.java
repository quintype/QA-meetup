package com.ThirdEye.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calculator {
    public AppiumDriver<MobileElement> driver;
    public String idOfDigit_8 = "com.android.calculator2:id/digit_8";
    public String idOfDigit_6 = "com.android.calculator2:id/digit_6";
    public String multiply = "com.android.calculator2:id/op_mul";
    public String equals = "com.android.calculator2:id/eq";
    public String result = "com.android.calculator2:id/result";
    public String numberPad = "com.android.calculator2:id/pad_numeric";
    public String add = "com.android.calculator2:id/op_add";

    public Calculator(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
    }

    public void waitForAllNumbersToLoad()
    {
        WebDriverWait wait =  new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(numberPad)));
    }

    public void clickOnNumber8()
    {

        driver.findElement(By.id(idOfDigit_8)).click();
    }
    public void clickOnNumber6()
    {
        driver.findElement(By.id(idOfDigit_6)).click();
    }
    public void clickOnMultiply(){
        driver.findElement(By.id(multiply)).click();
    }
    public void clickOnAdd(){
        driver.findElement(By.id(add)).click();
    }
    public void clickEquals(){
        driver.findElement(By.id(equals)).click();
    }
    public String getResult(){
        return driver.findElement(By.id(result)).getText();
    }
}
