package ta.training.page_object_model.page.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage openPage() {
        throw new RuntimeException("You need to provide a paste id");
    }
    protected BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void sendKeysToInput(WebElement webElement, String content){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable( webElement));
        element.click();
        element.sendKeys(content);
    }

    protected void clickOnElement(WebElement webElement){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }


}
