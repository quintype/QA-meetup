import com.ThirdEye.Pages.Calculator;
import com.ThirdEye.Utilities.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest
{
    public AppiumDriver<MobileElement> driver;
    public Calculator calculator;

    @BeforeMethod
    public void setUpApp()
    {
        driver= Utility.launchApp("http://0.0.0.0:4723/wd/hub");
        calculator = new Calculator(driver);
        calculator.waitForAllNumbersToLoad();
    }

    @Test(description = "This test is verify multiplication of 8,6")
    public void multiplyTwoNumbers()
    {
        calculator.clickOnNumber8();
        calculator.clickOnMultiply();
        calculator.clickOnNumber6();
        calculator.clickEquals();
        Assert.assertEquals("48",calculator.getResult());
    }

    @Test(description = "This test is verify addition of 8,6")
    public void addTwoNumbers()
    {
        calculator.clickOnNumber6();
        calculator.clickOnAdd();
        calculator.clickOnNumber8();
        calculator.clickEquals();
        Assert.assertEquals("14",calculator.getResult());
    }

}
