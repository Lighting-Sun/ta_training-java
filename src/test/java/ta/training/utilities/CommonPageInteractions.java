package ta.training.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class provides common interactions with web elements on a web page.
 * It includes methods for sending text to input fields and clicking on elements.
 * <p>
 * These interactions are facilitated using the WebDriver instance.
 * </p>
 *
 * @author Harvey C
 */
public class CommonPageInteractions {

    /** The WebDriver instance used to interact with the web browser. */
    private final WebDriver driver;

    /**
     * Constructor to initialize the WebDriver for common page interactions.
     *
     * @param driver the WebDriver instance to be used by this class.
     */
    public CommonPageInteractions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sends the specified text content to the given web element (input field).
     * Waits until the element is clickable before performing the action.
     *
     * @param webElement the web element (input field) to send the text to.
     * @param content the text content to be sent.
     */
    public void sendKeysToInput(WebElement webElement, String content) {
        WebElement element = new WebDriverWait(this.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        element.sendKeys(content);
    }

    /**
     * Clicks on the given web element.
     * Waits until the element is clickable before performing the action.
     *
     * @param webElement the web element to be clicked.
     */
    public void clickOnElement(WebElement webElement) {
        WebElement element = new WebDriverWait(this.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }
}
