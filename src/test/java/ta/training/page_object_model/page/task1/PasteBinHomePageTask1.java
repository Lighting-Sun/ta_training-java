package ta.training.page_object_model.page.task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;

import java.time.Duration;

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

    public PasteBinHomePageTask1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PasteBinHomePageTask1 openPage (){
        //using customs conditions
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    private PasteBinHomePageTask1 sendKeysToInput(WebElement webElement, String content){
       WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable( webElement));
       element.click();
       element.sendKeys(content);
       return this;
    }

    private PasteBinHomePageTask1 clickOnElement(WebElement webElement){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return this;
    }

    public PasteBinHomePageTask1 fillPasteContent(String pasteContent){
        return sendKeysToInput(textAreaInput,pasteContent);
    }

    public PasteBinHomePageTask1 selectPasteExpiration(){
       return clickOnElement(pasteExpirationSpan).clickOnElement(tenMinutesExpirationOption);
    }

    public PasteBinHomePageTask1 fillPasteName (String pasteName){
        return sendKeysToInput(pasteNameInput,pasteName);
    }

    //it is ok for this method to return void because this is the end of the list of calls for the first task
    //in the future this method can be expanded so the return value will pass the driver to another page
    public void clickOnCreatePaste(){
        clickOnElement(createPasteButton);
    }

}
