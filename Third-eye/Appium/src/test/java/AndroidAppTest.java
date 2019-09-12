import com.ThirdEye.Screens.AndroidApp;
import com.ThirdEye.Utilities.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class AndroidAppTest
{
    public AppiumDriver<MobileElement> driver;
    public AndroidApp app;

    String username= Utility.getInfo("creds","username");
    String validPassword= Utility.getInfo("creds","password");
    String invalidPassword=Utility.getInfo("creds","invalidPassword");

    @BeforeClass
    public void setUpApp()
    {
        driver= Utility.launchApp("http://0.0.0.0:4723/wd/hub");
        app = new AndroidApp(driver);
    }

    @Test(description = "Verify invalid Password", priority = 1)
    public void verifyInvalidPasswordMessage()
    {
        app.enterUserName(username);
        app.enterPassword(invalidPassword);
        app.clickOnLogin();
        Assert.assertEquals("Password is incorrect",app.getPassWordValidationElement().getText());
    }

    @Test(description = "Verify valid login", priority = 2)
    public void verifyValidLogin(){
        app.clearPassword();
        app.enterPassword(validPassword);
        app.clickOnLogin();
        Assert.assertEquals("WELCOME",app.getWelcomTextElement().getText());
    }



}
