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
        logger.info("The total Estimated Cost Value is: " + totalEstimatedCostValue.getText());
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
        logger.info("Text from span "+ strSpanName+ " is: "+ commonPageInteractions.getWebElementText(getSpanByName(strSpanName)));
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

    /**
     * Checks for the presence of the "Cost Estimate Summary" H4 element.
     *
     * @return true if the H4 element is present, false otherwise
     */
    public boolean presenceOfCostEstimateSummaryH4(){
        return commonPageInteractions.waitUntilWebElementIsPresentByLocator(By.xpath("//h4[text()='Cost Estimate Summary']"));
    }

    @Override
    protected GoogleCloudCalculatorPreviewPage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }
}
