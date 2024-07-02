package ta.training.page_object_model.page.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class represents the details page of a paste on PasteBin. It provides methods to interact with
 * and retrieve information from the PasteBin paste details page.
 * <p>
 * This class extends the {@link BasePage} class.
 * </p>
 *
 * @author Harvey C
 */
public class PasteDetailsPage extends BasePage {

    /**
     * Constructor to initialize the WebDriver and the PasteDetailsPage page elements.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public PasteDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='top-buttons']//a[contains(@class,'btn -small')]")
    private WebElement codeStyle;

    @FindBy(xpath = "//div[@class='source bash']/ol/li//div")
    private List<WebElement> textLines;

    /**
     * Retrieves the text content from the paste's text box, concatenating all lines into a single string.
     * Each line is separated by a newline character.
     *
     * @return the text content from the paste's text box.
     */
    public String getTextFromTextBox() {
        int lastTextLine = textLines.size() - 1;
        WebElement lastLine = textLines.get(lastTextLine);
        StringBuilder result = new StringBuilder();
        for (WebElement element : textLines) {
            String divText = element.getText();
            result.append(divText);
            if (!element.equals(lastLine)) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Checks if the code style on the page matches the specified format.
     *
     * @param formatToCompareTo the format to compare the code style to.
     * @return true if the code style matches the specified format, false otherwise.
     */
    public boolean checkTextFormatMatches(String formatToCompareTo) {
        return codeStyle.getText().equals(formatToCompareTo);
    }

    /**
     * This method is not used as this page should only be opened as a result of successfully creating a paste.
     *
     * @throws RuntimeException always thrown to indicate this page should not be opened directly.
     */
    @Override
    public BasePage openPage() {
        throw new RuntimeException("This page should only be opened as a result of creating a page successfully");
    }
}
