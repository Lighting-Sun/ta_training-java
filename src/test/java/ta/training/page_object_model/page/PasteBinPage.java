package ta.training.page_object_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ta.training.CustomConditions;

import java.time.Duration;

public class PasteBinPage {

    private WebDriver driver;

    public static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement textAreaInput;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[@class='selection']")
    private WebElement pasteExpirationSpan;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/li[text()='10 Minutes']")
    private WebElement TenMinutesExpirationOption;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    public PasteBinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PasteBinPage openPage (){
        //using customs conditions
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

}
