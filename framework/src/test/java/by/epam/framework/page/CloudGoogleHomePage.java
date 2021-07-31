package by.epam.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractPage{
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();
    public static String searchText;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement chooseSearchBtn;

    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query' and @value=\"\"]")
    private WebElement searchField;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Google Cloud page opened");

        return this;
    }

    public CloudGoogleSearchPage makeSearch(String searchText)  {
        this.searchText = searchText;
        chooseSearchBtn.click();
        searchField.sendKeys(searchText);
        return new CloudGoogleSearchPage(driver);
    }
}
