package ta.training.page_object_model.page.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;

import java.time.Duration;

public class PasteBinHomePageTask2 extends BasePage {


    public static final String HOMEPAGE_URL = "https://pastebin.com/";
    @FindBy(id = "postform-text")
    private WebElement textAreaInput;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-format']//span[@class='selection']")
    private WebElement pasteFormatSpan;

    @FindBy(xpath = "//li[contains(@aria-label,'POPULAR LANGUAGES')]/ul/li[text()='Bash']")
    public WebElement bashFormatOption;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[@class='selection']")
    private WebElement pasteExpirationSpan;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']")
    public WebElement tenMinutesExpirationOption;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    public PasteBinHomePageTask2(WebDriver driver) {
        super(driver);
    }

    @Override
    public PasteBinHomePageTask2 openPage() {
        //using customs conditions
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public void fillPasteContent(String pasteContent) {
        sendKeysToInput(textAreaInput, pasteContent);
    }

    public void selectPasteExpiration(WebElement optionToSelect) {
        clickOnElement(pasteExpirationSpan);
        clickOnElement(optionToSelect);
    }

    public void selectSyntaxFormat(WebElement optionToSelect) {
        clickOnElement(pasteFormatSpan);
        clickOnElement(optionToSelect);
    }

    public String pasteName;

    public void fillPasteName(String pasteName) {
        this.pasteName = pasteName;
        sendKeysToInput(pasteNameInput, pasteName);
    }

    //it is ok for this method to return void because this is the end of the list of calls for the first task
    //in the future this method can be expanded so the return value will pass the driver to another page
    public PasteDetailsPage clickOnCreatePaste() {
        clickOnElement(createPasteButton);
        return new PasteDetailsPage(driver);
    }

}
