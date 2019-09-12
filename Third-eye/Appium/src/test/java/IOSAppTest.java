import com.ThirdEye.Screens.AndroidApp;
import com.ThirdEye.Utilities.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IOSAppTest
{

    public AppiumDriver<MobileElement> driver;
    public AndroidApp app;
/*
    @BeforeMethod
    public void setUpApp()
    {
        driver= Utility.launchAppiOS("http://0.0.0.0:4723/wd/hub");
        app = new AndroidApp(driver);
    }*/

    @Test(description = "Verify invalid Password", priority = 1)
    public void verifyInvalidPasswordMessage()
    {
       /* app.enterUserName("quintype");
        app.enterPassword("quintypePasswor");
        app.clickOnLogin();
        Assert.assertEquals("Password is incorrect",app.getPassWordValidationElement().getText());
        System.out.println("Started");

*/
        driver= Utility.launchAppiOS("http://0.0.0.0:4723/wd/hub");
        System.out.println("Hi");
    }

    @Test(description = "Verify valid login", priority = 2)
    public void verifyValidLogin(){
      /*  app.enterUserName("quintype");
        app.enterPassword("quintypePassword");
        app.clickOnLogin();*/


    }


}
