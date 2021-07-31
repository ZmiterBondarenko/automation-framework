package by.epam.framework.test;

import by.epam.framework.utils.TestListener;
import org.openqa.selenium.WebDriver;
import  by.epam.framework.driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;



@Listeners({TestListener.class})
public class CommonConditions {
    protected static WebDriver driver;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
