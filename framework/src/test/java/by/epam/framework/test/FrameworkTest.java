package by.epam.framework.test;
import by.epam.framework.model.ComputerEngine;
import by.epam.framework.page.CloudGoogleHomePage;
import by.epam.framework.page.CloudGooglePlatformPricingCalculatorPage;
import by.epam.framework.page.TenMinutEmailPage;
import by.epam.framework.service.TestDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkTest extends CommonConditions {
    ComputerEngine computerEngine = TestDataCreator.getTestingData();
    protected static final String TEXT_FOR_SEARCH = "Google Cloud Platform Pricing Calculator";

    @Test(description = "Google cloud calculator and email estimate test")
    public void cloudGoogleSelectedOptionTest() {
        CloudGooglePlatformPricingCalculatorPage cloudGooglePricingCalculatorTest = new CloudGoogleHomePage(driver)
                .openPage()
                .makeSearch(TEXT_FOR_SEARCH+"\n")
                .chooseSearchResult()
                .selectComputeEngineSection()
                .setNumberOfInstances(computerEngine.getNumberOfInstance())
                .selectOSAndSoftware(computerEngine.getOSAndSoftware())
                .selectMachineClass(computerEngine.getMachineClass())
                .selectMachineSeries(computerEngine.getMachineSeries())
                .selectMachineType(computerEngine.getMachineType())
                .setNumberOfGPUs(computerEngine.getNumberOfGPUs())
                .addGPUs(computerEngine.getGpuType())
                .selectLocalSSD(computerEngine.getLocalSSD())
                .selectDataCenterLocation(computerEngine.getDataCenterLocation())
                .selectCommitedUsage(computerEngine.getCommittedUsage())
                .clickButtonAddToEstimate();

        double totalEstimatedMonthlyCost = cloudGooglePricingCalculatorTest.getTotalEstimatedMonthlyCost();

        cloudGooglePricingCalculatorTest.createNewTab();
        cloudGooglePricingCalculatorTest.switchNextTab();
        TenMinutEmailPage tenMinuteEmail = new TenMinutEmailPage(driver);
        String mailAddress = tenMinuteEmail
                .openPage()
                .copyMailAddress();

        cloudGooglePricingCalculatorTest.switchPrevTab();

        cloudGooglePricingCalculatorTest
                .clickButtonEmailEstimate()
                .fillEmailField(mailAddress)
                .clickSendEmailButton();

        cloudGooglePricingCalculatorTest.switchNextTab();

        double totalEstimatedMonthlyCostFromEmail = tenMinuteEmail.openMail().getTotalEstimatedMonthlyCostFromEmail();

        Assert.assertEquals(totalEstimatedMonthlyCostFromEmail, totalEstimatedMonthlyCost);
    }
}
