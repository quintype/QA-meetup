import com.ThirdEye.Pages.SampleApp;
import com.ThirdEye.Utilities.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleAppTest
{
    public AppiumDriver<MobileElement> driver;
    public SampleApp app;

    @BeforeMethod
    public void setUpApp()
    {
        driver= Utility.launchApp("http://0.0.0.0:4723/wd/hub");
        app = new SampleApp(driver);
    }

    @Test(description = "Verify invalid Password", priority = 1)
    public void verifyInvalidPasswordMessage()
    {
        app.enterUserName("quintype");
        app.enterPassword("quintypePasswor");
        app.clickOnLogin();
        Assert.assertEquals("Password is incorrect",app.getPassWordValidationElement().getText());

    }

    @Test(description = "Verify valid login", priority = 2)
    public void verifyValidLogin(){
        app.enterUserName("quintype");
        app.enterPassword("quintypePassword");
        app.clickOnLogin();
    }

}
