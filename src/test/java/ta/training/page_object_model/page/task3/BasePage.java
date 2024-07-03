package ta.training.page_object_model.page.task3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ta.training.utilities.CommonPageInteractions;

/**
 * Abstract base class for all page objects. Provides common functionality and serves as a parent class
 * for all specific page objects in the web application.
 * <p>
 * This class handles the initialization of the WebDriver and common page interactions.
 * </p>
 *
 * @author Harvey C
 */
public abstract class BasePage {

    /** The WebDriver instance used to interact with the web browser. */
    protected WebDriver driver;

    /** Common page interactions helper. */
    protected CommonPageInteractions commonPageInteractions;

    /**
     * Opens the specific page. Must be implemented by all subclasses.
     *
     * @return the instance of the page that is opened.
     */
    protected abstract BasePage openPage();

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commonPageInteractions = new CommonPageInteractions(this.driver);
    }
}
