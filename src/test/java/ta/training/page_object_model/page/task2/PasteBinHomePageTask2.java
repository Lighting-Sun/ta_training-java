package ta.training.page_object_model.page.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;

import java.time.Duration;

/**
 * This class represents the home page of PasteBin for task 2. It provides methods to interact with
 * the PasteBin home page elements, such as filling in the paste content, selecting paste expiration,
 * selecting paste format, filling in the paste name, and creating a new paste.
 * <p>
 * This class extends the {@link BasePage} class.
 * </p>
 *
 * @author Harvey C
 */
public class PasteBinHomePageTask2 extends BasePage {

    public static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement textAreaInput;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-format']//span[@class='selection']")
    private WebElement pasteFormatSpan;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[@class='selection']")
    private WebElement pasteExpirationSpan;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    @FindBy(xpath = "//vli[@class='vliIgnore']")
    private WebElement closeBottomAddButton;

    /**
     * Constructor to initialize the WebDriver and the PasteBinHomePageTask2 page elements.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public PasteBinHomePageTask2(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the PasteBin home page and waits for the jQuery AJAX calls to complete.
     *
     * @return the current instance of {@link PasteBinHomePageTask2}.
     */
    @Override
    public PasteBinHomePageTask2 openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    /**
     * Fills the paste content in the text area input.
     *
     * @param pasteContent the content to be pasted.
     */
    public void fillPasteContent(String pasteContent) {
        commonPageInteractions.sendTextToInput(textAreaInput, pasteContent);
    }

    /**
     * Selects the paste expiration option from the dropdown.
     *
     * @param expirationOption the expiration option to be selected.
     */
    public void selectPasteExpiration(String expirationOption) {
        String xPath = "//ul[@id='select2-postform-expiration-results']/li[text()='" + expirationOption + "']";
        commonPageInteractions.clickOnElement(pasteExpirationSpan);
        commonPageInteractions.clickOnElement(driver.findElement(By.xpath(xPath)));
    }

    /**
     * Clicks on a specific paste format option from the dropdown.
     *
     * @param optionToSelect the format option to be selected.
     */
    public void clickSpecificFormatOption(String optionToSelect) {
        String xPath = "//li[contains(@aria-label,'POPULAR LANGUAGES')]/ul/li[text()='" + optionToSelect + "']";
        commonPageInteractions.clickOnElement(pasteFormatSpan);
        commonPageInteractions.clickOnElement(driver.findElement(By.xpath(xPath)));
    }

    /**
     * Fills the paste name in the input field.
     *
     * @param pasteName the name of the paste.
     */
    public void fillPasteName(String pasteName) {
        commonPageInteractions.sendTextToInput(pasteNameInput, pasteName);
    }

    /**
     * Clicks on the create paste button to submit the paste.
     * If an exception occurs, it clicks on the close bottom ad button
     * and retries clicking on the create paste button.
     */
    public void clickOnCreatePaste() {
        try {
            commonPageInteractions.clickOnElement(createPasteButton);
        } catch (Exception e) {
            commonPageInteractions.clickOnElement(closeBottomAddButton);
            commonPageInteractions.clickOnElement(createPasteButton);
        }
    }
}
