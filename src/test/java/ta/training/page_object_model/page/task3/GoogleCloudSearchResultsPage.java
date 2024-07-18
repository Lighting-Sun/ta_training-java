package ta.training.page_object_model.page.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudSearchResultsPage extends BasePage{


    /**
     * Constructor to initialize the WebDriver and common page interactions.
     *
     * @param driver the WebDriver instance to be used by this page object.
     */
    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Finds a search result element based on its text.
     *
     * @param strResultText the text of the search result.
     * @return the WebElement of the search result that matches the given text.
     */
    private WebElement getSearchResultByName(String strResultText) {
        logger.info("Getting search result element from result text "+ strResultText);
        return commonPageInteractions.getWebElement(By.xpath("//a[text()='" + strResultText + "']"));
    }

    /**
     * Clicks on a search result element based on its text.
     *
     * @param strResultText the text of the search result to be clicked.
     */
    public void clickOnSearchResult(String strResultText) {
        logger.info("Clicking on a search result from text " + strResultText);
        commonPageInteractions.clickOnElement(getSearchResultByName(strResultText));
    }

    /**
     * Checks for the presence of the search summary AI div element.
     *
     * @return true if the search summary AI div element is present, false otherwise
     */
    public boolean presenceOfSearchSummaryAiDiv() {
        return commonPageInteractions.waitUntilWebElementIsPresentByLocator(By.xpath("//div[@track-metadata-module='search-summary']"));
    }

    @Override
    protected GoogleCloudSearchResultsPage openPage() {
        throw new RuntimeException("This page should not be directly open by calling this method");
    }
}
