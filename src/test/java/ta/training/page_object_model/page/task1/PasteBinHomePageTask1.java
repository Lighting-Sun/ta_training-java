package ta.training.page_object_model.page.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;

import java.time.Duration;

/**
 * This class represents the home page task for PasteBin, providing methods
 * to interact with the web elements on the home page using Selenium WebDriver.
 *
 * @author Harvey C
 */
public class PasteBinHomePageTask1 {

    private WebDriver driver;

    public static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement textAreaInput;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[@class='selection']")
    private WebElement pasteExpirationSpan;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']")
    private WebElement tenMinutesExpirationOption;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    /**
     * Constructor to initialize the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance used to interact with the web page
     */
    public PasteBinHomePageTask1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the PasteBin home page and waits for jQuery AJAX requests to complete.
     */
    public void openPage() {
        // using custom conditions
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
    }

    /**
     * Sends the specified content to the given web element after waiting for it to be clickable.
     *
     * @param webElement the web element to send keys to
     * @param content the content to send to the web element
     */
    private void sendKeysToInput(WebElement webElement, String content) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        element.sendKeys(content);
    }

    /**
     * Clicks on the given web element after waiting for it to be clickable.
     *
     * @param webElement the web element to click on
     */
    private void clickOnElement(WebElement webElement) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }

    /**
     * Fills the paste content text area with the specified content.
     *
     * @param pasteContent the content to be pasted in the text area
     */
    public void fillPasteContent(String pasteContent) {
        sendKeysToInput(textAreaInput, pasteContent);
    }

    /**
     * Selects the paste expiration option of 10 minutes.
     */
    public void selectPasteExpiration() {
        clickOnElement(pasteExpirationSpan);
        clickOnElement(tenMinutesExpirationOption);
    }

    /**
     * Fills the paste name input field with the specified paste name.
     *
     * @param pasteName the name to be entered in the paste name input field
     */
    public void fillPasteName(String pasteName) {
        sendKeysToInput(pasteNameInput, pasteName);
    }

    /**
     * Clicks on the create paste button to submit the paste.
     */
    public void clickOnCreatePaste() {
        clickOnElement(createPasteButton);
    }
}
