package by.epam.framework.page;
import by.epam.framework.test.CommonConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement chooseSearchLink;

    public CloudGoogleSearchPage(WebDriver driver) {
        super(driver);
    }
    public CloudGooglePlatformPricingCalculatorPage chooseSearchResult(){

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(chooseSearchLink));
        chooseSearchLink.click();
        logger.info("Search results received");
        return new CloudGooglePlatformPricingCalculatorPage(driver);
    }
}
