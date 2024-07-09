package ta.training.page_object_model.page.task3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends BasePage{

    public static final String GOOGLE_CLOUD_PAGE = "https://cloud.google.com";



    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search']/ancestor::form/ancestor::div[contains(@jsaction,'click')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    /**
     * Performs the search action based on a text input
     *
     * @param textToSearch the WebDriver instance to be used by this page object.
     */
    public void searchText(String textToSearch){
        commonPageInteractions.clickOnElement(searchButton);
        commonPageInteractions.sendTextToInput(searchInput,textToSearch);
        commonPageInteractions.sendKeysToInput(searchInput, Keys.ENTER);
    }

    /**
     * Opens the Google Cloud Home Page.
     *
     * @return the instance of GoogleCloudHomePage.
     */
    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_PAGE);
        return this;
    }
}
