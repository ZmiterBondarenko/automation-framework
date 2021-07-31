package by.epam.framework.page;

import by.epam.framework.utils.CustomConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutEmailPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";
    private final Logger logger = LogManager.getRootLogger();

    private final By generatedEmailFieldLocator = By.xpath("//input[@id='mail_address']");

    @FindBy(xpath = "//div[@class='small_sender']")
    private WebElement incomingMail;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    private WebElement totalEstimatedCostFromEmail;

    public TenMinutEmailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinutEmailPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        logger.info("Ten Minute Email page opened");
        return this;
    }

    public String copyMailAddress() {
        WebElement generatedEmailField = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                                .until(ExpectedConditions.presenceOfElementLocated(generatedEmailFieldLocator));
        logger.info("Ten Minute email coped");
        return generatedEmailField.getAttribute("value");
    }

    public TenMinutEmailPage openMail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(incomingMail));
        incomingMail.click();
        return this;
    }

    public double getTotalEstimatedMonthlyCostFromEmail() {
        logger.info("Total estimated monthly cost received");
        return Double.parseDouble(totalEstimatedCostFromEmail.getText()
                .substring(3)
                .replaceAll(",", ""));
    }
}
