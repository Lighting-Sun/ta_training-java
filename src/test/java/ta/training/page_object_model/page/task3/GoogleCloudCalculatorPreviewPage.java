package ta.training.page_object_model.page.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class GoogleCloudCalculatorPreviewPage extends BasePage{

    @FindBy(xpath = "//h5[(text()='Total estimated cost')]/following-sibling::h4")
    private WebElement totalEstimatedCostValue;

    /**
     * Retrieves the text of the total estimated cost value.
     *
     * @return the text content of the total estimated cost value.
     */
    public String getTotalEstimatedCostValueText() {
        return totalEstimatedCostValue.getText();
    }

    /**
     * Finds a span element based on its preceding span's text.
     *
     * @param strSpanName the text of the preceding span element.
     * @return the WebElement of the span that follows the span with the given text.
     */
    private WebElement getSpanByName(String strSpanName) {
        return commonPageInteractions.getWebElement(By.xpath("//span[text()='" + strSpanName + "']/following-sibling::span"));
    }

    /**
     * Retrieves the text of a span element that follows a span with the given text.
     *
     * @param strSpanName the text of the preceding span element.
     * @return the text content of the span that follows the span with the given text.
     */
    public String getSpanTextByName(String strSpanName) {
        return commonPageInteractions.getWebElementText(getSpanByName(strSpanName));
    }

    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleCloudCalculatorPreviewPage(WebDriver driver) {
        super(driver);
    }



    @Override
    protected GoogleCloudCalculatorPreviewPage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }
}
