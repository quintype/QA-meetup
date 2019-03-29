package com.Thirdeye.utils;


import com.jayway.restassured.RestAssured;
import com.Thirdeye.config.*;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class SetUp
{
	@SuppressWarnings("unused")
    public static String basicAuth;
    public static ConfigFile configObject = null;
	public static ConfigFile getConfigObject()
    {
    	return configObject;
    }

  @BeforeSuite
	public static void setup()
	{
        System.out.println("Property files loaded: ");
        configObject = new ConfigFile();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        //RestAssured.filters(ErrorLoggingFilter.errorLogger());
	}
	
	@AfterSuite
	public static void executionCompleted()
	{
		Reporter.log("Execution of the API Suite Completed", true);
	}
}
