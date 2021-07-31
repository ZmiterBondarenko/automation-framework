package by.epam.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGooglePlatformPricingCalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineSection;

    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement chooseOSAndSoftwareField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement selectOSAndSoftware;
    private String operatingSystemLocator = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement chooseMachineClassField;
    private String machineClassLocator = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement chooseMachineSeries;
    private String machineSeriesLocator = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement chooseMachineType;
    private String machineTypeLocator = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement chooseNumberOfGPUs;
    private String numberOfGPUsLocator = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement chooseTypeGPU;
    private String TypeGPULocator = "//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement chooseLocalSSDField;
    private String localSSDLocator = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement chooseDatacenterlocationField;
    private String datacenterLocationLocator = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement chooseCommitedUsageField;
    private String committedUsageLocator = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']";

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateBtn;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement mailAddressField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailBtn;

    @FindBy(xpath = "//b[contains(text(),'Estimated Component Cost') and @class='ng-binding']")
    private WebElement estimatedCost;

    CloudGooglePlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePlatformPricingCalculatorPage selectComputeEngineSection() {
        driver.switchTo().frame(0)
                .switchTo().frame("myFrame");
        computeEngineSection.click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage setNumberOfInstances(String numberOfInstance) {
        numberOfInstancesField.sendKeys(numberOfInstance);
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectOSAndSoftware(String osAndSoftware) {
        chooseOSAndSoftwareField.click();
        waitClickable(operatingSystemLocator,osAndSoftware).click();
        logger.info("Operating system selected");
        return this;

    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineClass(String machineClass) {
        chooseMachineClassField.click();
        waitClickable(machineClassLocator,machineClass).click();
        logger.info("Machine class selected");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineSeries(String machineSeries) {
        chooseMachineSeries.click();
        waitClickable(machineSeriesLocator,machineSeries).click();
        logger.info("Machine series selected");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineType(String machineType) {
        chooseMachineType.click();
        waitClickable(machineTypeLocator,machineType).click();
        logger.info("Machine type selected");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage setNumberOfGPUs(String numberOfGPUs) {
        addGPUsCheckbox.click();
        chooseNumberOfGPUs.click();
        waitClickable(numberOfGPUsLocator, numberOfGPUs).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage addGPUs(String gpuType) {
        chooseTypeGPU.click();
        waitClickable(TypeGPULocator, gpuType).click();
        logger.info("GPU type selected");
        return this;
    }


    public CloudGooglePlatformPricingCalculatorPage selectLocalSSD(String localSSD) {
        chooseLocalSSDField.click();
        waitClickable(localSSDLocator,localSSD).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectDataCenterLocation(String dataCenterLocation) {
        chooseDatacenterlocationField.click();
        waitClickable(datacenterLocationLocator,dataCenterLocation).click();
        logger.info("Local SSD selected");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectCommitedUsage(String committedUsage) {
        chooseCommitedUsageField.click();
        waitClickable(committedUsageLocator,committedUsage).click();
        logger.info("Datacenter location selected");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickButtonAddToEstimate() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonAddToEstimate));
        buttonAddToEstimate.click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickButtonEmailEstimate() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(emailEstimateBtn));
        emailEstimateBtn.click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage fillEmailField(String mailAddress) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(mailAddressField));
        mailAddressField.sendKeys(mailAddress);
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickSendEmailButton() {
        sendEmailBtn.click();
        logger.info("Email estimate sent");
        return this;
    }

    public double getTotalEstimatedMonthlyCost() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(estimatedCost));
        logger.info("Got total estimated monthly cost");
        return Double.parseDouble(estimatedCost.getText().substring(estimatedCost.getText().indexOf("USD") + 4,estimatedCost.getText().indexOf("per") -1)
                .replaceAll(",", ""));
    }
}
